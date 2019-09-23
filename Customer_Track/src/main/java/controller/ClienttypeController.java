package controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import entry.Clienttype;

import service.ClienttypeService;

import utils.ReturnInfo;

@Controller
@RequestMapping("Clienttype")
public class ClienttypeController  extends BasicController<Clienttype>{
		@Autowired
		ClienttypeService service;
		
		@Override
		public ReturnInfo index(String txt, Integer page, Integer limit) {
			String where="";
			if(txt!=null && txt!="")
				where=" where c_clienttype.name like '%"+txt+"%'";
			return super.index(where, page, limit);
		}
}
