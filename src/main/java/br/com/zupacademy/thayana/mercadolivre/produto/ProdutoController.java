package br.com.zupacademy.thayana.mercadolivre.produto;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.thayana.mercadolivre.produto.imagem.NovaImagemRequest;
import br.com.zupacademy.thayana.mercadolivre.usuario.Usuario;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private Uploader uploaderFake;

	@InitBinder(value = "novoProdutoRequest")
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new ProibeCaracteristicaComNomeIgualValidator());
	}

	@PostMapping
	@Transactional
	public ResponseEntity<NovoProdutoResponse> cadastrar(@RequestBody @Valid NovoProdutoRequest request,
			@AuthenticationPrincipal Usuario logado) {
		Produto produto = request.toModel(manager, logado);
		manager.persist(produto);
		return ResponseEntity.ok(new NovoProdutoResponse(produto));
	}

	@PostMapping(value = "/{id}/imagens")
	@Transactional
	public ResponseEntity<Produto> adicionaImagens(@PathVariable("id") Long id, @Valid NovaImagemRequest request) {
		Produto produto = manager.find(Produto.class, id);

		Set<String> links = uploaderFake.envia(request.getImagens());
		produto.associaImagens(links);
		manager.merge(produto);

		return ResponseEntity.ok(produto);
	}

}
