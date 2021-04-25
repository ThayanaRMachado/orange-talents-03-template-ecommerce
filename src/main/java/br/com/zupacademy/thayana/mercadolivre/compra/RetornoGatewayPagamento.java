package br.com.zupacademy.thayana.mercadolivre.compra;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = RetornoPagSeguroRequest.class)
public interface RetornoGatewayPagamento {

	Transacao toTransacao(Compra compra);

}
