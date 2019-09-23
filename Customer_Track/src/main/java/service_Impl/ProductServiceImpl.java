package service_Impl;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Product_dao;
import dao.Src_dao;
import entry.Product;
import entry.Src;
import service.ProductService;
import service.SrcService;

@Service
public class ProductServiceImpl extends BasicServiceImpl<Product> implements ProductService{
	@Autowired
	Product_dao dao;

	public List<Product> select1() {
		return dao.select1();
	}

}
