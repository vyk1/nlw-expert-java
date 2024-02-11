package com.rocketseat.certification_nlw.modules.certifications.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.certifications.useCases.TopTenRankingUseCase;
import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudent;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private TopTenRankingUseCase topTenRankingUseCase;

    @GetMapping("/top-10")
    public List<CertificationStudent> topTen() {
        return topTenRankingUseCase.execute();
    }
}
