package br.com.zupacademy.thayana.mercadolivre.produto.pergunta;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.thayana.mercadolivre.produto.Produto;
import br.com.zupacademy.thayana.mercadolivre.usuario.Usuario;

public class NovaPerguntaRequest {

	@NotBlank
	private String titulo;

	public NovaPerguntaRequest() {
		super();
	}

	public NovaPerguntaRequest(@NotBlank String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public Pergunta toModel(Produto produto, Usuario usuario) {
		return new Pergunta(titulo, usuario, produto);
	}

}
