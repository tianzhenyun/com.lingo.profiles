package com.lingo.profiles.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lingo.profiles.bean.ListResult;
import com.lingo.profiles.bean.Login;
import com.lingo.profiles.bean.Result;
import com.lingo.profiles.bean.Education;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.LingoLogger;
import com.lingo.profiles.formbean.EducationForm;
import com.lingo.profiles.utils.WebUtils;

@Controller
@RequestMapping(value={"/education"})
public class EducationController {
	int pid =1;
	
	/**
	 * get education list by pid
	 * @return
	 */
	@ModelAttribute(value="list")
	public List<Education> getList()
	{
		Education data = new Education();
		data.setPid(pid);
		
		com.lingo.profiles.dao.Education education = new com.lingo.profiles.dao.Education();
		ListResult<Education> result = education.getList(data);
		if(result.getResult()!=1)
		{
			//error...
		}
		return result.getList();
	}
	@Login
	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String addEducation(ModelMap model) {
		return "education_add";
	}

	@Login
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String addEducation(@ModelAttribute EducationForm form, ModelMap model, HttpServletRequest request) {
		//EducationForm form = WebUtils.requestToBean(request, EducationForm.class);
		form.setPid(pid);
		if(!form.validate())
		{
			model.addAttribute("form", form);
			return "education_add";
		}
		
		Education data = new Education();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Education education = new com.lingo.profiles.dao.Education();
		Result result = education.add(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: add education error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}

		return "redirect:/education/add";
	}

	@Login
	@RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
	public String updateEducation(@PathVariable int id, ModelMap model) {
		return String.format("redirect:/education/model/%d",id);
	}

	@Login
	@RequestMapping(value={"/update"},method = RequestMethod.POST)
	public String updateEducation(@ModelAttribute EducationForm form, ModelMap model,HttpServletRequest request)
	{
		//EducationForm form = WebUtils.requestToBean(request, EducationForm.class);
		form.setPid(pid);
		if(!form.validate())
		{
			model.addAttribute("form", form);
			return "education_update";
		}
		Education data = new Education();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Education education = new com.lingo.profiles.dao.Education();
		Result result = education.update(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: update education error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		return "redirect:/education/add";
	}

	@Login
	@RequestMapping(value={"/delete/{id}"},method=RequestMethod.GET)
	public String deleteEducation(@PathVariable int id, ModelMap model)
	{
		Education data = new Education();
		data.setId(id);
		
		com.lingo.profiles.dao.Education education = new com.lingo.profiles.dao.Education();
		Result result = education.delete(data);
		if(result.getResult()!=1)
		{
			//error....
			LingoLogger.logger.info(String.format("controller level: delete education error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		
		return "redirect:/education/add";
	}

	@Login
	@RequestMapping(value={"/model/{id}"},method=RequestMethod.GET)
	public String getModel(@PathVariable int id, ModelMap model)
	{
		Education data = new Education();
		data.setId(id);
		
		com.lingo.profiles.dao.Education education = new com.lingo.profiles.dao.Education();
		TResult<Education> result = education.getModel(data);
		if(result.getResult()!=1)
		{
			//error
			LingoLogger.logger.info(String.format("controller level: get education model error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
			
		}
		EducationForm form = new EducationForm();
		data = result.getT();
		WebUtils.copyBean(data, form);
		model.addAttribute("form", form);
		
		return "education_update";
	}
}
