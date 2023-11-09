package com.projetoAPIcursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoAPIcursos.entities.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, Long>{

}
