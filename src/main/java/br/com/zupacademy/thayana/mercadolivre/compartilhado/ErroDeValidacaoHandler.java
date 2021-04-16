package br.com.zupacademy.thayana.mercadolivre.compartilhado;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErroDeValidacaoHandler extends ResponseEntityExceptionHandler {

	private MessageSource messageSource;

	public ErroDeValidacaoHandler(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ErroDeFormularioResponse> erros = criarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}

	private List<ErroDeFormularioResponse> criarListaDeErros(BindingResult bindingResult) {
		List<ErroDeFormularioResponse> erros = new ArrayList<>();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			String campo = messageSource.getMessage(fieldError, null);
			String erro = fieldError.toString();
			erros.add(new ErroDeFormularioResponse(campo, erro));
		}
		return erros;
	}
	
}
