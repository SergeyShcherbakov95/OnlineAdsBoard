package shcherbakov.sergey.onlineAdsBoard.service.category;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shcherbakov.sergey.onlineAdsBoard.dao.category.CategoryDao;
import shcherbakov.sergey.onlineAdsBoard.model.Category;

/**
 * @author sergey.shcherbakov
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryDao categoryDao;
	 
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
	
	/* (non-Javadoc)
	 * @see shcherbakov.sergey.onlineAdsBoard.service.category.CategoryService#listCategories()
	 */
	@Transactional
	@Override
	public List<Category> listCategories() {
		return this.categoryDao.listCategories();
	}
	
	@Transactional
	@Override
	public List<Category> listCategoriesByParentId(Integer idParent){
		return this.categoryDao.listCategoriesByParentId(idParent);
	}
	
	@Transactional
	@Override
	public List<Category> listRootCategories(){
		return this.categoryDao.listRootCategories();
	}

}
