package br.com.mackenzie.carlog.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.mackenzie.carlog.models.Usuario;
import br.com.mackenzie.carlog.repositories.UsuarioRepository;
import br.com.mackenzie.carlog.utils.Utils;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario loginUser(String user, String senha) throws ServiceException, NoSuchAlgorithmException {

        Usuario userLogin = usuarioRepository.buscarLogin(user, Utils.md5(senha));

        return userLogin;
    }

    public Usuario save(Usuario usuario) throws NoSuchAlgorithmException {

        var userEmail = usuarioRepository.findByEmail(usuario.getEmail());

        if (userEmail != null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "E-mail já cadastrado no banco de dados!");
        }
        usuario.setSenha(Utils.md5(usuario.getSenha()));

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

        if (!usuarioCadastrado.get().getCpf().equals(usuario.getCpf())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "CPF já cadastrado na base de dados!");
        }

        usuario.setSenha(usuarioCadastrado.get().getSenha());

        return usuarioRepository.save(usuario);
    }

    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public Usuario findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }

    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }
}
