package com.diplomna2m.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diplomna2m.model.Detail;
import com.diplomna2m.service.DetailsServiseInterface;

@Controller
public class ChangeDataContntroller {
	@Autowired
	private DetailsServiseInterface detailService;
   public Detail oldDetail;

   @GetMapping("/details/{id}")
	public ModelAndView editDetail (@PathVariable("id") Detail detail) {
		oldDetail = detail;
	ModelAndView mv = new ModelAndView("ChangeData");
	mv.addObject(detail);
	return mv;
	}
	
	@RequestMapping(value = { "/details/{id}" }, method = RequestMethod.POST)
	public ModelAndView saveDetail(@Valid Detail newDetail, BindingResult result, Model model, RedirectAttributes attributes) {
		detailService.updateUser(oldDetail , newDetail);
		attributes.addFlashAttribute("message", "Информацията е записана успешно!");
	return new ModelAndView("redirect:/see");
	}
	}
