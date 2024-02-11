package com.rocketseat.certification_nlw.modules.questions.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.questions.dto.AlternativesResultDTO;
import com.rocketseat.certification_nlw.modules.questions.dto.QuestionResultDTO;
import com.rocketseat.certification_nlw.modules.questions.entities.Alternatives;
import com.rocketseat.certification_nlw.modules.questions.entities.Question;
import com.rocketseat.certification_nlw.modules.questions.repositories.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository repo;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology) {
        return repo.findByTechnology(technology).stream().map(q -> toDTO(q)).collect(Collectors.toList());
    }

    static QuestionResultDTO toDTO(Question question) {

        List<AlternativesResultDTO> alternativesDto = question.getAlternatives().stream().map(a -> toDTO(a))
                .collect(Collectors.toList());

        var questionDto = QuestionResultDTO.builder()
                .id(question.getId())
                .technology(question.getTechnology())
                .description(question.getDescription())
                .build();

        questionDto.setAlternatives(alternativesDto);
        return questionDto;
    }

    static AlternativesResultDTO toDTO(Alternatives alternative) {
        return AlternativesResultDTO.builder()
                .id(alternative.getId())
                .description(alternative.getDescription())
                .build();
    }
}
