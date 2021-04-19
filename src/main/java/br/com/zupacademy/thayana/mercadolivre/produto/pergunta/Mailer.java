package br.com.zupacademy.thayana.mercadolivre.produto.pergunta;

import javax.validation.constraints.Email;

public interface Mailer {

	void send(String body, String subject, String nameFrom, @Email String from, @Email String to);
}
