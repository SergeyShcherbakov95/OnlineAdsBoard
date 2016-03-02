package shcherbakov.sergey.onlineAdsBoard.dao.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import shcherbakov.sergey.onlineAdsBoard.model.Img;
import shcherbakov.sergey.onlineAdsBoard.model.User;

/**
 * @author sergey.shcherbakov
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User find(String email) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.createQuery("from User where email = :email").setString("email", email).uniqueResult();
		return user;
	}
	
	@Override
	public void addUser(User user){
		Session session = sessionFactory.getCurrentSession();
		if(user.getImageUser() == null){
			Img image = (Img)session.get(Img.class, 16);
			user.setImageUser(image);
		}
		session.save(user);
	}

	public User getUser(Integer idUser){
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, idUser);
		return user;
	}
}
