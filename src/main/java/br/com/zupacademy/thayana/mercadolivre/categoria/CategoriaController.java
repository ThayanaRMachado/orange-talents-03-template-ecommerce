package br.com.zupacademy.thayana.mercadolivre.categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovaCategoriaRequest request) {		
		Categoria categoria = request.toModel(manager);
		manager.persist(categoria);
		return categoria.toString();
	}
}
