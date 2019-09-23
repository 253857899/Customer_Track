package service_Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Operator_dao;
import entry.Group;
import entry.Operator;
import service.OperatorService;

@Service
public class OperatorServiceImpl extends BasicServiceImpl<Operator> implements OperatorService{
	@Autowired
	Operator_dao dao;

	public Operator login(Operator t) {
		return dao.login(t);
	}
	public List<Operator> select1() {
		return dao.select1();
	}
}
