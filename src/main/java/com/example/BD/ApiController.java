package com.example.BD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api/curso")
public class ApiController {
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping(path="/nuevo")
    public @ResponseBody String addNewCurso (@RequestParam String nombre, @RequestParam Integer creditos) {
        Curso n = new Curso();
        n.setNombre(nombre);
        n.setCreditos(creditos);
        cursoRepository.save(n);
        return "Saved";
    }

    @DeleteMapping(path="/eliminar")
    public @ResponseBody String delCurso (@RequestParam Integer id) {
        cursoRepository.deleteById(id);
        return "Deleted";
    }

    @GetMapping(path="/listar")
    public @ResponseBody Iterable<Curso> getAllCursos() {
        return cursoRepository.findAll();
    } 
}
