package br.com.zupacademy.thayana.mercadolivre.compra;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Component
public class Ranking implements EventoCompraSucesso{
	
	@Override
	public void processa(Compra compra) {
		Assert.isTrue(compra.processadaComSucesso(), "Compra não concluída!" + compra);
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> request = Map.of("idCompra", compra.getId(), "idComprador", compra.getCliente().getId());
		
		restTemplate.postForEntity("http://localhost:8080/ranking", request, String.class);
	}
	
}
