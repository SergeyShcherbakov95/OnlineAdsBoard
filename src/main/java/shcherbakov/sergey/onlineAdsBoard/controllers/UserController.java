package shcherbakov.sergey.onlineAdsBoard.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import shcherbakov.sergey.onlineAdsBoard.model.Img;
import shcherbakov.sergey.onlineAdsBoard.model.User;
import shcherbakov.sergey.onlineAdsBoard.service.user.UserService;

/**
 * @author sergey.shcherbakov
 *
 */
@Controller
public class UserController {
	
	private UserService userService;
	
	private ServletContext servletContext;
	
	@Autowired(required=true)
    @Qualifier(value="userService")
    public void setUserService(UserService userService){
        this.userService = userService;
    }
	
	@Autowired
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;	 
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model){
		return "register";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@RequestParam(value = "image") MultipartFile image, 
			HttpServletRequest request, HttpServletResponse response, Model model){
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		Character sex = Character.valueOf(request.getParameter("sex").charAt(0));
		
		Img userImage = saveImage(image, email);
		
		User user = new User(email, password, surname, name, sex, userImage);
		
		this.userService.addUser(user);
		
		return "redirect:" + "/";
	}
	
	public Img saveImage(MultipartFile image, String email){
		Img userImage = null;
		String[] fileContentType = image.getContentType().split("/");
		String pathToImage = "/resources/databaseImages/users/" + email + "User." + fileContentType[fileContentType.length - 1];
		if (!image.isEmpty()) {
			File file = new File(servletContext.getRealPath("/") + pathToImage);
			byte[] bytes;
			try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file))){
				bytes = image.getBytes();
	            stream.write(bytes);
	            stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			userImage = new Img( pathToImage);
		}
		return userImage;
	}
	
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName();
	    
		model.addAttribute("user", this.userService.find(email));
		
		return "userInfo";
	}
}
