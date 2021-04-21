package br.com.zupacademy.thayana.mercadolivre.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NovoProdutoResponse {

	private Long id;
	private String nome;
	private BigDecimal preco;
	private int quantidade;
	private Set<Map<String, String>> caracteristicas = new HashSet<>();
	private String descricao;
	private Long idCategoria;
	private String nomeCategoria;
	private String loginUsuario;
	private String nomeProduto;
	private Set<Map<String, String>> imagens = new HashSet<>();
	private Set<Map<String, String>> opinioes = new HashSet<>();
	private Set<Map<String, String>> perguntas = new HashSet<>();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@Deprecated
	public NovoProdutoResponse() {

	}

	public NovoProdutoResponse(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.quantidade = produto.getQuantidade();
		this.caracteristicas = produto.mapperCaracteristica(caracteristica -> {
			return Map.of("nome", caracteristica.getNome(), "descricao", caracteristica.getDescricao());
		});
		this.descricao = produto.getDescricao();
		this.idCategoria = produto.getCategoria().getId();
		this.nomeCategoria = produto.getCategoria().getNome();
		this.loginUsuario = produto.getDono().getLogin();
		this.nomeProduto = produto.getNome();
		this.imagens = produto.mapperImagem(imagem -> {
			return Map.of("link", imagem.getLink());
		});
		this.opinioes = produto.mapperOpiniao(opiniao -> {
			return Map.of("titulo", opiniao.getTitulo(), "descricao", opiniao.getDescricao());
		});
		this.perguntas = produto.mapperPergunta(pergunta -> {
			return Map.of("titulo", pergunta.getTitulo());
		});
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

	public Set<Map<String, String>> getCaracteristicas() {
		return caracteristicas;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Set<Map<String, String>> getImagens() {
		return imagens;
	}

	public Set<Map<String, String>> getOpinioes() {
		return opinioes;
	}
	
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	
	public Set<Map<String, String>> getPerguntas() {
		return perguntas;
	}

	public static List<NovoProdutoResponse> converter(List<Produto> produtos) {
		List<NovoProdutoResponse> responses = new ArrayList<>();

		for (Produto produto : produtos) {
			NovoProdutoResponse response = new NovoProdutoResponse(produto);
			responses.add(response);
		}
		return responses;
	}

}
