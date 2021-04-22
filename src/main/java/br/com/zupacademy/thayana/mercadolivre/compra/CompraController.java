package br.com.zupacademy.thayana.mercadolivre.compra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.thayana.mercadolivre.produto.Produto;
import br.com.zupacademy.thayana.mercadolivre.produto.pergunta.Email;
import br.com.zupacademy.thayana.mercadolivre.usuario.Usuario;

@RestController
@RequestMapping("/compras")
public class CompraController {

	@PersistenceContext
	EntityManager manager;

	private Email email;

	public CompraController(Email email) {
		this.email = email;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<String> cria(@RequestBody @Valid NovaCompraRequest request, @AuthenticationPrincipal Usuario comprador, UriComponentsBuilder uriComponentsBuilder) throws BindException {

		Produto produtoASerComprado = manager.find(Produto.class, request.getIdProduto());

		int quantidade = request.getQuantidade();
		boolean abateu = produtoASerComprado.abataEstoque(quantidade);

		if (abateu) {
			GatewayPagamento gateway = request.getGatewayPagamento();

			Compra novaCompra = new Compra(produtoASerComprado, quantidade, comprador, gateway);
			manager.persist(novaCompra);
			email.novaCompra(novaCompra);
			
			return ResponseEntity.ok(novaCompra.urlRedirecionamento(uriComponentsBuilder));
									
		}

		BindException problemaComEstoque = new BindException(request,"novaCompraRequest");
		problemaComEstoque.reject(null, "Produto indisponível");

		throw problemaComEstoque;
	}	

}
