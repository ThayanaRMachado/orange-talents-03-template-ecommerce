package br.com.zupacademy.thayana.mercadolivre.produto.pergunta;

import java.util.Set;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProibeCaracteristicaComNomeIgualValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoProdutoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		NovoProdutoRequest request = (NovoProdutoRequest) target;
		Set<String> nomesIguais = request.temCaracteristicasIguais();
		if(!nomesIguais.isEmpty()) {
			errors.rejectValue("caracteristicas", null, "Existem características com nomes iguais.");
		}
	}

}
