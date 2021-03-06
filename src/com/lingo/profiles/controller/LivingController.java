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
import com.lingo.profiles.bean.Living;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.Common;
import com.lingo.profiles.common.LingoLogger;
import com.lingo.profiles.formbean.LivingForm;
import com.lingo.profiles.utils.WebUtils;

@Controller
@RequestMapping(value={"/living"})
public class LivingController {
	
	/**
	 * get living list by pid
	 * @return
	 */
	@Login
	@ModelAttribute(value="list")
	public List<Living> getList(HttpServletRequest request)
	{
		Living data = new Living();
		data.setPid(Common.getPid(request));
		com.lingo.profiles.dao.Living living = new com.lingo.profiles.dao.Living();
		
		ListResult<Living> result = living.getList(data);
		if(result.getResult()!=1)
		{
			//error...
			
		}
		return result.getList();
	}

	@Login
	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String addLiving(ModelMap model) {
		return "living_add";
	}

	@Login
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String addLiving(@ModelAttribute LivingForm form, ModelMap model, HttpServletRequest request) {
		//LivingForm form = WebUtils.requestToBean(request, LivingForm.class);
		form.setPid(Common.getPid(request));
		if(!form.validate())
		{
			model.addAttribute("form", form);
			return "living_add";
		}
		
		Living data = new Living();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Living living = new com.lingo.profiles.dao.Living();
		Result result = living.add(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: add living error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}

		return "redirect:/living/add";
	}

	@Login
	@RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
	public String updateLiving(@PathVariable int id, ModelMap model) {
		return String.format("redirect:/living/model/%d", id);
	}

	@Login
	@RequestMapping(value={"/update"},method = RequestMethod.POST)
	public String updateLiving(@ModelAttribute LivingForm form, ModelMap model,HttpServletRequest request)
	{
		//LivingForm form = WebUtils.requestToBean(request, LivingForm.class);
		form.setPid(Common.getPid(request));
		if(!form.validate())
		{
			model.addAttribute("form", form);
			return "living_update";
		}
		Living data = new Living();
		WebUtils.copyBean(form, data);

		com.lingo.profiles.dao.Living living = new com.lingo.profiles.dao.Living();
		Result result = living.update(data);
		if (result.getResult() != 1) {
			// error....
			LingoLogger.logger.info(String.format("controller level: update living error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		return "redirect:/living/add";
	}

	@Login
	@RequestMapping(value={"/delete/{id}"},method=RequestMethod.GET)
	public String deleteLiving(@PathVariable int id, ModelMap model)
	{
		Living data = new Living();
		data.setId(id);
		
		com.lingo.profiles.dao.Living living = new com.lingo.profiles.dao.Living();
		Result result = living.delete(data);
		if(result.getResult()!=1)
		{
			//error....
			LingoLogger.logger.info(String.format("controller level: delete living error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
		}
		
		return "redirect:/living/add";
	}

	@Login
	@RequestMapping(value={"/model/{id}"},method=RequestMethod.GET)
	public String getModel(@PathVariable int id, ModelMap model)
	{
		Living data = new Living();
		data.setId(id);
		
		com.lingo.profiles.dao.Living living = new com.lingo.profiles.dao.Living();
		TResult<Living> result = living.getModel(data);
		if(result.getResult()!=1)
		{
			//error
			LingoLogger.logger.info(String.format("controller level: get living model error,Result:%d, Message:%s",result.getResult(),result.getMessage()));
			
		}
		LivingForm form = new LivingForm();
		data = result.getT();
		WebUtils.copyBean(data, form);
		model.addAttribute("form", form);
		
		return "living_update";
	}
}
