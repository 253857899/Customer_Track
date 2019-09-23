package controller;



import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import entry.Group;


import entry.Operator;

import service.GroupService;


import service.OperatorService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Operator")
public class OperatorController extends BasicController<Operator>{
	
	@Autowired
	OperatorService service;
	@RequestMapping("login")
		public String login(Operator u,String code,ModelMap m,HttpSession s,HttpServletResponse resp,HttpServletRequest req) {
//			String num=s.getAttribute("number").toString();
//			if(!num.equalsIgnoreCase(code)) {
//				req.setAttribute("key", 2);
//				return "redirect:/login.html";
//			}
		System.out.println(u.getName() + u.getPass());
			
				try {
				//	SecurityUtils.getSubject().getSession().setTimeout(5000);
					SecurityUtils.getSubject().login(new UsernamePasswordToken(u.getName(),
					u.getPass()));
					}catch(AccountException e) {
					return "redirect: ../X-admin/login.html";
					}
					return "redirect: ../X-admin/index.html";
					
	}
	@RequestMapping("outlogin")
	public String login(HttpSession s, HttpServletRequest req) {
		SecurityUtils.getSubject().logout();
		return "redirect: ../X-admin/login.html";
	}
	
	@Autowired
	GroupService pservice;

	
	@Override
	public ReturnInfo index(String txt, Integer page, Integer limit) {
		String where="";
		if(txt!=null && txt!="")
			where=" where c_operator.name like '%"+txt+"%'";
		return super.index(where, page, limit);
	}

	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Operator.status_name;
	}
	@RequestMapping("getPower")
	public @ResponseBody String[] getPower() {
		return Operator.power_name;
	}

	@RequestMapping("getGroup")
	public @ResponseBody List<Group> getGroup() {
		return pservice.select1();
	}
	
}
