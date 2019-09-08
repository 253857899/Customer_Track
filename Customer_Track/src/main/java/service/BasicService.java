package service;

import java.util.List;


import utils.ReturnInfo;

public interface BasicService<T> {

	public ReturnInfo select(String where,Integer page,Integer max);
	
	public T selectByid(Integer id);
	
	public Integer insert(T b);
	
	public Integer update(T b);
	
	public Integer delete(Integer b);
}
