package br.com.zupacademy.thayana.mercadolivre.seguranca;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.zupacademy.thayana.mercadolivre.usuario.Usuario;
import br.com.zupacademy.thayana.mercadolivre.usuario.UsuarioRepository;
 
@Component
public class AutenticacaoAux implements UserDetailsService{

	private UsuarioRepository usuarioRepository;	

	public AutenticacaoAux(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByLogin(username);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
