package br.com.mackenzie.carlog.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mackenzie.carlog.models.Login;
import br.com.mackenzie.carlog.models.Usuario;
import br.com.mackenzie.carlog.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView(
                "login",
                Map.of("login", new Login()));
    }

    @GetMapping("/home")
    public ModelAndView listUsers() {
        return new ModelAndView(
                "home",
                Map.of("usuarios", usuarioService.findAll()));
    }

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView(
                "home",
                Map.of("usuarios", usuarioService.findAll()));
    }

    @PostMapping("/login")
    public ModelAndView login(Login login, BindingResult result, HttpSession session)
            throws NoSuchAlgorithmException {
        ModelAndView mv = new ModelAndView();

        mv.addObject("login", new Login());

        if (result.hasErrors()) {
            mv.setViewName("login");
        }

        Usuario userLogin = usuarioService.loginUser(login.getUsuario(), login.getPassword());

        if (userLogin == null) {
            mv.addObject("msg", "Usuário não encontrado. Tente novamente!");
            mv.setViewName("login");
        } else {
            session.setAttribute("usuarioLogado", userLogin);
            return listUsers();
        }

        return mv;
    }
}
