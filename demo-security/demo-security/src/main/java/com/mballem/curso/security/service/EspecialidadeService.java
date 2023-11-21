package com.mballem.curso.security.service;

import com.mballem.curso.security.datatables.Datatables;
import com.mballem.curso.security.datatables.DatatablesColunas;
import com.mballem.curso.security.domain.Especialidade;
import com.mballem.curso.security.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private Datatables datatables;

    @Transactional()
    public void salvar(Especialidade especialidade) {
        especialidadeRepository.save(especialidade);
    }

    @Transactional(readOnly = true)
    public Map<String, Object> buscarEspecialidades(HttpServletRequest request) {
       datatables.setRequest(request);
       datatables.setColunas(DatatablesColunas.ESPECIALIDADES);
       Page<?> page = datatables.getSearch().isEmpty()
               ? especialidadeRepository.findAll(datatables.getPageable())
               : especialidadeRepository.findAllByTitulo(datatables.getSearch(), datatables.getPageable());

        return datatables.getResponse(page);
    }

    @Transactional(readOnly = true)
    public Especialidade buscarPorId(Long id){
        return especialidadeRepository.findById(id).get();
    }

    public void remover(Long id) {
      especialidadeRepository.deleteById(id);
    }
}
