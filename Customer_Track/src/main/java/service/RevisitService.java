package service;

import java.util.List;

import entry.Revisit;

public interface RevisitService extends BasicService<Revisit>{
	List<Revisit> select1();
}
