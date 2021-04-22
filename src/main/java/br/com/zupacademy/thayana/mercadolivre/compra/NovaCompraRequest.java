package br.com.zupacademy.thayana.mercadolivre.compra;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovaCompraRequest {

	@Positive
	@NotNull
	private int quantidade;

	@NotNull
	private Long idProduto;

	@NotNull
	private GatewayPagamento gatewayPagamento;

	public NovaCompraRequest(@Positive @NotNull int quantidade, @NotNull Long idProduto,
			@NotNull GatewayPagamento gatewayPagamento) {
		super();
		this.quantidade = quantidade;
		this.idProduto = idProduto;
		this.gatewayPagamento = gatewayPagamento;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public GatewayPagamento getGatewayPagamento() {
		return gatewayPagamento;
	}

}