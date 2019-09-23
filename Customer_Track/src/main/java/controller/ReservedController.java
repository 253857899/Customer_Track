package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entry.Clienttype;
import entry.Customer;
import entry.Reserved;
import entry.Revisit;
import entry.Operator;
import service.ClienttypeService;
import service.CustomerService;
import service.ReservedService;
import service.RevisitService;
import service.OperatorService;
import utils.ReturnInfo;


@Controller
@RequestMapping("Reserved")
public class ReservedController extends BasicController<Reserved>{
	
	@Autowired
	ReservedService service;
	@Autowired
	CustomerService cservice;
	@Autowired
	OperatorService uservice;
	@Autowired
	RevisitService rservice;
	
	
	@Override
	public ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where=" where c_revisit.name like '%"+txt+"%'";
		return super.index(where, page, limit);
	}
	
	public @ResponseBody String  insert(Reserved b) {
		service.insert1(b);
		return "{\"status\":1}";
	}
	@RequestMapping("getClientname")
	public @ResponseBody List<Customer> getClientname() {
		return cservice.select1();
	}
	@RequestMapping("getUsername")
	public @ResponseBody List<Operator> getUsername() {
		return uservice.select1();
	}
	@RequestMapping("getRevisitname")
	public @ResponseBody List<Revisit> getRevisitname() {
		return rservice.select1();
	}
	@RequestMapping("getExecoperatorname")
	public @ResponseBody List<Operator> getExecoperatorname() {
		return uservice.select1();
	}
	
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Reserved.status_name;
	}
	@RequestMapping("getType")
	public @ResponseBody String[] getType() {
		return Reserved.type_name;
	}
	@RequestMapping("getExecstatus")
	public @ResponseBody String[] getExecstatus() {
		return Reserved.execstatus_name;
	}
}
