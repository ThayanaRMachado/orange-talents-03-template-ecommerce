package br.com.zupacademy.thayana.mercadolivre.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<NovoUsuarioResponse> cadastrar(@RequestBody @Valid NovoUsuarioRequest request) {		
		Usuario usuario = request.toModel();
		manager.persist(usuario);
		return ResponseEntity.ok(new NovoUsuarioResponse(usuario));
	}
	
	@GetMapping
	public List<NovoUsuarioResponse> lista() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return NovoUsuarioResponse.converter(usuarios);
	}
	
}
