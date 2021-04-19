package br.com.zupacademy.thayana.mercadolivre.produto.pergunta;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NovaPerguntaResponse {

	private Long id;
	private String titulo;
	private Long idUsuarioInteressado;
	private String loginUsuarioInteressado;
	private Long idProduto;
	private String nomeProduto;
	private Long idDono;
	private String loginUsuario;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataCriacao;

	public NovaPerguntaResponse(Pergunta pergunta) {
		this.id = pergunta.getId();
		this.titulo = pergunta.getTitulo();
		this.idUsuarioInteressado = pergunta.getUsuarioInteressado().getId();
		this.loginUsuarioInteressado = pergunta.getUsuarioInteressado().getLogin();
		this.idProduto = pergunta.getProduto().getId();
		this.nomeProduto = pergunta.getProduto().getNome();
		this.idDono = pergunta.getProduto().getDono().getId();
		this.loginUsuario = pergunta.getProduto().getDono().getUsername();
		this.dataCriacao = pergunta.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public Long getIdUsuarioInteressado() {
		return idUsuarioInteressado;
	}

	public String getLoginUsuarioInteressado() {
		return loginUsuarioInteressado;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getIdDono() {
		return idDono;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

}
