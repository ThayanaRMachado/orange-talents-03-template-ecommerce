package br.com.zupacademy.thayana.mercadolivre.categoria;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import br.com.zupacademy.thayana.mercadolivre.compartilhado.CampoUnico;
import br.com.zupacademy.thayana.mercadolivre.compartilhado.ExistsId;

public class NovaCategoriaRequest {

	@NotBlank
	@CampoUnico(classe = Categoria.class, nomeAtributo = "nome")
	private String nome;

	@Positive
	@ExistsId(classe = Categoria.class, nomeAtributo = "id")
	private Long idCategoriaMae;

	public NovaCategoriaRequest() {

	}

	public void setIdCategoriaMae(Long idCategoriaMae) {
		this.idCategoriaMae = idCategoriaMae;
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
