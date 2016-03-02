package shcherbakov.sergey.onlineAdsBoard.dao.ad;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import shcherbakov.sergey.onlineAdsBoard.model.Ad;
import shcherbakov.sergey.onlineAdsBoard.model.User;

/**
 * @author sergey.shcherbakov
 *
 */
@Repository
public class AdDaoImpl implements AdDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Ad getAd(Integer idAd){
		Session session = sessionFactory.getCurrentSession();
		Ad ad = (Ad) session.createQuery("from Ad where idAd = :id").setInteger("id", idAd).uniqueResult();
		
		return ad;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ad> listAds() {
		Session session = sessionFactory.getCurrentSession();
		List<Ad> ads = session.createQuery("from Ad").list();
		
		return ads;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ad> listAdsByUserId(Integer idUser){
		Session session = sessionFactory.getCurrentSession();
		List<Ad> ads = session.createQuery("from Ad as ad where ad.userAd.idUser = :id").setInteger("id", idUser).list();
		
		return ads;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ad> listAdsByCategoryId(Integer idCategory){
		Session session = sessionFactory.getCurrentSession();
		List<Ad> ads = session.createQuery("from Ad as ad where ad.adCategory.idCategory = :id").setInteger("id", idCategory).list();
		
		return ads;
	}
	
	@Override
	public List<Ad> listAdsByUserIdFavourites(Integer idUser){
		Session session = sessionFactory.getCurrentSession();
		
		User user = (User)session.get(User.class, idUser);
		
		List<Ad> ads = new ArrayList<Ad>();
		ads.addAll(user.getAdsFavourites());
		
		return ads;
	}
}
