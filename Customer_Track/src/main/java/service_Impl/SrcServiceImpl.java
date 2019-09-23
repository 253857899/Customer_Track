package service_Impl;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Src_dao;
import entry.Src;

import service.SrcService;

@Service
public class SrcServiceImpl extends BasicServiceImpl<Src> implements SrcService{
	@Autowired
	Src_dao dao;

	public List<Src> select1() {
		return dao.select1();
	}

}
