package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entry.Customer;
import entry.Order;
import entry.Orderdetails;
import entry.Product;
import entry.Revisit;
import entry.Src;
import entry.Clienttype;
import entry.Reserved;
import entry.Operator;
import service.CustomerService;
import service.OrderService;
import service.OrderdetailsService;
import service.ProductService;
import service.RevisitService;
import service.SrcService;
import service.ClienttypeService;
import service.ReservedService;
import service.OperatorService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Order")
public class OrderController extends BasicController<Order>{
	
	@Autowired
	OrderService service;
	@Autowired
	OperatorService uservice;
	@Autowired
	CustomerService cservice;

	@Override
	public ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where=" where c_order.name like '%"+txt+"%'";
		return super.index(where, page, limit);
	}

	public @ResponseBody String  insert(Order b) {
		service.insert1(b);
		return "{\"status\":1}";
	}

	@RequestMapping("getUsername")
	public @ResponseBody List<Operator> getUsername() {
		return uservice.select1();
	}
	@RequestMapping("getClientname")
	public @ResponseBody List<Customer> getClientname() {
		return cservice.select1();
	}
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Order.status_name;
	}
}
