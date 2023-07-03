package com.example.BD;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path="/")
public class Controller {
    private final String codigo = "SM75504185";
    private final String nombre = "Alfred";
    
    @GetMapping(path="/")
    public String home() {
        String codigoNombre = codigo + " - " + nombre;
        return codigoNombre;
    }
    
    @GetMapping(path="/nombre")
    public String mostrarNombre() {
        return nombre;
    }
    
    @GetMapping(path="/codigo")
    public String mostrarCodigo() {
        return codigo;
    }
}
