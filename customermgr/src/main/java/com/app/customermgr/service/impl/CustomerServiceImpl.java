package com.app.customermgr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.common.page.PageResult;
import com.app.customermgr.dao.ICustomerDao;
import com.app.customermgr.model.Customer;
import com.app.customermgr.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerDao customerDao;

	@Transactional
	public int insert(Customer customer) {
		return customerDao.insert(customer);
	}

	@Override
	public List<Customer> findCustomerByCondition(Map<String, Object> map) {
		return customerDao.findCustomerByCondition(map);
	}

	@Override
	public List<Customer> findAllCustomer() {
		Map<String,Object> map = new HashMap<String,Object>();
		return customerDao.findCustomerByCondition(map);
	}

	@Override
	public PageResult<Customer> findPageResult() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
