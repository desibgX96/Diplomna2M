package com.diplomna2m.controller;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diplomna2m.model.Detail;
import com.diplomna2m.model.DetailToXML;
import com.diplomna2m.model.DetailXML;
import com.diplomna2m.model.Header;
import com.diplomna2m.model.HeaderXML;
import com.diplomna2m.model.ListBillDetail;
import com.diplomna2m.model.Vzemi;
import com.diplomna2m.repository.DetailsRepository;
import com.diplomna2m.serialize.Seriaizer;
import com.diplomna2m.serialize.impl.ExcelSerializer;
import com.diplomna2m.service.DetailsService;
import com.diplomna2m.util.DTOConvertUtil;

@Controller
public class SearchPanelController {
	@Autowired
	private DetailsService detailsService;
	
	@Autowired
	@Qualifier(value = "jsonserializer")
	private Seriaizer jsonSerializer;

	@Autowired
	@Qualifier(value = "xmlserializer")
	private Seriaizer xmlSerializer;
	
	public ExcelSerializer exelSerializer;
	@Autowired
	private DetailsRepository detailR;

	List<Detail> extractedDetails = new ArrayList<>();
	String access;
	
	@GetMapping("/see")
	public ModelAndView mainPControl(@ModelAttribute("access") @Validated String access) {
		ModelAndView mv = new ModelAndView("SearchPanel");
		this.access = null;
		if(!access.isEmpty() && access.contains("Потребител")) {
			this.access = access;
		}
		return mv;
	}
	
	@RequestMapping(value="/see", method=RequestMethod.GET, params="action=Data extraction")
	public ModelAndView search (Vzemi vz, BindingResult result, HttpServletRequest httpServletRequest) {
		extractedDetails.clear();
		ModelAndView mv = new ModelAndView("SearchPanel");
		ListBillDetail mylist = detailsService.chekForRequest(vz);
		extractedDetails.addAll(mylist.getAllDetails());
		mv.addObject("details",mylist.getAllDetails());
		mv.addObject("bills",mylist.getAllBills());
		mv.addObject("access",access);
		return mv;
	}
	
	@RequestMapping(value="/see", method=RequestMethod.GET, params="action=SaveJ")
	public ModelAndView toFileJSON() {
		jsonSerializer.serialize(extractedDetails, "src/main/resources/output/Accounting Mistakes.json");
		
		ModelAndView mv = new ModelAndView("SearchPanel");
		mv.addObject("details",extractedDetails);
		mv.addObject("access",access);
		return mv;
	}
	
	@RequestMapping(value="/see", method=RequestMethod.GET, params="action=UploadJ")
	public ModelAndView fromFileJSON() {
		Detail[] fileDetail = jsonSerializer.deserialize(Detail[].class, "/output/Accounting Mistakes.json");
		List<Detail> detail = Arrays.asList(fileDetail);
		ModelAndView mv = new ModelAndView("SearchPanel");
		mv.addObject("details",detail);
		mv.addObject("access",access);
		return mv;
	}
	
	//csv file
	@RequestMapping(value="/see", method=RequestMethod.GET, params="action=SaveE")
	public ModelAndView toFileExel() {
		ExcelSerializer.serialize(extractedDetails, "src/main/resources/output/Accounting Mistakes.xls");
		
		ModelAndView mv = new ModelAndView("SearchPanel");
		mv.addObject("details",extractedDetails);
		mv.addObject("access",access);
		return mv;
	}

