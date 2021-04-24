package br.com.zupacademy.thayana.mercadolivre.produto.pergunta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.zupacademy.thayana.mercadolivre.compra.Compra;
import br.com.zupacademy.thayana.mercadolivre.compra.EventoCompraSucesso;

@Component
public class Email implements EventoCompraSucesso {

	@Autowired
	private Mailer mailer;

	public void novaPergunta(Pergunta pergunta) {
		mailer.send("<html>...</html>", "Nova pergunta...", pergunta.getUsuarioInteressado().getLogin(),
				"novapergunta@nossomercadolivre.com", pergunta.getProduto().getDono().getLogin());
	}

	public void novaCompra(Compra novaCompra) {
		mailer.send("nova compra..." + novaCompra, "Você tem uma nova compra", novaCompra.getCliente().getLogin(),
				"compras@nossomercadoLivre.com", novaCompra.getDono().getLogin());

	}

	@Override
	public void processa(Compra compra) {
		mailer.send("Nova compra..." + compra, "Nova compra realizada!", compra.getCliente().getUsername(),
				"compras@nossomercadoLivre.com", compra.getCliente().getPassword());

	}

	public void erroPagamento(Compra compra) {
		mailer.send("Compra recusada!", "A sua tentativa de compra falhou!", compra.getCliente().getUsername(),
				"compras@nossomercadoLivre.com", compra.getCliente().getUsername());
	}

}
