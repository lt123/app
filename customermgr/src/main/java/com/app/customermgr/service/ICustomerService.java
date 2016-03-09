package com.app.customermgr.service;

import java.util.List;
import java.util.Map;

import com.app.common.page.PageResult;
import com.app.customermgr.model.Customer;

public interface ICustomerService {
	public int insert(Customer customer);
	public List<Customer> findCustomerByCondition(Map<String,Object> map);
	public List<Customer> findAllCustomer();
	public PageResult<Customer> findPageResult();
}
