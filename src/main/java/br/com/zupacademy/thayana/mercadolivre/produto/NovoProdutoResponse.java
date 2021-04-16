package br.com.zupacademy.thayana.mercadolivre.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NovoProdutoResponse {

	private Long id;
	private String nome;
	private BigDecimal preco;
	private int quantidade;
	private Set<Caracteristica> caracteristicas = new HashSet<>();
	private String descricao;
	private Long idCategoria;
	private String nomeCategoria;
	private String loginUsuario;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataCadastro = LocalDateTime.now();

	public NovoProdutoResponse() {

	}

	public NovoProdutoResponse(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.quantidade = produto.getQuantidade();
		this.caracteristicas = produto.getCaracteristicas();
		this.descricao = produto.getDescricao();
		this.idCategoria = produto.getCategoria().getId();
		this.nomeCategoria = produto.getCategoria().getNome();
		this.loginUsuario = produto.getDono().getLogin();
		this.dataCadastro = produto.getDataCadastro();
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

	public String getDescricao() {
		return descricao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}	  
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	
	public String getLoginUsuario() {
		return loginUsuario;
	}
	 
}
