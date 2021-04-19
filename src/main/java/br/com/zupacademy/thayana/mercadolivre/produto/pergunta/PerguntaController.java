package br.com.zupacademy.thayana.mercadolivre.produto.pergunta;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.thayana.mercadolivre.usuario.Usuario;

@RestController
@RequestMapping("/produtos")
public class PerguntaController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private Email email;
	
	@PostMapping(value = "/{id}/perguntas")
	@Transactional
	public ResponseEntity<NovaPerguntaResponse> cadastrar(@RequestBody @Valid NovaPerguntaRequest request, @PathVariable ("id") Long id) {
		Produto produto = manager.find(Produto.class, id);
		Usuario usuario = manager.find(Usuario.class, id);
		Pergunta pergunta = request.toModel(produto, usuario);
		manager.persist(pergunta);
		email.novaPergunta(pergunta);
		
		return ResponseEntity.ok(new NovaPerguntaResponse(pergunta));
	}
	
}
