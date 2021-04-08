package br.com.zupacademy.thayana.mercadolivre.usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public ResponseEntity<NovoUsuarioResponse> cadastrar(@RequestBody @Valid NovoUsuarioRequest request) {		
		Usuario usuario = request.toModel();
		manager.persist(usuario);
		return ResponseEntity.ok(new NovoUsuarioResponse(usuario));
	}
	
}
