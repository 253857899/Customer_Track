package service_Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Book_dao;
import entry.Book;

import service.BookService;

@Service
public class BookServiceImpl extends BasicServiceImpl<Book> implements BookService{
	@Autowired
	Book_dao dao;

	public List<Book> select() {
		return dao.select();
	}	
}
