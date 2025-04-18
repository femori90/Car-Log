package br.com.mackenzie.carlog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.mackenzie.carlog.models.Veiculo;
import br.com.mackenzie.carlog.repositories.VeiculoRepository;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo save(Veiculo veiculo) {

        placaExiste(veiculo);

        veiculo.setPlaca(veiculo.getPlaca().toUpperCase());

        return veiculoRepository.save(veiculo);
    }

    public void delete(Veiculo veiculo) {

        veiculoRepository.delete(veiculo);
    }

    public Optional<Veiculo> findById(Integer id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo update(Integer id, Veiculo veiculo) {

        var veiculoCadastrado = veiculoRepository.findById(id);

        if (veiculoCadastrado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (!veiculoCadastrado.get().getPlaca().equals(veiculo.getPlaca())) {
            placaExiste(veiculo);
        }

        return veiculoRepository.save(veiculo);
    }

    public Veiculo findByPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa.toUpperCase());
    }

    private void placaExiste(Veiculo veiculo) {
        var veiculoPlaca = veiculoRepository.findByPlaca(veiculo.getPlaca().toUpperCase());

        if (veiculoPlaca != null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Placa já cadastrada no banco de dados!");

        }
    }
}
