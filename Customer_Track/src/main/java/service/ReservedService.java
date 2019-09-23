package service;

import java.util.List;

import entry.Reserved;

public interface ReservedService extends BasicService<Reserved>{
	List<Reserved> select1();
	public Integer insert1(Reserved o);
	
	}
