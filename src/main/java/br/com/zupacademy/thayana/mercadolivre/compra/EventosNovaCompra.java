package br.com.zupacademy.thayana.mercadolivre.compra;

import java.util.Set;

import org.springframework.stereotype.Component;

import br.com.zupacademy.thayana.mercadolivre.produto.pergunta.Email;

@Component
public class EventosNovaCompra {

	private Set<EventoCompraSucesso> eventoCompraSucesso;

	private Email email;

	public EventosNovaCompra(Set<EventoCompraSucesso> eventoCompraSucesso, Email email) {
		this.eventoCompraSucesso = eventoCompraSucesso;
		this.email = email;
	}

	public void processa(Compra compra) {
		if (compra.processadaComSucesso()) {
			eventoCompraSucesso.forEach(evento -> evento.processa(compra));
		} else {
			email.erroPagamento(compra);
		}
	}

}
