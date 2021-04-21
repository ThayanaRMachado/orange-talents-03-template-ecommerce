package br.com.zupacademy.thayana.mercadolivre.produto.detalhes;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.thayana.mercadolivre.produto.Produto;
import br.com.zupacademy.thayana.mercadolivre.produto.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class DetalhesProdutoController {

	private ProdutoRepository produtoRepository;

	public DetalhesProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoProdutoResponse> detalhar(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoProdutoResponse(produto.get()));
		}
		return ResponseEntity.notFound().build();
	}
}
