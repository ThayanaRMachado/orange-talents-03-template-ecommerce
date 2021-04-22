package br.com.zupacademy.thayana.mercadolivre.compra;

public class NovaCompraResponse {

	private GatewayPagamento gatewayPagamento;

	public NovaCompraResponse(Compra compra) {
		this.gatewayPagamento = compra.getGatewayPagamento();
	}

	public GatewayPagamento getGatewayPagamento() {
		return gatewayPagamento;
	}

}
