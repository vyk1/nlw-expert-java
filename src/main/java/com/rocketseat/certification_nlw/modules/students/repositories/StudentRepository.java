package com.rocketseat.certification_nlw.modules.students.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocketseat.certification_nlw.modules.students.entities.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    // Optional is a container object which may or may not contain a non-null value.
    // Enabled @ java 8
    public Optional<Student> findByEmail(String email);
}
