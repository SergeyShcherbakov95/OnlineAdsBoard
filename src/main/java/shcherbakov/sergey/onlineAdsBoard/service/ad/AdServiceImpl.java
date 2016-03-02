package shcherbakov.sergey.onlineAdsBoard.service.ad;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shcherbakov.sergey.onlineAdsBoard.model.Ad;
import shcherbakov.sergey.onlineAdsBoard.dao.ad.*;

/**
 * @author sergey.shcherbakov
 *
 */
@Service
public class AdServiceImpl implements AdService {
	
	private AdDao adDao;
	 
    public void setAdDao(AdDao adDao) {
        this.adDao = adDao;
    }

    @Transactional
    @Override
    public Ad getAd(Integer idAd){
    	return this.adDao.getAd(idAd);
    }
    
    @Transactional
    @Override
	public List<Ad> listAds() {
		return this.adDao.listAds();
	}
   
    @Transactional
    @Override
    public List<Ad> listAdsByUserId(Integer idUser){
    	return this.adDao.listAdsByUserId(idUser);
    }
	
    @Transactional
    @Override
	public List<Ad> listAdsByCategoryId(Integer idCategory){
    	return this.adDao.listAdsByCategoryId(idCategory);
    }
    
    @Transactional
    @Override
    public List<Ad> listAdsByUserIdFavourites(Integer idUser){
    	return this.adDao.listAdsByUserIdFavourites(idUser);
    }
}
