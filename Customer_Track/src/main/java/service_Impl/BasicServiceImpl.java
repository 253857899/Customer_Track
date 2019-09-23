package service_Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import service.BasicService;
import utils.ReturnInfo;

@Service
public class BasicServiceImpl<T> implements BasicService<T>{


@SuppressWarnings("rawtypes")
private Object execDao(String mname,Object... objs){
	try {
	Field f = this.getClass().getDeclaredField("dao");
	f.setAccessible(true);
	Object dao = f.get(this);
	Class<? extends Object> cls = dao.getClass();  //dao的字节码
	Class[] cs=new Class[objs.length];
	for(int i=0;i<objs.length;i++)cs[i]=objs[i].getClass();
	Method m= cls.getMethod(mname, cs);
	m.setAccessible(true);
	return m.invoke(dao, objs);
	}catch (Exception e) {
		return null;
	}
	
}
public ReturnInfo select(String where, Integer page, Integer max) {
	boolean canpage = page != null;
	ReturnInfo info = new ReturnInfo();
	info.setList((List<?>) execDao("select",where, ReturnInfo.getLimit(page, max)));
	if (canpage)
		info.setCount((Integer) execDao("search",where));
	return info; 
}


public Integer delete(Integer b) {
	Object o=execDao("delete",b);
	if(o!=null) return (Integer) o;
	else return -2;
}

public Integer insert(T b) {
	Object o=execDao("insert",b);
	if(o!=null) return (Integer) o;
	else return -2;
}

public Integer update(T b) {
	Object o=execDao("update",b);
	if(o!=null) return (Integer) o;
	else return -2;
}

public T selectByid(Integer id) {
	Object o=execDao("selectById",id);
	if(o!=null) return (T) o;
	else return null;
}

}