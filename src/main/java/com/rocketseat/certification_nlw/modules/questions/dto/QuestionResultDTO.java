package com.rocketseat.certification_nlw.modules.questions.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // enables entity to be built using a builder pattern
public class QuestionResultDTO {
    private UUID id;
    private String technology;
    private String description;

    private List<AlternativesResultDTO> alternatives;
    
}
