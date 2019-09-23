package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entry.Clienttype;
import entry.Customer;
import entry.Revisit;
import service.CustomerService;
import service.RevisitService;

import utils.ReturnInfo;


@Controller
@RequestMapping("Revisit")
public class RevisitController extends BasicController<Revisit>{
	
	@Autowired
	RevisitService service;
	
	@Autowired
	CustomerService cservice;
	
	
	@Override
	public ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where=" where c_revisit.name like '%"+txt+"%'";
		return super.index(where, page, limit);
	}

	@RequestMapping("getClientname")
	public @ResponseBody List<Customer> getClientname() {
		return cservice.select1();
	}
	
	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Revisit.status_name;
	}
	@RequestMapping("getLinkstatus")
	public @ResponseBody String[] getLinkstatus() {
		return Revisit.linkstatus_name;
	}
	@RequestMapping("getClientstatus")
	public @ResponseBody String[] getClientstatus() {
		return Revisit.clientstatus_name;
	}
	@RequestMapping("getPurposestatus")
	public @ResponseBody String[] getPurposestatus() {
		return Revisit.purposestatus_name;
	}
	@RequestMapping("getAssessstatus")
	public @ResponseBody String[] getAssessstatus() {
		return Revisit.assessstatus_name;
	}

	
}
