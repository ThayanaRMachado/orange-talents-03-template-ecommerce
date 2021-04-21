package br.com.zupacademy.thayana.mercadolivre.produto.imagem;

public class NovaImagemResponse {

	private Long id;
	private String link;

	@Deprecated
	public NovaImagemResponse() {

	}

	public NovaImagemResponse(Imagem imagem) {
		this.id = imagem.getId();
		this.link = imagem.getLink();
	}

	public Long getId() {
		return id;
	}

	public String getLink() {
		return link;
	}

}
