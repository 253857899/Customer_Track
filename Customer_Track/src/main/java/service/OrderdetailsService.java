package service;





import java.util.List;

import entry.Customer;
import entry.Order;
import entry.Orderdetails;


public interface OrderdetailsService extends BasicService<Orderdetails>{
	List<Orderdetails> select1();
	public Orderdetails selectByOrderId(Integer orderid);
	}
