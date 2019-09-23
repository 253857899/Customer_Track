package service_Impl;


import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Customer_dao;

import entry.Customer;

import service.CustomerService;


@Service
public class CustomerServiceImpl extends BasicServiceImpl<Customer> implements CustomerService{
	@Autowired
	Customer_dao dao;

	public List<Customer> select1() {
		return dao.select1();
	}
	public Integer insert1(Customer o) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		o.setCreatedate(dateStr);
		return dao.insert(o);
	}
	public List<Customer> selects() {
		return dao.selects();
	}
	public Integer update1(Customer b) {
		return dao.update1(b);
	}
	public Integer update2(Customer b) {
		return dao.update2(b);
	}
}
