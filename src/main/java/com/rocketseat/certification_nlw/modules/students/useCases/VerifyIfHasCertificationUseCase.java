package com.rocketseat.certification_nlw.modules.students.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketseat.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.repositories.CertificationStudentRepository;

@Service // @Service annotation is used with classes that provide some business functionalities.
public class VerifyIfHasCertificationUseCase {

    @Autowired
    private CertificationStudentRepository repo;

    public boolean execute(VerifyHasCertificationDTO dto) {
        var res = repo.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        // Se a lista estiver vazia, significa que não há certificação
        // e o estudante pode realizar a prova
        if(res.isEmpty()) {
            return false;
        }
        return true;
    }
    
}
