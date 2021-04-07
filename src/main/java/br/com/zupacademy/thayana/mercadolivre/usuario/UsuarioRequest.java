package br.com.zupacademy.thayana.mercadolivre.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequest {

	@NotBlank
	@Email
	private String login;

	@NotBlank
	@Size(min = 6)
	private String senha;

	public UsuarioRequest(@NotBlank @Email String login, @NotBlank @Size(min = 6) String senha) {
		super();
		this.login = login.toLowerCase();
		this.senha = senha;
	}

	public Usuario toModel() {
		return new Usuario(login, senha);
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
}
