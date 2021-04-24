package br.com.zupacademy.thayana.mercadolivre.endpointfake;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SistemasController {

	@PostMapping("/notas-fiscais")
	public void criaNotaFiscal(@Valid @RequestBody NovaNFRequest request) throws InterruptedException{
		System.out.println("Nota Fiscal criada para " + request.getIdCompra() + "o comprador " + request.getIdComprador());
		Thread.sleep(150);
	}
	
	@PostMapping("/ranking")
	public void rankingVendedores(@Valid @RequestBody NovoRankingRequest request) throws InterruptedException {
		System.out.println("Nota Fiscal criada para " + request.getIdCompra() + "o comprador " + request.getIdDonoProduto());
		Thread.sleep(150);
	}
	
}
