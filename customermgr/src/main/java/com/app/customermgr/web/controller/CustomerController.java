package com.app.customermgr.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.customermgr.model.Customer;
import com.app.customermgr.service.ICustomerService;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(){
		System.err.println("CustomerController.list()");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("customers", customerService.findAllCustomer());
		ModelAndView modelAndView = new ModelAndView("/customer/list", map);
		return modelAndView;
	}
	
	@RequestMapping(value="/index2",method=RequestMethod.GET)
	public ModelAndView index2(String id){
		System.out.println("CustomerController.index()" + id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "name2");
		ModelAndView modelAndView = new ModelAndView("forward:index.jsp", map);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/index3/{id}",method=RequestMethod.GET)
	public List<Customer> index3(@PathVariable("id") String id){
		System.err.println(">>>>>>>>>>>>>>>>>>>> " + id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		return customerService.findAllCustomer();
	}
	
}
