package controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import entry.Group;

import service.GroupService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Group")
public class GroupController  extends BasicController<Group>{
		@Autowired
		GroupService service;
		
		@Override
		public ReturnInfo index(String txt, Integer page, Integer limit) {
			String where="";
			if(txt!=null && txt!="")
				where=" where c_workgroup.name like '%"+txt+"%'";
			return super.index(where, page, limit);
		}
}
