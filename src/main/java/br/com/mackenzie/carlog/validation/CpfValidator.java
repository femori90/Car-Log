package br.com.mackenzie.carlog.validation;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mackenzie.carlog.models.Usuario;
import br.com.mackenzie.carlog.service.UsuarioService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<CpfValidation, String> {

    @Autowired
    private UsuarioService usuarioService;

    public CpfValidator() {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (usuarioService != null) {
            Usuario usuario = usuarioService.findByCpf(value);

            if (usuario != null) {
                return false;
            }
        }
        return true;
    }
}
