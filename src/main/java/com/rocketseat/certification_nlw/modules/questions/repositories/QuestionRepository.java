package com.rocketseat.certification_nlw.modules.questions.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocketseat.certification_nlw.modules.questions.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, UUID> {

    List<Question> findByTechnology(String technology);

}
