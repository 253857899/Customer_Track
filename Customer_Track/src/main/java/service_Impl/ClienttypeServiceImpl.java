package service_Impl;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Clienttype_dao;
import entry.Clienttype;

import service.ClienttypeService;

@Service
public class ClienttypeServiceImpl extends BasicServiceImpl<Clienttype> implements ClienttypeService{
	@Autowired
	Clienttype_dao dao;

	public List<Clienttype> select1() {
		return dao.select1();
	}

}
