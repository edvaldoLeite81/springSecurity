package com.mballem.curso.security.service;

import com.mballem.curso.security.domain.Especialidade;
import com.mballem.curso.security.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Transactional()
    public void salvar(Especialidade especialidade){
        especialidadeRepository.save(especialidade);
    }
}
