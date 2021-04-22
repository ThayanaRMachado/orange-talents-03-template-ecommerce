package br.com.zupacademy.thayana.mercadolivre.compra;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.thayana.mercadolivre.produto.Produto;
import br.com.zupacademy.thayana.mercadolivre.usuario.Usuario;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne
	private Produto produtoSelecionado;

	@Positive
	@NotNull
	private int quantidade;

	@NotNull
	@ManyToOne
	private Usuario cliente;

	@NotNull
	@Enumerated
	private GatewayPagamento gatewayPagamento;

	@Deprecated
	public Compra() {

	}

	public Compra(Produto produtoSelecionado, @Positive int quantidade, Usuario cliente,
			GatewayPagamento gatewayPagamento) {
		super();
		this.produtoSelecionado = produtoSelecionado;
		this.quantidade = quantidade;
		this.cliente = cliente;
		this.gatewayPagamento = gatewayPagamento;
	}
	
	public Long getId() {
		return id;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public GatewayPagamento getGatewayPagamento() {
		return gatewayPagamento;
	}

	public Usuario getDono() {
		return produtoSelecionado.getDono();
	}

	public String urlRedirecionamento(UriComponentsBuilder uriComponentsBuilder) {
		return this.gatewayPagamento.criaUrlRetorno(this, uriComponentsBuilder);
	}

}
