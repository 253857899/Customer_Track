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
@RequestMapping("Orderdetails")
public class OrderdetailsController extends BasicController<Orderdetails>{
	@Autowired
	OrderdetailsService service;

	@Autowired
	OrderService oservice;
	@Autowired
	ProductService pservice;

	@Override
	public ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where=" where c_order.name like '%"+txt+"%'";
		return super.index(where, page, limit);
	}

	

	@RequestMapping("getOrdername")
	public @ResponseBody List<Order> getOrdername() {
		return oservice.select1();
	}
	@RequestMapping("getProductname")
	public @ResponseBody List<Product> getProductname() {
		return pservice.select1();
	}

}
