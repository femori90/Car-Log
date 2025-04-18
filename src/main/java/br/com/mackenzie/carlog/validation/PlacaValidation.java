package br.com.mackenzie.carlog.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = PlacaValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PlacaValidation {

    String message() default "Placa já cadastrada!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
