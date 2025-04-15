package br.com.mackenzie.carlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.mackenzie.carlog.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByEmail(String email);

    public Usuario findByCpf(String cpf);

    @Query("select u from Usuario u where u.email = :user and u.senha = :senha")
    public Usuario buscarLogin(String user, String senha);
}
