package com.diplomna2m.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diplomna2m.model.PotentialUser;
import com.diplomna2m.model.UserInfo;
import com.diplomna2m.service.UserInfoServiseInterface;

@Controller
public class LoginController {

	@Autowired
	private UserInfoServiseInterface userInfoService;
	
	@GetMapping("/login")
	public ModelAndView login () {
		ModelAndView mv = new ModelAndView("Login");
				return mv;
	}
	
	@PostMapping("/login") 
	public ModelAndView search (PotentialUser puser, BindingResult result, HttpServletRequest httpServletRequest, RedirectAttributes attributes) {
		List<UserInfo> user = userInfoService.findUserProfile(puser);
				if( user.isEmpty()){
				attributes.addFlashAttribute("message", "Няма такъв потребител!");
				return new ModelAndView("redirect:/user");
			}else {
				for(int i = 0;i < user.get(0).getRoles().size(); i++ ) {
				if(user.get(0).getRoles().get(i).getName().equals("Администратор")) {
				return new ModelAndView("redirect:/see");
				}
				}
				ModelAndView mv = new ModelAndView("redirect:/see");
				mv.addObject("access", "Потребител");
				return mv;
			}
	}
}
