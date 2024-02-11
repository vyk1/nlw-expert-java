package com.rocketseat.certification_nlw.modules.certifications.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudent;
import com.rocketseat.certification_nlw.modules.students.repositories.CertificationStudentRepository;

@Service
public class TopTenRankingUseCase {
    @Autowired
    private CertificationStudentRepository certificationStudentRepo;

    public List<CertificationStudent> execute() {
        return certificationStudentRepo.findTop10ByOrderByGradeDesc();
    }
}
