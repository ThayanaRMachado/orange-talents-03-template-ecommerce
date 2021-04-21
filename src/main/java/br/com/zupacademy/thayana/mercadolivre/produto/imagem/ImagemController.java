package br.com.zupacademy.thayana.mercadolivre.produto.imagem;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.thayana.mercadolivre.produto.Produto;

@RestController
@RequestMapping("/produtos")
public class ImagemController {
	
	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private Uploader uploaderFake;
	
	@PostMapping(value = "/{id}/imagens")
	@Transactional
	public ResponseEntity<NovaImagemResponse> adicionaImagens(@PathVariable("id") Long id, @Valid NovaImagemRequest request) {
		Produto produto = manager.find(Produto.class, id);
		Imagem imagem = manager.find(Imagem.class, id);
		Set<String> links = uploaderFake.envia(request.getImagens());
		produto.associaImagens(links);
		manager.merge(produto);

		return ResponseEntity.ok(new NovaImagemResponse(imagem));
	}

}
