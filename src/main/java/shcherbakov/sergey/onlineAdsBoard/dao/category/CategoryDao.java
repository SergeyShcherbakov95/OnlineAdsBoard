package shcherbakov.sergey.onlineAdsBoard.dao.category;

import java.util.List;

import shcherbakov.sergey.onlineAdsBoard.model.Category;

/**
 * @author sergey.shcherbakov
 *
 */
public interface CategoryDao {
	public List<Category> listCategories();
	
	public List<Category> listCategoriesByParentId(Integer idParent);
	
	public List<Category> listRootCategories();
}
