package br.com.zupacademy.thayana.mercadolivre.endpointfake;

import javax.validation.constraints.NotNull;

public class NovoRankingRequest {

	@NotNull
	private Long idCompra;

	@NotNull
	private Long idDonoProduto;

	@Deprecated
	public NovoRankingRequest() {

	}

	public NovoRankingRequest(@NotNull Long idCompra, @NotNull Long idDonoProduto) {
		this.idCompra = idCompra;
		this.idDonoProduto = idDonoProduto;
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public Long getIdDonoProduto() {
		return idDonoProduto;
	}

}
