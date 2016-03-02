package shcherbakov.sergey.onlineAdsBoard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sergey.shcherbakov
 *
 */
@Controller
public class LoginUser {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){
		return "login";
	}
	
	@RequestMapping(value = "/login/error", method = RequestMethod.GET)
	public String errorLogin(Model model){
		model.addAttribute("error", "*Incorrect email or password");
		
		return "login";
	}
}
