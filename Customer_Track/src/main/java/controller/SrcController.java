package controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import entry.Src;

import service.SrcService;

import utils.ReturnInfo;

@Controller
@RequestMapping("Src")
public class SrcController  extends BasicController<Src>{
		@Autowired
		SrcService service;
		
		@Override
		public ReturnInfo index(String txt, Integer page, Integer limit) {
			String where="";
			if(txt!=null && txt!="")
				where=" where c_src.name like '%"+txt+"%'";
			return super.index(where, page, limit);
		}
}
