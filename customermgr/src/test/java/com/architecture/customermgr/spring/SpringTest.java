package com.architecture.customermgr.spring;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.customermgr.model.Customer;
import com.app.customermgr.service.ICustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-root.xml")
public class SpringTest {
	@Autowired
	private ICustomerService customerService;
	
	@Test
	public void test01() throws Exception {
		Customer customer = new Customer();
		customer.setPwd("pwd");
		customer.setRegisterTime(new Date().toString());
		customer.setShowName("showname");
		customer.setTrueName("trueName");
		customer.setCustomerId("cId");
		System.err.println("customerService>>>>>>>>>>> " + customerService.insert(customer));
		System.err.println("uuid>>>>>>>>>>>>>>>>>>>" + customer.getUuid());
	}
	
	@Test
	public void test02() throws Exception {
		List<Customer> customers = customerService.findAllCustomer();
		for (Customer customer : customers) {
			System.err.println("customer>>>>  >>>>  " + customer);
		}
	}
	
	@Test
	public void test03() throws Exception {
		Map<String,Object> m = new HashMap<>();
		m.put("trueName", "trueName2");
		System.out.println(customerService.findCountByCondition(m));
	}
}
