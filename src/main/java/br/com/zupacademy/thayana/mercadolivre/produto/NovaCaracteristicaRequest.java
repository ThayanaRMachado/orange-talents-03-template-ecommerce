package br.com.zupacademy.thayana.mercadolivre.produto;

public class NovaCaracteristicaRequest {

	private String nome;
	
	private String descricao;

	public NovaCaracteristicaRequest() {

	}

	public NovaCaracteristicaRequest(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Caracteristica toModel(Produto produto) {
		return new Caracteristica(nome, descricao, produto);
	}

}
