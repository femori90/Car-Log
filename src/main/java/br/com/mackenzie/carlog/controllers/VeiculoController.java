package br.com.mackenzie.carlog.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import br.com.mackenzie.carlog.models.Veiculo;
import br.com.mackenzie.carlog.service.VeiculoService;
import jakarta.validation.Valid;

@Controller
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping("/lista-veiculos")
    public ModelAndView listUsers() {
        return new ModelAndView(
                "veiculos/lista",
                Map.of("veiculos", veiculoService.findAll()));
    }

    @GetMapping("/create-veiculo")
    public ModelAndView create() {
        return new ModelAndView(
                "veiculos/cadastro",
                Map.of("veiculo", new Veiculo()));
    }

    @PostMapping("/create-veiculo")
    public String create(@Valid Veiculo veiculo, BindingResult result) {

        if (result.hasErrors()) {
            return "veiculos/cadastro";
        }

        veiculoService.save(veiculo);
        return "redirect:/lista-veiculos";
    }

    @GetMapping("/update-veiculo/{id}")
    public ModelAndView update(@PathVariable Integer id) {
        var veiculo = veiculoService.findById(id);

        if (veiculo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ModelAndView(
                "veiculos/cadastro",
                Map.of("veiculo", veiculo.get()));
    }

    @PostMapping("/update-veiculo/{id}")
    public String update(@PathVariable Integer id, Veiculo veiculo, BindingResult result) {

        if (result.hasErrors()) {
            return "veiculos/cadastro";
        }

        veiculoService.update(id, veiculo);
        return "redirect:/lista-veiculos";
    }

    @GetMapping("/delete-veiculo/{id}")
    public ModelAndView delete(@PathVariable Integer id) {
        var veiculo = veiculoService.findById(id);

        if (veiculo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ModelAndView(
                "veiculos/remover",
                Map.of("veiculo", veiculo.get()));
    }

    @PostMapping("/delete-veiculo/{id}")
    public String delete(Veiculo veiculo) {
        veiculoService.delete(veiculo);
        return "redirect:/lista-veiculos";
    }
}
