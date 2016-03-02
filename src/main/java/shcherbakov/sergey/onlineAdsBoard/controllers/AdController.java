package shcherbakov.sergey.onlineAdsBoard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shcherbakov.sergey.onlineAdsBoard.model.Ad;
import shcherbakov.sergey.onlineAdsBoard.service.ad.AdService;

/**
 * @author sergey.shcherbakov
 *
 */
@Controller
public class AdController {

	private AdService adService;
	
	@Autowired(required=true)
    @Qualifier(value="adService")
    public void setAdService(AdService adService){
        this.adService = adService;
    }
	
	@RequestMapping(value = "/ad/{idAd}", method = RequestMethod.GET)
    public String getAd(@PathVariable String idAd, Model model) {
		model.addAttribute("ad", this.adService.getAd(Integer.valueOf(idAd)));
        
		return "ad";
    }
	
	@RequestMapping(value = "/ads/user/{idUser}", method = RequestMethod.GET)
    public String listAdsByUserId(@PathVariable String idUser, Model model) {
		model.addAttribute("ad", new Ad());
        model.addAttribute("listAds", this.adService.listAdsByUserId(Integer.valueOf(idUser)));
        
		return "ads";
    }
	
	@RequestMapping(value = "/ads/category/{idCategory}", method = RequestMethod.GET)
    public String listAdsByCategoryId(@PathVariable String idCategory, Model model) {
		model.addAttribute("ad", new Ad());
        model.addAttribute("listAds", this.adService.listAdsByCategoryId(Integer.valueOf(idCategory)));
        
		return "ads";
    }
	
	@RequestMapping(value = "/ads/userFavourites/{idUser}", method = RequestMethod.GET)
    public String listAdsByUserIdFavourites(@PathVariable String idUser, Model model) {
		model.addAttribute("ad", new Ad());
        model.addAttribute("listAds", this.adService.listAdsByUserIdFavourites(Integer.valueOf(idUser)));
        
		return "ads";
    }
}
