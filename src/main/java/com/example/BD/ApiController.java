package com.example.BD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
// imports for use List, Map, String and Object
import java.util.List;
import java.util.Map;
import java.lang.String;
import java.lang.Object;

import org.springframework.jdbc.core.JdbcTemplate;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/api/curso") // This means URL's start with /demo (after Application path)
public class ApiController {
	@Autowired // This means to get the bean called userRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private CursoRepository cursoRepository;

	@Autowired
  	private JdbcTemplate jdbcTemplate; 

	@PostMapping(path="/nuevo") // Map ONLY POST Requests
	public @ResponseBody String addNewCurso (@RequestParam String nombre
			, @RequestParam Integer creditos) {
		Curso n = new Curso();
		n.setNombre(nombre);
		n.setCreditos(creditos);
		cursoRepository.save(n);
		return "Saved";
	}

	@DeleteMapping(path="/eliminar")
	public @ResponseBody String delCurso (@RequestParam Integer id) {
		Curso n = new Curso();
		n.setId(id);
		cursoRepository.delete(n);
		return "Deleted";
	}


	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Curso> getAllCursos() {
		return cursoRepository.findAll();
	} 

}