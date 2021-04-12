package br.com.zupacademy.thayana.mercadolivre.seguranca;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	private AuthenticationManager authManager;
	
	private TokenAux tokenAux;

	public AutenticacaoController(AuthenticationManager authManager, TokenAux tokenService) {
		this.authManager = authManager;
		this.tokenAux = tokenService;
	}

	@PostMapping
	public ResponseEntity<NovoTokenResponse> autenticar(@RequestBody @Valid NovoLoginRequest request) {
		UsernamePasswordAuthenticationToken dadosLogin = request.converter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenAux.gerarToken(authentication);
			return ResponseEntity.ok(new NovoTokenResponse(token, "Bearer"));
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

}
