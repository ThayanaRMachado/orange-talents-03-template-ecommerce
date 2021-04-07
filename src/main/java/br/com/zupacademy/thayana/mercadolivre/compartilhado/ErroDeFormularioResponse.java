package br.com.zupacademy.thayana.mercadolivre.compartilhado;

public class ErroDeFormularioResponse {

	private String campo;
	private String erro;

	public ErroDeFormularioResponse(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
