package br.com.zupacademy.thayana.mercadolivre.usuario;

import java.time.LocalDateTime;

public class NovoUsuarioResponse {

	private Long id;

	private LocalDateTime instanteCadastro = LocalDateTime.now();

	private String login;

	public NovoUsuarioResponse(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.instanteCadastro = usuario.getInstanteCadastro();
		this.login = usuario.getLogin();
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getInstanteCadastro() {
		return instanteCadastro;
	}

	public String getLogin() {
		return login;
	}

}
