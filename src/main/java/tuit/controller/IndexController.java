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
import tuit.model.TwitterVO;
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
	public void Seguir(Long id){
		UserDao dao = new UserDao();
		Seguir seguir = new Seguir();
		seguir.getId_seguindo().setId(id);
		Long id_user = session.getId();
		seguir.setId_user(id_user);
		dao.seguir(seguir);
		result.redirectTo(IndexController.class).home();				
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
	
	private List<User> listaSeguindo(){
		UserDao dao = new UserDao();
		Long id_user = session.getId();
		List<User> seguindo = dao.listaSeguindo(id_user);
		return seguindo;
		
	}
	
	private List<TwitterVO> listaVO(){
		UserDao dao = new UserDao();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Long id_user = session.getId();
		List<TwitterVO> listavo = (List<TwitterVO>) dao.listaVO(id_user);
		for (int i = 0; i<listavo.size(); i++) {
			TwitterVO t = listavo.get(i); // pega o twit da posisao i
			String a = dataFormatada.format(t.getData().getTime()); //converte a data no formato predefinido
			listavo.get(i).setDataformat(a); // atualiza o valor da data formatada em uma variavel nao armazenada
		}
		return listavo;
		
	}

	@Path("/validarUser")
	public void validarUser(User user){
		UserDao dao = new UserDao();
		User usuario = dao.validarUser(user.getEmail(),user.getPassword());
		if(usuario == null){
			result.redirectTo(IndexController.class).index();	
			result.include("warningerro","Usuario ou Senha invalida!");
			
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
		result.include("listaUser", listaUser());
		result.include("listaSeguindo", listaSeguindo());
		result.include("teste",listaVO());
		
	}
	@Path("list")
	public void list(){
		result.include("listaUser", listaUser());	

	}

}
