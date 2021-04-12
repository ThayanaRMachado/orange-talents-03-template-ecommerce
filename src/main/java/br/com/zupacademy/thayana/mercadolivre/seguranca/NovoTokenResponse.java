package br.com.zupacademy.thayana.mercadolivre.seguranca;

public class NovoTokenResponse {

	private String token;
	private String tipo;

	public NovoTokenResponse(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
	}

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}

}
