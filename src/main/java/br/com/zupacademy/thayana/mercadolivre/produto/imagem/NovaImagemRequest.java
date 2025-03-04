package br.com.zupacademy.thayana.mercadolivre.produto.imagem;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class NovaImagemRequest {

	@Size(min = 1)
	@NotNull
	private List<MultipartFile> imagens = new ArrayList<>();

	public NovaImagemRequest() {

	}

	public List<MultipartFile> getImagens() {
		return imagens;
	}

}
