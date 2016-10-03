package tuit.controller;
/*
 * @author:Felipe Pires;
 */

import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import tuit.dao.UserDao;
import tuit.model.Seguir;
import tuit.model.Twit;
import tuit.model.User;
import tuit.model.UserSession;

@Controller
public class IndexController {
	
	@Inject private Result result;
	@Inject private UserSession session;
	
	@Path("/")
	public void index(){
		result.include("message", "Hello,Word!");
	}
	
	
	@Path("/salvar")
	public void Salvar(User user){
		UserDao dao = new UserDao();
		dao.salvar(user);
		result.redirectTo(IndexController.class).index();
		
	}
	
	@Path("/seguir")
	public void Seguir(Seguir seguir){
		UserDao dao = new UserDao();
		dao.seguir(seguir);
		
	}
	
	@Path("/publicar")
	public void  publicar(Twit twit){
		UserDao dao = new UserDao();
		twit.setId(session.getId());
		dao.publicar(twit);
		result.redirectTo(IndexController.class).home();				
	}
	
	private List<Twit> listaTwit(){
		UserDao dao = new UserDao();
		Twit twit = new Twit();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Long id = session.getId();
		List<Twit> listaake = dao.listaTodos(id);
		for (int i = 0; i<listaake.size(); i++) {
			Twit t = listaake.get(i); // pega o twit da posisao i
			String a = dataFormatada.format(t.getData().getTime()); //converte a data no formato predefinido
			listaake.get(i).setDataformat(a); // atualiza o valor da data formatada em uma variavel nao armazenada
		}
		return listaake;
	}
	
	private List<User> listaUser(){
		UserDao dao = new UserDao();
		List<User> listauser = dao.listaUser();
		return listauser;
		
	}

	@Path("/validarUser")
	public void validarUser(User user){
		UserDao dao = new UserDao();
		User usuario = dao.validarUser(user.getEmail(),user.getPassword());
		if(usuario == null){
			result.include("messagen","Usuario ou Senha invalida!");
			
		}else{
			session.login(usuario);
			result.redirectTo(IndexController.class).home();
		}
	
	
	}
	
	
	@Path("index")
	public void logout(){
		result.redirectTo(IndexController.class).index();
	}
	
	@Path("home")
	public void home() {
		result.include("publicacao", listaTwit());
		
	}
	@Path("list")
	public void list(){
		result.include("listaUser", listaUser());	

	}

}
