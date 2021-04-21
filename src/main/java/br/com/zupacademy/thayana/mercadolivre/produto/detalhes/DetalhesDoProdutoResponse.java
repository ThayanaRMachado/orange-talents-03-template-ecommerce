package br.com.zupacademy.thayana.mercadolivre.produto.detalhes;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.com.zupacademy.thayana.mercadolivre.produto.Produto;

public class DetalhesDoProdutoResponse {

	private Set<Map<String, String>> imagens = new HashSet<>();
	
	private String nome;
	
	private BigDecimal preco;
	
	private Set<Map<String, String>> caracteristicas = new HashSet<>();
	
	private String descricao;
	
	private Set<Map<String, String>> opinioes = new HashSet<>();
	
	private Set<Map<String, String>> perguntas = new HashSet<>();
	
	private Double mediaNotas;
	
	private int totalNotas;
	
	public DetalhesDoProdutoResponse() {
	}

	public DetalhesDoProdutoResponse(Produto produto) {
		
		this.imagens = produto.mapperImagem(imagem -> {
			return Map.of("link", imagem.getLink());
		});
		
		this.nome = produto.getNome();
		
		this.preco = produto.getPreco();
		
		this.caracteristicas = produto.mapperCaracteristica(caracteristica -> {
			return Map.of("nome", caracteristica.getNome(), "descricao", caracteristica.getDescricao());
		});
		
		this.descricao = produto.getDescricao();
		
		this.opinioes = produto.mapperOpiniao(opiniao -> {
			return Map.of("titulo", opiniao.getTitulo(), "descricao", opiniao.getDescricao());
		});
		
		this.perguntas = produto.mapperPergunta(pergunta -> {
			return Map.of("titulo", pergunta.getTitulo());
		});
		
		this.mediaNotas = produto.calculaMediaNotas();
		
		this.totalNotas = produto.calculaTotalNotas();
	}

	public Set<Map<String, String>> getImagens() {
		return imagens;
	}
	
	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Set<Map<String, String>> getCaracteristicas() {
		return caracteristicas;
	}

	public String getDescricao() {
		return descricao;
	}

	public Set<Map<String, String>> getOpinioes() {
		return opinioes;
	}
	
	public Set<Map<String, String>> getPerguntas() {
		return perguntas;
	}
	
	public Double getMediaNotas() {
		return mediaNotas;
	}

	public int getTotalNotas() {
		return totalNotas;
	}
	
}
