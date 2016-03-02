package shcherbakov.sergey.onlineAdsBoard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shcherbakov.sergey.onlineAdsBoard.model.Category;
import shcherbakov.sergey.onlineAdsBoard.service.category.CategoryService;

/**
 * @author sergey.shcherbakov
 *
 */
@Controller
public class CategoryController {
	
	private CategoryService categoryService;
	
	@Autowired(required=true)
    @Qualifier(value="categoryService")
    public void setCategoryService(CategoryService categoryService){
        this.categoryService = categoryService;
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage(Model model){
		model.addAttribute("category", new Category());
        model.addAttribute("listCategories", this.categoryService.listRootCategories());
        
		return "home";
	}
	
	@RequestMapping(value = "/categories/{idParent}", method = RequestMethod.GET)
	public String subcategories(@PathVariable String idParent, Model model){
		List<Category> categories = this.categoryService.listCategoriesByParentId(Integer.valueOf(idParent));
		if(categories == null || categories.isEmpty())
			return "redirect:/ads/category/"+ idParent;
		model.addAttribute("category", new Category());
        model.addAttribute("listCategories", categories);
        
		return "home";
	}
}
