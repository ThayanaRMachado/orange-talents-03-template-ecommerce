package br.com.zupacademy.thayana.mercadolivre.usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NovoUsuarioResponse {

	private Long id;

	private LocalDateTime instanteCadastro = LocalDateTime.now();

	private String login;

	public NovoUsuarioResponse(Usuario usuario) {
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

	public static List<NovoUsuarioResponse> converter(List<Usuario> usuarios) {
		List<NovoUsuarioResponse> responses = new ArrayList<>();

		for (Usuario usuario : usuarios) {
			NovoUsuarioResponse response = new NovoUsuarioResponse(usuario);
			responses.add(response);
		}
		return responses;
	}

}
