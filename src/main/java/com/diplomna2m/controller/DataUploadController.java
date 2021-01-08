package com.diplomna2m.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diplomna2m.model.UserCreateMistake;
import com.diplomna2m.model.UserInfo;
import com.diplomna2m.repository.RolesRepository;
import com.diplomna2m.service.UserInfoServiseInterface;

@Controller
public class DataUploadController {

	@Autowired
	private UserInfoServiseInterface userInfoService;

	@Autowired
	private RolesRepository roles;

	@GetMapping("/user")
	public ModelAndView showUser(UserInfo userInfo) {
		ModelAndView mv = new ModelAndView("userCreate");
		UserCreateMistake mistakes = new UserCreateMistake();
		mv.addObject("mistakes", mistakes);
		mv.addObject("roles", roles.findAll());
		return mv;
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET, params="action=Data extraction")
	public ModelAndView createUser (UserInfo userInfo, BindingResult result, HttpServletRequest httpServletRequest, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("userCreate");
		
		boolean hasmistake= false;
		UserCreateMistake mistakes = new UserCreateMistake();
		if(userInfo.getUserName().isEmpty()) {
			mistakes.setMistake1(true);
			hasmistake=true;
		}
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(userInfo.getEmail());
		if(userInfo.getEmail().isEmpty()|| !matcher.matches()) {
			mistakes.setMistake2(true);
			hasmistake=true;
		}
		if(userInfo.getDob()== null) {
			mistakes.setMistake3(true);
			hasmistake=true;
		}
		if(userInfo.getPassword().isEmpty() || userInfo.getPassword().length()<=8) {
			mistakes.setMistake4(true);
			hasmistake=true;
		}
		if(userInfo.getPasswordConfirmation().isEmpty() || !userInfo.getPasswordConfirmation().equals(userInfo.getPassword()) ) {
			mistakes.setMistake5(true);
			hasmistake=true;
		}
		if(userInfo.getRoles().isEmpty()) {
			mistakes.setMistake6(true);
			hasmistake=true;
		}
		if(hasmistake) {
			mv.addObject("roles", roles.findAll());
			mv.addObject("mistakes", mistakes);
			return mv;
		} else {
			try {
				userInfoService.safeUser(userInfo);
			} catch (com.diplomna2m.exeptions.ExistingUserEmailExeption e) {
				result.rejectValue("email", e.getMessage(), e.getMessage());
				return showUser(userInfo);
			} catch (com.diplomna2m.exeptions.UserPasswordRequiredExeption e) {
				result.rejectValue("password", e.getMessage(), e.getMessage());
				return showUser(userInfo);
			}
			attributes.addFlashAttribute("messageY", "Потребителят е записан успешно!");
			mv.addObject("roles", roles.findAll());
			return new ModelAndView("redirect:/user");
		}
	}
}
