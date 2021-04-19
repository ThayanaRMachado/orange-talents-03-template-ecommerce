package br.com.zupacademy.thayana.mercadolivre.produto.pergunta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Email {

	@Autowired
	private Mailer mailer;
	
	public void novaPergunta(Pergunta pergunta) {
		mailer.send("<html>...</html>","Nova pergunta...",pergunta.getUsuarioInteressado().getLogin(),"novapergunta@nossomercadolivre.com",
				pergunta.getProduto().getDono().getLogin());
	}
}
