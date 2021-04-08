package br.com.zupacademy.thayana.mercadolivre.categoria;

public class NovaCategoriaResponse {

	private Long id;

	private String nome;

	private Categoria categoriaMae;

	public NovaCategoriaResponse(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.categoriaMae = categoria.getCategoriaMae();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Categoria getCategoriaMae() {
		return categoriaMae;
	}

}
