package controller;

import br.com.caelum.vraptor.Controller;
import model.Usuario;

@Controller
public class UsuarioController {
	
	
	public void Salvar(Usuario usuario){
		
		System.out.println(usuario.getNome());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getSenha());
		
		System.out.println("Usuario Recebido com sucesso");
		
	}
	
	

}
