package com.app.customermgr.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.customermgr.service.ICustomerService;

@Controller
@RequestMapping(value="/customer")
public class CustomerController extends BaseController{

	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(value="/list/{currentPage}/{pageSize}",method=RequestMethod.GET)
	public ModelAndView list(@PathVariable("currentPage")Integer currentPage,
					@PathVariable("pageSize")Integer pageSize){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("currentPage", currentPage);
		map.put("pageSize", pageSize);
 		map.put("pageResult", customerService.findPageResult(map));
 		System.err.println(map);
		ModelAndView modelAndView = new ModelAndView("/customer/list", map);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}/{currentPage}/{pageSize}")
	public String delete(@PathVariable("id")Integer id, @PathVariable("currentPage")Integer currentPage,
			@PathVariable("pageSize")Integer pageSize){
		customerService.delete(id);
		return "redirect:/customer/list/" + currentPage + "/" + pageSize;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public void testException() throws Exception {
		System.out.println("CustomerController.testException()");
		System.out.println(1/0);
	}
}
