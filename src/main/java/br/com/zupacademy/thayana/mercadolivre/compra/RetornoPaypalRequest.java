package br.com.zupacademy.thayana.mercadolivre.compra;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RetornoPaypalRequest implements RetornoGatewayPagamento {

	@NotBlank
	private String idTransacao;

	@Min(0)
	@Max(1)
	private int status;

	@Deprecated
	public RetornoPaypalRequest() {

	}

	public RetornoPaypalRequest(@NotBlank String idTransacao, @Min(0) @Max(1) @NotNull int status) {
		this.idTransacao = idTransacao;
		this.status = status;
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public int getStatus() {
		return status;
	}

	@Override
	public Transacao toTransacao(Compra compra) {
		StatusTransacao statusCalculado = this.status == 0 ? StatusTransacao.erro : StatusTransacao.sucesso;
		return new Transacao(statusCalculado, idTransacao, compra);
	}

}
