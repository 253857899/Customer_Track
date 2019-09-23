package service_Impl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import dao.Revisit_dao;
import entry.Revisit;

import service.RevisitService;


@Service
public class RevisitServiceImpl extends BasicServiceImpl< Revisit> implements  RevisitService{
	@Autowired
	Revisit_dao dao;

	public List<Revisit> select1() {
		return dao.select1();
	}

}
