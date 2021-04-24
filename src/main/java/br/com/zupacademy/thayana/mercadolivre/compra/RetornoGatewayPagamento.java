package br.com.zupacademy.thayana.mercadolivre.compra;

public interface RetornoGatewayPagamento {

	Transacao toTransacao(Compra compra);
}
