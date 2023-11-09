package com.projetoAPIcursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoAPIcursos.entities.Cursos;
import com.projetoAPIcursos.services.CursosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@Tag(name = "Livros", description = "API REST DE GERENCIAMENTO DE CLIENTES")
@RestController
@RequestMapping("/cursos")
public class CursosController {
	private final CursosService cursoService;

    @Autowired
    public CursosController(CursosService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Localizar curso por ID")
    public ResponseEntity<Cursos> buscaCursosControlId (@PathVariable Long id){
    	Cursos cursos = cursoService.buscaCursosId(id);
    	if(cursos != null) {
    		return ResponseEntity.ok(cursos);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @GetMapping
    @Operation(summary = "Apresenta todos os Cursos")
    public ResponseEntity<List<Cursos>> buscaTodosCursossControl(){
    	List<Cursos> cursos = cursoService.buscaTodosCursos();
    	return ResponseEntity.ok(cursos);
    }
    @PostMapping
    @Operation(summary = "Cadastra um curso")
    public ResponseEntity<Cursos> salvaCursosControl(@RequestBody @Valid Cursos cursos){
    	Cursos salvaCursos = cursoService.saveCursos(cursos);
    	return ResponseEntity.status(HttpStatus.CREATED).body(salvaCursos);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Altera um curso")
    public ResponseEntity<Cursos> alterarCursosControl(@PathVariable Long id, @RequestBody @Valid Cursos curso){
    	Cursos alterarCursos = cursoService.alterarCursos(id, curso);
    	if (alterarCursos != null) {
    		return ResponseEntity.ok(curso);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um curso")
    public ResponseEntity<String> apagaCursosControl(@PathVariable Long id){
    	boolean apagar = cursoService.apagarCursos(id);
    	if(apagar) {	
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    	}
    	else {
    		return ResponseEntity.notFound().build();    	
    	}
    }
}