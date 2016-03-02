package shcherbakov.sergey.onlineAdsBoard.dao.category;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import shcherbakov.sergey.onlineAdsBoard.model.Category;
import shcherbakov.sergey.onlineAdsBoard.model.Img;

/**
 * @author sergey.shcherbakov
 *
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listCategories() {
		Session session = sessionFactory.getCurrentSession();
		List<Category> categories = session.createQuery("from Category").list();
		
		return categories;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listCategoriesByParentId(Integer idParent){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select idCategory, category, image from Categories, Images "
												+ "where idParentCategory = :id and "
													+ "Categories.idImage = Images.idImage");
		query.setLong("id", idParent);
		List<Object[]> data = query.list();
		List<Category> categories = new LinkedList<Category>(); 
		for(Object[] row : data){
			Img image = new Img(row[2].toString());
			Category ctg = new Category(row[1].toString(), image, null);
			ctg.setIdCategory(Integer.parseInt(row[0].toString()));
			categories.add(ctg);
		}

		return categories;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listRootCategories(){
		Session session = sessionFactory.getCurrentSession();
		List<Category> categories = session.createQuery("from Category where parentCategory is NULL").list();
		
		return categories;
	}

}
