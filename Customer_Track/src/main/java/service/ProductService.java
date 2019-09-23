package service;


import java.util.List;

import entry.Product;

public interface ProductService extends BasicService<Product>{
	List<Product> select1();
}

