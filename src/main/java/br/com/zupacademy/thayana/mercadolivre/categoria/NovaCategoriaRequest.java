package br.com.zupacademy.thayana.mercadolivre.categoria;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.thayana.mercadolivre.compartilhado.CampoUnico;

public class NovaCategoriaRequest {

	@NotBlank
	@CampoUnico(classe = Categoria.class, nomeAtributo = "nome")
	private String nome;

	private Long idCategoriaMae;

	public NovaCategoriaRequest() {

	}

	public NovaCategoriaRequest(String nome) {
		super();
		this.nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria toModel(EntityManager manager) {
		Categoria categoria = new Categoria(nome);
		if (idCategoriaMae != null) {
			Categoria categoriaMae = manager.find(Categoria.class, idCategoriaMae);
			categoria.setCategoriaMae(categoriaMae);
		}
		return categoria;
	}

}
