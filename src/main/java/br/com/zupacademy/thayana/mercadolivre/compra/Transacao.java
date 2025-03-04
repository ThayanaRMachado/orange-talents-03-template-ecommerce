package br.com.zupacademy.thayana.mercadolivre.compra;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private StatusTransacao status;

	@NotBlank
	private String idTransacaoGateway;

	@ManyToOne
	private Compra compra;

	private LocalDateTime instante;

	@Deprecated
	public Transacao() {

	}

	public Transacao(@NotNull StatusTransacao status, @NotBlank String idTransacaoGateway, Compra compra) {
		this.status = status;
		this.idTransacaoGateway = idTransacaoGateway;
		this.compra = compra;
	}

	public Long getId() {
		return id;
	}

	public StatusTransacao getStatus() {
		return status;
	}

	public String getIdTransacaoGateway() {
		return idTransacaoGateway;
	}

	public Compra getCompra() {
		return compra;
	}

	public LocalDateTime getInstante() {
		return instante;
	}

	public boolean concluidaComSucesso() {
		return this.status.equals(StatusTransacao.sucesso);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
