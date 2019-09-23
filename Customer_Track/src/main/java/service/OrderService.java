package service;






import java.util.List;

import entry.Order;


public interface OrderService extends BasicService<Order>{
	List<Order> select1();
	public Integer insert1(Order o);
}
