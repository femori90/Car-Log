package br.com.mackenzie.carlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mackenzie.carlog.models.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    Veiculo findByPlaca(String placa);
}
