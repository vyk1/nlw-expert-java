package com.rocketseat.certification_nlw.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.students.dto.StudentCertificationAnswersDTO;
import com.rocketseat.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudent;
import com.rocketseat.certification_nlw.modules.students.useCases.StudentCertificationAnswersUseCase;
import com.rocketseat.certification_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationUseCase useCase;

    @Autowired
    private StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

    @PostMapping("/verify-if-has-certification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO dto) {
        if (useCase.execute(dto)) {
            return "Has certification";
        }
        return "Does not have certification";
    }

    @PostMapping("/certification/answer")
    public CertificationStudent getStudentCertificationAnswersDTO(@RequestBody StudentCertificationAnswersDTO dto)
            throws Exception {
        return studentCertificationAnswersUseCase.execute(dto);
    }
}
