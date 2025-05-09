package com.tuempresa.superheroes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cebem.medidor.models.Superheroe;

@Controller
@RequestMapping("/superheroes")
@RequiredArgsConstructor
public class SuperheroeController {

    private final com.cebem.medidor.services.superheroeService superheroeService;

    @GetMapping
    public String listarSuperheroes(Model model) {
        model.addAttribute("superheroes", superheroeService.listarTodos());
        return "superheroes";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("superheroe", new com.cebem.medidor.models.Superheroe());
        return "formulario_superheroe";
    }

    @PostMapping("/guardar")
    public String guardarSuperheroe(@ModelAttribute Superheroe superheroe) {
        superheroeService.guardar(superheroe);
        return "redirect:/superheroes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Superheroe superheroe = superheroeService.obtenerPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("superheroe", superheroe);
        return "formulario_superheroe";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarSuperheroe(@PathVariable Long id) {
        superheroeService.eliminar(id);
        return "redirect:/superheroes";
    }
}


