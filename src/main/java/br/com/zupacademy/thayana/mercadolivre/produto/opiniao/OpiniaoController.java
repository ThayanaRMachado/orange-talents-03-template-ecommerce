package br.com.zupacademy.thayana.mercadolivre.produto.opiniao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.thayana.mercadolivre.produto.Produto;
import br.com.zupacademy.thayana.mercadolivre.usuario.Usuario;

@RestController
@RequestMapping("/opinioes")
public class OpiniaoController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<NovaOpiniaoResponse> cadastrar(@RequestBody @Valid NovaOpiniaoRequest request, @PathVariable ("id") Long id) {
		Produto produto = manager.find(Produto.class, id);
		Usuario usuario = manager.find(Usuario.class, id);
		Opiniao opiniao = request.toModel(produto, usuario);
		manager.persist(opiniao);
		return ResponseEntity.ok(new NovaOpiniaoResponse(opiniao));
	}
	
}
