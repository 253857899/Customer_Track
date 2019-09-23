package service;


import java.util.List;

import entry.Operator;

public interface OperatorService extends BasicService<Operator>{
	public Operator login(Operator t);
	List<Operator> select1();
}
