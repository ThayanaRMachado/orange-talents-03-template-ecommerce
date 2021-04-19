package br.com.zupacademy.thayana.mercadolivre.produto.pergunta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import br.com.zupacademy.thayana.mercadolivre.categoria.Categoria;
import br.com.zupacademy.thayana.mercadolivre.produto.caracteristica.Caracteristica;
import br.com.zupacademy.thayana.mercadolivre.produto.caracteristica.NovaCaracteristicaRequest;
import br.com.zupacademy.thayana.mercadolivre.produto.imagem.Imagem;
import br.com.zupacademy.thayana.mercadolivre.produto.opiniao.Opiniao;
import br.com.zupacademy.thayana.mercadolivre.usuario.Usuario;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@NotNull
	@Positive
	private BigDecimal preco;

	@NotNull
	@Positive
	private int quantidade;

	@Size(min = 3)
	@OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
	private Set<Caracteristica> caracteristicas = new HashSet<>();

	@NotBlank
	@Size(max = 1000)
	private String descricao;

	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
	private Set<Imagem> imagens = new HashSet<>();

	@ManyToOne
	@NotNull
	@Valid
	private Usuario dono;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
	private Set<Opiniao> opinioes = new HashSet<>();
	
	@CreationTimestamp
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@Deprecated
	public Produto() {
	}

	public Produto(String nome, BigDecimal preco, int quantidade,
			Collection<NovaCaracteristicaRequest> caracteristicas,
			String descricao, Categoria categoria, Usuario dono) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.caracteristicas.addAll(caracteristicas.stream().map(caracteristica -> caracteristica.toModel(this))
				.collect(Collectors.toSet()));
		this.descricao = descricao;
		this.categoria = categoria;
		this.dono = dono;
	}

	public Long getId() {
		return id;
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

	public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public String getDescricao() {
		return descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public Usuario getDono() {
		return dono;
	}
	
	public Set<Opiniao> getOpinioes() {
		return opinioes;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public void associaImagens(Set<String> links) {
		Set<Imagem> imagens = links.stream().map(link -> new Imagem(this, link)).collect(Collectors.toSet());

		this.imagens.addAll(imagens);
	}

}
