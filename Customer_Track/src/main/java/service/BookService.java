package service;


import java.util.List;

import entry.Book;

public interface BookService extends BasicService<Book>{

	List<Book> select();

}
