package br.com.zupacademy.thayana.mercadolivre.compra;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;
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

	@OneToMany(mappedBy = "compra", cascade = CascadeType.MERGE)
	private Set<Transacao> transacoes = new HashSet<>();

	@Deprecated
	public Compra() {
		
	}

	public Compra(Produto produtoSelecionado, @Positive int quantidade, Usuario cliente,
			GatewayPagamento gatewayPagamento) {
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
	
	public Set<Transacao> getTransacoes() {
		return transacoes;
	}

	public String urlRedirecionamento(UriComponentsBuilder uriComponentsBuilder) {
		return this.gatewayPagamento.criaUrlRetorno(this, uriComponentsBuilder);
	}

	public StatusTransacao adicionaTransacao(RetornoGatewayPagamento request) {
		Transacao novaTransacao = request.toTransacao(this);

		Assert.state(!this.transacoes.contains(novaTransacao), "Já existe uma transacão igual a essa!");
		Assert.state(transacoesConcluidasComSucesso().isEmpty(), "Compra concluída com sucesso!");

		this.transacoes.add(novaTransacao);
		return novaTransacao.getStatus();
	}

	private Set<Transacao> transacoesConcluidasComSucesso() {
		Set<Transacao> transacoesConcluidas = this.transacoes.stream().filter(Transacao::concluidaComSucesso)
				.collect(Collectors.toSet());
		Assert.isTrue(transacoesConcluidas.size() <= 1, "Existe mais de uma transacao concluída!" + this.id);
		return transacoesConcluidas;
	}
	
	public boolean processadaComSucesso() {
		return !transacoesConcluidasComSucesso().isEmpty();
	}
	
}
