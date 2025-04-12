package br.com.mackenzie.carlog.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.mackenzie.carlog.models.Usuario;
import br.com.mackenzie.carlog.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario loginUser(String user, String senha) throws ServiceException {

        Usuario userLogin = usuarioRepository.buscarLogin(user, senha);

        return userLogin;
    }

    public Usuario save(Usuario usuario) {

        var userEmail = usuarioRepository.findByEmail(usuario.getEmail());
        var userCpf = usuarioRepository.findByCpf(usuario.getCpf());

        if (userCpf != null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "CPF já cadastrado no banco de dados!");

        }

        if (userEmail != null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "E-mail já cadastrado no banco de dados!");
        }

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario update(Integer id, Usuario usuario) {

        var usuarioCadastrado = usuarioRepository.findById(id);

        if (usuarioCadastrado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        usuario.setSenha(usuarioCadastrado.get().getSenha());

        return usuarioRepository.save(usuario);
    }

    public void delete(Usuario usuario) {

        usuarioRepository.delete(usuario);

    }

    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }
}
