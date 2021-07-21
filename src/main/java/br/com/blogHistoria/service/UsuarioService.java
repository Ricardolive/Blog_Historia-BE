package br.com.blogHistoria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.blogHistoria.model.UserLogin;
import br.com.blogHistoria.model.Usuario;
import br.com.blogHistoria.repository.UsuarioRepository;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;


@Service
public class UsuarioService {
	
	@Autowired
    private UsuarioRepository repository;

    public Usuario CadastrarUsuario(Usuario usuario){
       BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

      String senhaEncoder = encoder.encode(usuario.getSenha());
      usuario.setSenha(senhaEncoder);
          	return repository.save(usuario);
    }

     
  public Optional<UserLogin> Logar(Optional<UserLogin> user){
      BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
      Optional<Usuario> usuario = repository.findByEmail(user.get().getUsuario());

       if(usuario.isPresent()){
         if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())){
              String auth = user.get().getUsuario() + ":" + user.get().getSenha();
              byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
              String authHeader = "Basic " + new String(encodedAuth);

             user.get().setToken(authHeader);
             user.get().setId(usuario.get().getId());
             user.get().setNome(usuario.get().getNome());
             user.get().setFoto(usuario.get().getFotoPerfil());

             return user;
        }
      }     
       	return null;
  } 

}
 
	
	
	
 
