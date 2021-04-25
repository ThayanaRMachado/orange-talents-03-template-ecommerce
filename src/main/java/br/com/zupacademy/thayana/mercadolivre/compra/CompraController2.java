package br.com.zupacademy.thayana.mercadolivre.compra;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.thayana.mercadolivre.usuario.Usuario;

@RestController
public class CompraController2 {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private CompraRepository compraRepository;

	private EventosNovaCompra eventosNovaCompra;

	public CompraController2(EventosNovaCompra eventosNovaCompra) {
		this.eventosNovaCompra = eventosNovaCompra;
	}

	@PostMapping("/retorno-pagseguro/{id}")
	@Transactional
	public ResponseEntity<?> processamentoPagSeguro(@AuthenticationPrincipal Usuario comprador,
			@PathVariable("id") Long idCompra, @RequestBody @Valid RetornoGatewayPagamento request) {
		return processa(idCompra, request);
	}

	@PostMapping("/retorno-paypal/{id}")
	@Transactional
	public ResponseEntity<?> processamentoPaypal(@AuthenticationPrincipal Usuario comprador,
			@PathVariable("id") Long idCompra, @RequestBody @Valid RetornoGatewayPagamento request) {
		return processa(idCompra, request);
	}

	@Transactional
	private ResponseEntity<?> processa(Long idCompra, RetornoGatewayPagamento retornoGatewayPagamento) {
		Optional<Compra> compraOpcional = compraRepository.findById(idCompra);

		if (compraOpcional.isPresent()) {

			Compra compra = compraOpcional.get();

			StatusTransacao status = compra.adicionaTransacao(retornoGatewayPagamento);

			compraRepository.save(compra);

			eventosNovaCompra.processa(compra);

			return ResponseEntity.ok().body(status);
		}

		return ResponseEntity.notFound().build();

	}

	/*
	 * private ResponseEntity<Compra> processa(Long idCompra, @Valid
	 * RetornoGatewayPagamento retornoGatewayPagamento) {
	 * 
	 * Compra compra = manager.find(Compra.class, idCompra);
	 * compra.adicionaTransacao(retornoGatewayPagamento); manager.merge(compra);
	 * 
	 * eventosNovaCompra.processa(compra);
	 * 
	 * return ResponseEntity.ok(compra); }
	 */

}
