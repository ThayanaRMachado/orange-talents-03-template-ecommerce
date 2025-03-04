package br.com.zupacademy.thayana.mercadolivre.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true, nullable = false)
	private String nome;

	@ManyToOne
	private Categoria categoriaMae;

	public Categoria() {

	}

	public Categoria(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public void setCategoriaMae(Categoria categoriaMae) {
		this.categoriaMae = categoriaMae;
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
