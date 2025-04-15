package br.com.mackenzie.carlog.validation;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mackenzie.carlog.models.Veiculo;
import br.com.mackenzie.carlog.service.VeiculoService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaValidator implements ConstraintValidator<PlacaValidation, String> {

    @Autowired
    private VeiculoService veiculoService;

    public PlacaValidator() {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (veiculoService != null) {
            Veiculo veiculo = veiculoService.findByPlaca(value);

            if (veiculo != null) {
                return false;
            }
        }

        return true;
    }

}