	@RequestMapping(value="/see", method=RequestMethod.GET, params="action=SaveXML")
	public ModelAndView toFileXML() {
		List<Detail> detailsDTOs = new ArrayList<>(DTOConvertUtil.convertToSet(extractedDetails, Detail.class));
		DetailToXML wrapper = new DetailToXML();
		List<DetailXML> detailsXML = new ArrayList<DetailXML>();
		for (int count = 0; count < detailsDTOs.size(); count++) {
			DetailXML dtXML = new DetailXML();
			HeaderXML hrXML = new HeaderXML();
			dtXML.setAmount(detailsDTOs.get(count).getAmount());
			dtXML.setCredit(detailsDTOs.get(count).getCredit());
			dtXML.setDebit(detailsDTOs.get(count).getDebit());
			dtXML.setId(detailsDTOs.get(count).getId());
			dtXML.setLine(detailsDTOs.get(count).getLine());
			dtXML.setTextOfEntry(detailsDTOs.get(count).getTextOfEntry());
			dtXML.setTextOfEntry(detailsDTOs.get(count).getTextOfEntry());
			hrXML.setDocDate(java.util.Date.from(detailsDTOs.get(count).getAccHeaderId().getDocDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
			hrXML.setDocNr(detailsDTOs.get(count).getAccHeaderId().getDocNr());
			hrXML.setDocType(detailsDTOs.get(count).getAccHeaderId().getDocType());
			hrXML.setFirm(detailsDTOs.get(count).getAccHeaderId().getFirm());
			hrXML.setId(detailsDTOs.get(count).getAccHeaderId().getId());
			hrXML.setJournalNumber(detailsDTOs.get(count).getAccHeaderId().getJournalNumber());
			hrXML.setOperationKind(detailsDTOs.get(count).getAccHeaderId().getOperationKind());
			hrXML.setPeriod(java.util.Date.from(detailsDTOs.get(count).getAccHeaderId().getPeriod().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
			hrXML.setRefName(detailsDTOs.get(count).getAccHeaderId().getRefName());
			hrXML.setRefNr(detailsDTOs.get(count).getAccHeaderId().getRefNr());
			hrXML.setStatus(detailsDTOs.get(count).getAccHeaderId().getStatus());
			hrXML.setTextOFEntry(detailsDTOs.get(count).getAccHeaderId().getTextOFEntry());
			dtXML.setAccHeaderId(hrXML);
			detailsXML.add(dtXML);
		}
		wrapper.setlistMistakes(detailsXML);
		xmlSerializer.serialize(wrapper, "src/main/resources/output/Accounting Mistakes.xml");
		
		ModelAndView mv = new ModelAndView("SearchPanel");
		mv.addObject("details",extractedDetails);
		mv.addObject("access",access);
		return mv;
	}
	
	@RequestMapping(value="/see", method=RequestMethod.GET, params="action=UploadXML")
	public ModelAndView fromFileXML() {
		DetailToXML fileDetail = xmlSerializer.deserialize(DetailToXML.class, "/output/Accounting Mistakes.xml");
		List<DetailXML> detailsXML = new ArrayList<>(fileDetail.getlistMistakes());
		List<Detail> detail = new ArrayList<Detail>();
		for (int count = 0; count < detailsXML.size(); count++) {
			Detail dt = new Detail();
			Header hr = new Header();
			dt.setAmount(detailsXML.get(count).getAmount());
			dt.setCredit(detailsXML.get(count).getCredit());
			dt.setDebit(detailsXML.get(count).getDebit());
			dt.setId(detailsXML.get(count).getId());
			dt.setLine(detailsXML.get(count).getLine());
			dt.setTextOfEntry(detailsXML.get(count).getTextOfEntry());
			dt.setTextOfEntry(detailsXML.get(count).getTextOfEntry());
			hr.setDocDate(detailsXML.get(count).getAccHeaderId().getDocDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			hr.setDocNr(detailsXML.get(count).getAccHeaderId().getDocNr());
			hr.setDocType(detailsXML.get(count).getAccHeaderId().getDocType());
			hr.setFirm(detailsXML.get(count).getAccHeaderId().getFirm());
			hr.setId(detailsXML.get(count).getAccHeaderId().getId());
			hr.setJournalNumber(detailsXML.get(count).getAccHeaderId().getJournalNumber());
			hr.setOperationKind(detailsXML.get(count).getAccHeaderId().getOperationKind());
			hr.setPeriod(detailsXML.get(count).getAccHeaderId().getPeriod().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			hr.setRefName(detailsXML.get(count).getAccHeaderId().getRefName());
			hr.setRefNr(detailsXML.get(count).getAccHeaderId().getRefNr());
			hr.setStatus(detailsXML.get(count).getAccHeaderId().getStatus());
			hr.setTextOFEntry(detailsXML.get(count).getAccHeaderId().getTextOFEntry());
			dt.setAccHeaderId(hr);
			detail.add(dt);
		}

		ModelAndView mv = new ModelAndView("SearchPanel");
		mv.addObject("details",detail);
		mv.addObject("access",access);
		return mv;
	}	
	
	@GetMapping("/detailsBad/{id}")
	public ModelAndView deleteDetail (@PathVariable("id") Detail detail,RedirectAttributes attributes) {
		       detailR.deleteById(detail.getId());
				attributes.addFlashAttribute("message", "Информациятя е изтрито успешно!");
				return new ModelAndView("redirect:/see");
	}
	
	/*
	@RequestMapping(value= "{id}", method=RequestMethod.GET, params="action=change")
	public ModelAndView promeni(@PathVariable ("id") int id) {
		ModelAndView mv = new ModelAndView("ChangeData");
		//mv.addObject(id);
		return mv;
	}
	
	@RequestMapping(value= "/detailsBad/{id}", method=RequestMethod.DELETE, params="action=delete")
	public String iztrii(@PathVariable ("id") int id, RedirectAttributes attributes) {
		//detailR.deleteById(id);
		attributes.addFlashAttribute("message", "Информациятя е изтрито успешно!");
		return "redirect:/see";
	}
*/
}
