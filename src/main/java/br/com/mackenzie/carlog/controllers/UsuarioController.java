package br.com.mackenzie.carlog.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import br.com.mackenzie.carlog.models.Usuario;
import br.com.mackenzie.carlog.service.UsuarioService;
import jakarta.validation.Valid;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/lista-usuarios")
    public ModelAndView listUsers() {
        return new ModelAndView(
                "usuarios/lista",
                Map.of("usuarios", usuarioService.findAll()));
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView(
                "usuarios/cadastro",
                Map.of("usuario", new Usuario()));
    }

    @PostMapping("/create")
    public String create(@Valid Usuario usuario, BindingResult result) throws NoSuchAlgorithmException {

        if (result.hasErrors()) {
            return "usuarios/cadastro";
        }

        usuarioService.save(usuario);
        return "redirect:/lista-usuarios";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Integer id) {
        var usuario = usuarioService.findById(id);

        if (usuario.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ModelAndView(
                "usuarios/cadastro",
                Map.of("usuario", usuario.get()));
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, Usuario usuario, BindingResult result) throws NoSuchAlgorithmException {

        if (result.hasErrors()) {
            return "usuarios/cadastro";
        }

        usuarioService.update(id, usuario);
        return "redirect:/lista-usuarios";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id) {
        var usuario = usuarioService.findById(id);

        if (usuario.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ModelAndView(
                "usuarios/remover",
                Map.of("usuario", usuario.get()));
    }

    @PostMapping("/delete/{id}")
    public String delete(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/lista-usuarios";
    }

    @GetMapping("/update-password/{id}")
    public ModelAndView alterarSenha(@PathVariable Integer id) {
        var usuario = usuarioService.findById(id);

        if (usuario.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ModelAndView(
                "usuarios/alterarSenha",
                Map.of("usuario", usuario.get()));
    }

    @PostMapping("/update-password/{id}")
    public String alterarSenha(@PathVariable Integer id, @RequestBody String senha) throws NoSuchAlgorithmException {

        var usuarioEncontrado = usuarioService.findById(id);

        if (usuarioEncontrado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        var novaSenha = senha.split("=");
        var usuarioSenha = usuarioEncontrado.get();
        usuarioSenha.setSenha(novaSenha[1]);

        usuarioService.update(id, usuarioSenha);
        return "redirect:/lista-usuarios";
    }
}
