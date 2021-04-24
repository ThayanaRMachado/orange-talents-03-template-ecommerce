package br.com.zupacademy.thayana.mercadolivre.endpointfake;

import javax.validation.constraints.NotNull;

public class NovaNFRequest {

	@NotNull
	private Long idCompra;

	@NotNull
	private Long idComprador;

	@Deprecated
	public NovaNFRequest() {

	}

	public NovaNFRequest(Long idCompra, Long idComprador) {
		this.idCompra = idCompra;
		this.idComprador = idComprador;
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public Long getIdComprador() {
		return idComprador;
	}

}
