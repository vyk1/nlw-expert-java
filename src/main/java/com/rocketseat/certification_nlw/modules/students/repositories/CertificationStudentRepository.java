package com.rocketseat.certification_nlw.modules.students.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudent;

@Repository // not required
public interface CertificationStudentRepository extends JpaRepository<CertificationStudent, UUID> {

    List<CertificationStudent> findByStudentEmailAndTechnology(String email, String technology);
}
