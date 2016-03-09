package com.architecture.customermgr.spring;

import java.util.Date;
import java.util.List;

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
}
