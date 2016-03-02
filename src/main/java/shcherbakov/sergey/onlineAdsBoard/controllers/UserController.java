package shcherbakov.sergey.onlineAdsBoard.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shcherbakov.sergey.onlineAdsBoard.model.User;
import shcherbakov.sergey.onlineAdsBoard.service.user.UserService;

/**
 * @author sergey.shcherbakov
 *
 */
@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired(required=true)
    @Qualifier(value="userService")
    public void setUserService(UserService userService){
        this.userService = userService;
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model){
		return "register";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request,
            HttpServletResponse response, Model model){
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		Character sex = Character.valueOf(request.getParameter("sex").charAt(0));
		
		User user = new User(email, password, surname, name, sex, null);
		
		this.userService.addUser(user);
		
		return "redirect:" + "/";
	}
	
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName();
	    
		model.addAttribute("user", this.userService.find(email));
		
		return "userInfo";
	}
}
