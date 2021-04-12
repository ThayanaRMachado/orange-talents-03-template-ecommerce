package br.com.zupacademy.thayana.mercadolivre.seguranca;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class NovoLoginRequest {

	private String login;
	private String senha;

	public NovoLoginRequest(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(login, senha);
	}

}
