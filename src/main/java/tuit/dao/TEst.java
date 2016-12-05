package tuit.dao;
/*
 * @author:Felipe Pires;
 */

import org.hibernate.Session;

import tuit.model.User;


public class TEst {

	public static void main(String[] args) throws Exception {
		Session session = UserDao.getSessionFactory().openSession();
		User user = new User();
		user.setId(1L);
		user.setName("teste");
		user.setEmail("teste@teste.com");
		user.setPassword("1234");

		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
}
