package controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.Book_dao;
import entry.Type;
import entry.Book;
import service.BookService;
import service.TypeService;

@Controller
@RequestMapping("Type")
public class TypeController extends BasicController<Type> {
	@Autowired
	BookService bservice;
	
	@Autowired
	TypeService service;

	@RequestMapping("getStatus")
	public @ResponseBody String[] getStatus() {
		return Type.status_name;
	}
	
	@RequestMapping("getBookid")
	public @ResponseBody List<Book> getBookid() {
		return bservice.select();
	}


}