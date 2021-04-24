package br.com.zupacademy.thayana.mercadolivre.compra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RetornoPagSeguroRequest implements RetornoGatewayPagamento {

	@NotBlank
	private String idTransacao;

	@NotNull
	private StatusRetornoPagSeguro status;

	@Deprecated
	public RetornoPagSeguroRequest() {

	}

	public RetornoPagSeguroRequest(@NotBlank String idTransacao, StatusRetornoPagSeguro status) {
		this.idTransacao = idTransacao;
		this.status = status;
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public StatusRetornoPagSeguro getStatus() {
		return status;
	}

	@Override
	public Transacao toTransacao(Compra compra) {
		return new Transacao(status.normaliza(), idTransacao, compra);
	}

}
