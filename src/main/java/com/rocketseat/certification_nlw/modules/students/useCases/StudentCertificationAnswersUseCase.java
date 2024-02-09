package com.rocketseat.certification_nlw.modules.students.useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketseat.certification_nlw.modules.questions.entities.Question;
import com.rocketseat.certification_nlw.modules.questions.repositories.QuestionRepository;
import com.rocketseat.certification_nlw.modules.students.dto.StudentCertificationAnswersDTO;
import com.rocketseat.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.entities.AnswersCertifications;
import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudent;
import com.rocketseat.certification_nlw.modules.students.entities.Student;
import com.rocketseat.certification_nlw.modules.students.repositories.CertificationStudentRepository;
import com.rocketseat.certification_nlw.modules.students.repositories.StudentRepository;

@Service
public class StudentCertificationAnswersUseCase {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private CertificationStudentRepository certificationStudentRepo;

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    public CertificationStudent execute(StudentCertificationAnswersDTO dto) throws Exception {

        var hasCertification = verifyIfHasCertificationUseCase
                .execute(new VerifyHasCertificationDTO(dto.getEmail(), dto.getTechnology()));
        if (hasCertification) {
            throw new Exception("Student already has certification");
        }

        List<Question> questions = questionRepo.findByTechnology(dto.getTechnology());
        List<AnswersCertifications> answersCertifications = new ArrayList<>();
        AtomicInteger correctAnswersCounter = new AtomicInteger(0); // to enable incrementing inside lambda

        dto.getQuestionsAnswers()
                .stream().forEach(qa -> {
                    var question = questions.stream().filter(q -> q.getId().equals(qa.getQuestionId())).findFirst()
                            .get();

                    var correctAlternative = question.getAlternatives().stream().filter(a -> a.isCorrect()).findFirst()
                            .get();

                    if (correctAlternative.getId().equals(qa.getAlternativeId())) {
                        qa.setCorrect(true);
                        correctAnswersCounter.getAndIncrement();
                    } else {
                        qa.setCorrect(false);
                    }
                    var ac = AnswersCertifications.builder()
                            .answerId(qa.getAlternativeId())
                            .questionId(qa.getQuestionId())
                            .isCorrect(qa.isCorrect())
                            .build();

                    answersCertifications.add(ac);
                });

        var student = studentRepo.findByEmail(dto.getEmail());
        UUID studentId;
        if (student.isEmpty()) {
            var stu = studentRepo.save(Student.builder().email(dto.getEmail()).build());
            var studentCreated = studentRepo.save(stu);
            studentId = studentCreated.getId();
        } else {
            studentId = student.get().getId();
        }

        CertificationStudent cs = CertificationStudent.builder()
                .technology(dto.getTechnology())
                .grade(correctAnswersCounter.get())
                .studentId(studentId).build();

        var certification = certificationStudentRepo.save(cs);

        answersCertifications.stream().forEach(ac -> {
            ac.setCertificationId(certification.getId());
            ac.setCertificationStudent(cs);
        });

        certification.setAnswersCertifications(answersCertifications);

        certificationStudentRepo.save(certification);

        return certification;
    }
}
