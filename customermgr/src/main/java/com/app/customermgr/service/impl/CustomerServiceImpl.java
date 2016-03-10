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
	public Integer insert(Customer customer) {
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

	/**
	 * 分页查询数据
	 * map传入数据：
	 * 			currentPage：当前页（不传默认为第一页）
	 * 			pageSize：每页的数量（不传默认为十条数据）
	 */
	@Override
	public PageResult<Customer> findPageResult(Map<String,Object> map) {
		Integer currentPage = Integer.parseInt(map.get("currentPage").toString());
		Integer pageSize = Integer.parseInt(map.get("pageSize").toString());;
		Integer totalCount = customerDao.findCountByCondition(map);
		map.put("currentPage", (currentPage - 1) * pageSize);
		List<Customer> rows = customerDao.findCustomerByCondition(map);
		return new PageResult<>(currentPage, pageSize, totalCount, rows);
	}
	
	@Override
	public PageResult<Customer> findPageResult() {
		Map<String,Object> map = new HashMap<>();
		return findPageResult(map);
	}

	@Override
	public Integer findCountByCondition(Map<String, Object> map) {
		return customerDao.findCountByCondition(map);
	}

	@Override
	public Integer delete(Integer id) {
		return customerDao.delete(id);
	}
}
