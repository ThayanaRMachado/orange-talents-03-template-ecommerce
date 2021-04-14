package br.com.zupacademy.thayana.mercadolivre.produto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.zupacademy.thayana.mercadolivre.categoria.Categoria;
import br.com.zupacademy.thayana.mercadolivre.compartilhado.CampoUnico;
import br.com.zupacademy.thayana.mercadolivre.compartilhado.ExistsId;

public class NovoProdutoRequest {

	@NotBlank
	@CampoUnico(classe = Produto.class, nomeAtributo = "nome")
	private String nome;

	@NotNull
	@Positive
	private BigDecimal preco;

	@NotNull
	@Positive
	private int quantidade;

	@NotBlank
	@Size(max = 1000)
	private String descricao;

	@Size(min = 3)
	private Set<NovaCaracteristicaRequest> caracteristicas = new HashSet<>();

	@NotNull
	@ExistsId(classe = Categoria.class, nomeAtributo = "id")
	private Long idCategoria;

	public NovoProdutoRequest() {

	}

	public NovoProdutoRequest(@NotBlank String nome, @NotNull @Positive BigDecimal preco,
			@NotNull @Positive int quantidade, @NotBlank @Size(max = 1000) String descricao,
			@Size(min = 3) @Valid Set<NovaCaracteristicaRequest> caracteristicas, @NotNull Long idCategoria) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.caracteristicas.addAll(caracteristicas);
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Set<NovaCaracteristicaRequest> getCaracteristicas() {
		return caracteristicas;
	}

	public Produto toModel(EntityManager manager) {
		Categoria categoria = manager.find(Categoria.class, idCategoria);

		return new Produto(nome, preco, quantidade, caracteristicas, descricao, categoria);
	}

	public Set<String> temCaracteristicasIguais() {
		HashSet<String> nomesIguais = new HashSet<>();
		HashSet<String> resultados = new HashSet<>();

		for (NovaCaracteristicaRequest caracteristica : caracteristicas) {
			String nome = caracteristica.getNome();

			if (!nomesIguais.add(nome)) {
				resultados.add(nome);
			}
		}
		return resultados;
	}

}
