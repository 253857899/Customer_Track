package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entry.Customer;
import entry.Revisit;
import entry.Src;
import entry.Clienttype;
import entry.Customer;
import entry.Reserved;
import entry.Operator;
import service.CustomerService;
import service.RevisitService;
import service.SrcService;
import service.ClienttypeService;
import service.ReservedService;
import service.OperatorService;
import utils.ReturnInfo;


@Controller
@RequestMapping("Customer_pool_do")
public class Customer_pool_doController extends BasicController<Customer>{
	
	@Autowired
	CustomerService service;
	@Autowired
	OperatorService uservice;
	@Autowired
	ClienttypeService tservice;
	@Autowired
	SrcService sservice;


	@Override
	public ReturnInfo index(String txt, Integer page, Integer limit) {
		String where=" where c_client.operatorids is not null and c_client.operatorids != '' ";
		if(txt!=null && txt!="")
			where=" where (c_client.operatorids is not null and c_client.operatorids != '') and c_client.name like '%"+txt+"%'";
		return super.index(where, page, limit);
	}
	
	@Override
	public @ResponseBody String insert(Customer b) {
		service.insert1(b);
		return "{\"status\":1}";
	}
	
	@Override
	public @ResponseBody String update(Customer b) {
		 service.update1(b);
		return "{\"status\":1}";
	}
	
	@Override
	public @ResponseBody String update2(Customer b) {
		 service.update2(b);
		return "{\"status\":1}";
	}
	
	
	@RequestMapping("getCreateoperatorname")
	public @ResponseBody List<Operator> getCreateoperatorname() {
		return uservice.select1();
	}
	@RequestMapping("getTypename")
	public @ResponseBody List<Clienttype> getTypename() {
		return tservice.select1();
	}
	@RequestMapping("getSrcname")
	public @ResponseBody List<Src> getSrcname() {
		return sservice.select1();
	}
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Customer.status_name;
	}
	@RequestMapping("getSex")
	public @ResponseBody String[] getSex() {
		return Customer.sex_name;
	}
	@RequestMapping("getLinkstatus")
	public @ResponseBody String[] getLinkstatus() {
		return Customer.linkstatus_name;
	}
	@RequestMapping("getClientstatus")
	public @ResponseBody String[] getClientstatus() {
		return Customer.clientstatus_name;
	}
	@RequestMapping("getPurposestatus")
	public @ResponseBody String[] getPurposestatus() {
		return Customer.purposestatus_name;
	}
	@RequestMapping("getAssessstatus")
	public @ResponseBody String[] getAssessstatus() {
		return Customer.assessstatus_name;
	}
	@RequestMapping("getExecstatus")
	public @ResponseBody String[] getExecstatus() {
		return Customer.execstatus_name;
	}
	


	
}
