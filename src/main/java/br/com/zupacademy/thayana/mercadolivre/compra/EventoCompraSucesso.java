package br.com.zupacademy.thayana.mercadolivre.compra;

/*
 * Todo evento relacionado ao sucesso de uma nova compra, deve implementar esta interface.
 */
public interface EventoCompraSucesso {

	void processa(Compra compra);
}
