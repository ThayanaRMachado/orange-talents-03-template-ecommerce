package br.com.zupacademy.thayana.mercadolivre.compartilhado;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = { CampoUnicoValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CampoUnico {

	String message() default "Campo já existente";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String nomeAtributo();

	Class<?> classe();
}
