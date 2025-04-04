package br.com.mackenzie.carlog.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mackenzie.carlog.repositories.UsuarioRepository;

@Controller
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/")
    public ModelAndView listUsers(){
        return new ModelAndView(
            "usuarios/lista",
            Map.of("usuarios", usuarioRepository.findAll()));
    }
}
