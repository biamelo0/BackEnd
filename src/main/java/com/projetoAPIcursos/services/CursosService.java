package com.projetoAPIcursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.projetoAPIcursos.entities.Cursos;
import com.projetoAPIcursos.repository.CursosRepository;

@Service
public class CursosService {
    private final CursosRepository cursosRepository;
	private CrudRepository<Cursos, Long> cursoRepository;

    @Autowired
    public CursosService(CursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;
    }

    public Cursos saveCursos(Cursos cursos) {
        return cursosRepository.save(cursos);
    }

    public Cursos getCursosById(Long id) {
        return cursosRepository.findById(id).orElse(null);
    }

    public List<Cursos> buscaTodosCursos() {
        return cursosRepository.findAll();
    }
    
    public Cursos buscaCursosId(Long id) {
       Optional <Cursos> cursos = cursosRepository.findById(id);
       return cursos.orElse(null);
    }
    public Cursos SalvaCursos(Cursos cursos) {
    	return cursosRepository.save(cursos);
    }
    public Cursos alterarCursos (Long id, Cursos alterarCursos) {
    	Optional <Cursos> existeCursos = cursosRepository.findById(id);
    	if (existeCursos.isPresent()) {
    		alterarCursos.setId(id);
    		return cursoRepository.save(alterarCursos);
    	}
    	return null;
    }
    public boolean apagarCursos(Long id) {
    	Optional <Cursos> existeCursos = cursosRepository.findById(id);
    	if (existeCursos.isPresent()) {
    		cursosRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
}
