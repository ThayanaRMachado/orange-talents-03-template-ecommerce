package br.com.zupacademy.thayana.mercadolivre.produto.opiniao;

public class NovaOpiniaoResponse {

	private Long id;
	private int nota;
	private String titulo;
	private String descricao;
	private Long idProduto;
	private String nomeProduto;
	private Long idUsuario;
	private String loginUsuario;

	public NovaOpiniaoResponse(Opiniao opiniao) {
		this.id = opiniao.getId();
		this.nota = opiniao.getNota();
		this.titulo = opiniao.getTitulo();
		this.descricao = opiniao.getDescricao();
		this.idProduto = opiniao.getId();
		this.nomeProduto = opiniao.getProduto().getNome();
		this.idUsuario = opiniao.getUsuario().getId();
		this.loginUsuario = opiniao.getUsuario().getLogin();
	}
	
	public Long getId() {
		return id;
	}

	public int getNota() {
		return nota;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

}
