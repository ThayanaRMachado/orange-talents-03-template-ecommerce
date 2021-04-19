package br.com.zupacademy.thayana.mercadolivre.produto.opiniao;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.thayana.mercadolivre.produto.Produto;
import br.com.zupacademy.thayana.mercadolivre.usuario.Usuario;

public class NovaOpiniaoRequest {

	@Min(1)
	@Max(5)
	private int nota;

	@NotBlank
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String descricao;

	@Deprecated
	public NovaOpiniaoRequest() {

	}

	public NovaOpiniaoRequest(@Min(1) @Max(5) int nota, @NotBlank String titulo,
			@NotBlank @Size(max = 500) String descricao) {
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public int getNota() {
		return nota;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Opiniao toModel(Produto produto, Usuario usuario) {
		return new Opiniao(nota, titulo, descricao, usuario, produto);
	}

}
