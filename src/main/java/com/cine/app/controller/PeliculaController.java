package com.cine.app.controller;

import com.cine.app.model.Pelicula;
import com.cine.app.repository.GeneroRepository;
import com.cine.app.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("peliculas", peliculaRepository.findAll());
        return "lista"; 
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("generos", generoRepository.findAll());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarPelicula(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
        return "redirect:/peliculas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Pelicula pelicula = peliculaRepository.findById(id).orElse(null);
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoRepository.findAll());
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        peliculaRepository.deleteById(id);
        return "redirect:/peliculas";
    }
}