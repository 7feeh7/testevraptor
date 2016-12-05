package tuit.dao;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import tuit.model.Seguir;
import tuit.model.Twit;
import tuit.model.TwitterVO;
import tuit.model.User;
import tuit.model.UserSession;

public class UserDao {
	public static final SessionFactory session = buildSession();
	private static final Comparator<? super TwitterVO> TwitterVO = null;
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
	
	public void saveUser(User user) {
		Session session = UserDao.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	public void updateUser(User user) {
		Session session = UserDao.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public void publicar(Twit twit) {
		Session session = UserDao.getSessionFactory().openSession();
		session.beginTransaction();
		twit.setData(Calendar.getInstance());
		session.save(twit);
		session.getTransaction().commit();
		session.close();
	}
	
	public void seguir(Seguir seguir) {
		Session session = UserDao.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(seguir);
		session.getTransaction().commit();
		session.close();
	}
	
	public User validarUser(String email, String password) throws HibernateException {
		Session session = UserDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class);
		User user = (User) criteria.add(Restrictions.ilike("email", email, MatchMode.EXACT))
				.add(Restrictions.ilike("password", password, MatchMode.EXACT)).uniqueResult();
		session.close();
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<Twit> listaTwit(Long id) throws HibernateException{
		Session session = UserDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Twit.class);
		List<Twit> twit = (List<Twit>) criteria
				.add(Restrictions.eq("id", id))
			    .addOrder(Order.desc("data"))
				.list();
		session.close();
		return twit;	
	}
	
	@SuppressWarnings("unused")
	public List<Twit> listaTwitSeguindo(){
		Session session = UserDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Twit.class);
		List<Twit> twit = new ArrayList<>();
		return null;
		
	}
	
	public List<User> listaUser(Long id_user) throws HibernateException{
		Session session = UserDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class);
		
		String sql = "SELECT id,id_user,id_seguindo FROM Seguir WHERE id_user = :logado";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Seguir.class);
		query.setParameter("logado", id_user);
		List<Seguir> result = query.list();
		
		Iterator<?> i = result.iterator();
		List<Long> ids = new ArrayList<>();
		
		while (i.hasNext()) {
			Seguir o = (Seguir) i.next();
			ids.add(o.getId_seguindo());
		}
		
		List<User> seguindo = new ArrayList<>();
		
		if (result.size() > 0) {
			 seguindo = (List<User>) criteria.add(
					 Restrictions.not(
							 Restrictions.in("id", ids.toArray()))).list();
				
		}
		
		session.close();
		return seguindo;
		
	}

	@SuppressWarnings("unchecked")
	public List<User> listaAllUser() throws HibernateException{
		Session session = UserDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class);
		List<User> user = (List<User>) criteria.list();
		session.close();
		return user;
	}

	@SuppressWarnings({ "unchecked" })
	public List<User> listaSeguindo(Long id_user) throws HibernateException{
		Session session = UserDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class);
		
		String sql = "SELECT id,id_user,id_seguindo FROM Seguir WHERE id_user = :var";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Seguir.class);
		query.setParameter("var", id_user);
		List<Seguir> result = query.list();
		
		Iterator<?> i = result.iterator();
		List<Long> ids = new ArrayList<>();
		
		while (i.hasNext()) {
			Seguir o = (Seguir) i.next();
			ids.add(o.getId_seguindo());
		}
		
		List<User> seguindo = new ArrayList<>();
		
		if (result.size() > 0) {
			 seguindo = (List<User>) criteria
			.add(Restrictions.in("id", ids.toArray())).list();
				
		}
		
		session.close();
		return seguindo;
		
	}
	public List<TwitterVO> listaVO(Long id_user) throws HibernateException{
		Session session = UserDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Twit.class);
		List<TwitterVO> listaVO = new ArrayList<>();
	
		String consulta = "SELECT id,id_user,id_seguindo FROM Seguir WHERE id_user = :var";
		SQLQuery qu = session.createSQLQuery(consulta);
		qu.addEntity(Seguir.class);
		qu.setParameter("var", id_user);
		List<Seguir> r = qu.list();
		
		Iterator<?> i = r.iterator();
		List<Long> ids = new ArrayList<>();
		
		while (i.hasNext()) {
			Seguir o = (Seguir) i.next();
			ids.add(o.getId_seguindo());
		}
		String sql = "SELECT u.*,t.* FROM twit t"
				+ " INNER JOIN tb_user u ON u.id = t.id"
				+ "  WHERE t.id IN (:ids)"
				+ " OR t.id = :logado ORDER BY t.data DESC";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Twit.class);
		query.addEntity(User.class);
		query.setParameterList("ids", ids);
		query.setParameter("logado", id_user);
		
		//List<TwitterVO> result;
		List<TwitterVO> recebe = (List<TwitterVO>) query.list();
		for (Object obj: recebe) {
			TwitterVO t = new TwitterVO();
			Object[] o =(Object[]) obj;
			Twit twit = (Twit)o[0];
			User user = (User)o[1];
			t.setUser(new User());
			t.setTwit(new Twit());
			t.getUser().setName(user.getName());
			t.getUser().setId(user.getId());
			t.getTwit().setTwit(twit.getTwit());
			t.getTwit().setData(twit.getData());
			t.getTwit().setId_twit(twit.getId_twit());
			listaVO.add(t);
		}
				
		return listaVO;
		
	}

	/*public Set<TwitterVO> listaVO(User u) throws HibernateException{
		Session session = UserDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Twit.class);
		Set<TwitterVO> listaVO = new HashSet<>();

		List<User> listaSeguindo = listaSeguindo(u.getId());
		List<User> listaUsuarios = listaAllUser();
		List<Twit> listaTodos = listaTwit(u.getId());
		
		
		if (listaSeguindo.size() > 0) {
			
			for (int i = 0; i < listaSeguindo.size(); i++) {
				listaTodos.addAll(listaTwit(listaSeguindo.get(i).getId()));

			}
			
			for (int j = 0; j < listaTodos.size(); j++) {
				boolean add = true;
				
				for (int i = 0; i < listaSeguindo.size(); i++) {
					if(listaSeguindo.get(i).getId() == listaTodos.get(j).getId()) {
						TwitterVO t = new TwitterVO();
						t.setId_user(listaSeguindo.get(i).getId());
						t.setName(listaSeguindo.get(i)[0].getName());
						t.setTwit(listaTodos.get(j)[1].getTwit());
						t.setData(listaTodos.get(j).getData());
						listaVO.add(t);
					} else 
						if(u.getId() == listaTodos.get(j).getId()){
							TwitterVO t = new TwitterVO();
							t.setId_user(u.getId());
							t.setName(u.getName());
							t.setTwit(listaTodos.get(j).getTwit());
							t.setData(listaTodos.get(j).getData());
							
							if (add) {
								listaVO.add(t);
								add = false;
							}
						}
					}
				}
		}


			//for (int i = 0; i < listaUsuarios.size(); i++) {
//				for (int j = 0; j < listaTodos.size(); j++) {
//					if (u.getId() == listaTodos.get(j).getId()) {
//						TwitterVO t = new TwitterVO();
//						t.setId_user(u.getId());
//						t.setName(u.getName());
//						t.setTwit(listaTodos.get(j).getTwit());
//						t.setData(listaTodos.get(j).getData());
//						listaVO.add(t);
//					}
//				}
			//}


	
	return listaVO;			
}
*/	
	
	public void logout(User user){
		session.close();
	}
	
}

