package controller;

import java.lang.reflect.Field;

import java.lang.reflect.ParameterizedType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entry.Customer;
import service_Impl.BasicServiceImpl;
import utils.ReturnInfo;

@Controller
public class BasicController<T>  {
	
	BasicServiceImpl<T> basicservice;
	
	@ModelAttribute
	public void init() throws Exception{
		Field f=this.getClass().getDeclaredField("service");
		f.setAccessible(true);
		Object dao=f.get(this);
		basicservice=(BasicServiceImpl<T>) dao;
	}
	
	private String getTname() {
		return getRealType().getSimpleName();
	}
	
	public Class getRealType(){
		// 获取当前new的对象的泛型的父类类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获取第一个类型参数的真实类型
		return (Class<T>) pt.getActualTypeArguments()[0];
	}
	
	
	
	@GetMapping("")
	public @ResponseBody ReturnInfo index(String txt, Integer page, Integer limit) {
		
		return basicservice.select(txt, page, limit);
	}

	
	
	@GetMapping("{id}")
	public @ResponseBody T select(@PathVariable("id") Integer id) {
		return basicservice.selectByid(id);
	}
	


	@DeleteMapping("{id}")
	public @ResponseBody String  delete(@PathVariable("id")Integer b) {
		basicservice.delete(b);
		return "{\"status\":1}";
	}
	
	@PostMapping("")
	public @ResponseBody String  insert(T b) {
		basicservice.insert(b);
		return "{\"status\":1}";
	}
	
	@PutMapping("")
	public @ResponseBody String update(T b) {
		System.out.println(1);
		basicservice.update(b);
		return "{\"status\":1}";
	}

	@RequestMapping("delete")
	public String update2(T b) {
		return "{\"status\":1}";
	}
}
