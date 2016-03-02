package shcherbakov.sergey.onlineAdsBoard.service.ad;

import java.util.List;

import shcherbakov.sergey.onlineAdsBoard.model.Ad;

/**
 * @author sergey.shcherbakov
 *
 */
public interface AdService {
	public Ad getAd(Integer idAd);
	
	public List<Ad> listAds();
	
	public List<Ad> listAdsByUserId(Integer idUser);
	
	public List<Ad> listAdsByCategoryId(Integer idCategory);
	
	public List<Ad> listAdsByUserIdFavourites(Integer idUser);
}
