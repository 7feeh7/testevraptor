package tuit.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.management.monitor.StringMonitor;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Property;

import tuit.model.Seguir;
import tuit.model.Twit;
import tuit.model.TwitterVO;
import tuit.model.User;

public class UserDao {
	public static final SessionFactory session = buildSession();
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSession(){
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
			
		} catch (Throwable b) {
			System.out.println("Falhou"+b);
			throw new ExceptionInInitializerError();
		}
	}
	public static SessionFactory getSessionFactory(){
		return session;
	}
	
	public void salvar(User user){
		Session session = UserDao.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void seguir(Seguir seguir){
		Session session = UserDao.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(seguir);
		session.getTransaction().commit();
		session.close();
	}
	
	public void publicar(Twit twit){
		Session session = UserDao.getSessionFactory().openSession();		
		session.beginTransaction();
		twit.setData(Calendar.getInstance());
		session.save(twit);
		session.getTransaction().commit();
		session.close();
	}
	
	public User validarUser(String email, String password)throws HibernateException{
	Session session = UserDao.getSessionFactory().openSession();
	Criteria criteria = session.createCriteria(User.class);
	User user = (User) criteria
			.add(Restrictions.ilike("email", email, MatchMode.EXACT))
			.add(Restrictions.ilike("password", password, MatchMode.EXACT))
			.uniqueResult();
	session.close();
	return user;		
	}
	
	public List<Twit> listaTodos(Long id) throws HibernateException{
		Session session = UserDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Twit.class);
		@SuppressWarnings("unchecked")
		List<Twit> twit = (List<Twit>) criteria
				.add(Restrictions.eq("id", id))
			    .addOrder(Order.desc("data"))
				.list();
		session.close();
		return twit;
		
	}
	public List<User> listaUser() throws HibernateException{
		Session session = UserDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class);
		
		@SuppressWarnings("unchecked")
		List<User> user = (List<User>) criteria.list();
		
		session.close();
		
		return user;
	
	}
	public List<Seguir> listaSeguindo() throws HibernateException{
		Session session = UserDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class);
		List<Seguir> seguindo = (List<Seguir>) criteria.list();
		session.close();
		return seguindo;
		
	}
	@SuppressWarnings("unchecked")
	public List<TwitterVO>listaVO(Long id_user) throws HibernateException{
	List<TwitterVO> listaVO = new ArrayList<>();
	List<User> listaUsuarios = listaUser();
	List<Twit> listaTodos = listaTodos(id_user); 

	for (int i = 0; i < listaUsuarios.size(); i++) {
		
		for (int j = 0; j < listaTodos.size(); j++) {
			if (listaUsuarios.get(i).getId()==listaTodos.get(j).getId()) {
				TwitterVO  t = new TwitterVO();
				t.setId_user(listaUsuarios.get(i).getId());
				t.setName(listaUsuarios.get(i).getName());
				t.setTwit(listaTodos.get(j).getTwit());
				t.setData(listaTodos.get(j).getData());;
				listaVO.add(t);
				
			}	
		}	
	}
	return listaVO;			
}
	
	public void logout(User user){
		
	}
	
}

