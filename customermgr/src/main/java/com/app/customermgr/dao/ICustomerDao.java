package com.app.customermgr.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.app.customermgr.model.Customer;

@Repository
public interface ICustomerDao {
	public int insert(Customer customer);
	public int update(Customer customer);
	public int delete(Customer customer);
	public Customer getCustomerById(Integer id);
	public List<Customer> findCustomerByCondition(Map<String,Object> map);
}
