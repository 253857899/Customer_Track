package service;





import java.util.List;

import entry.Customer;
import entry.Order;


public interface CustomerService extends BasicService<Customer>{
	List<Customer> select1();
	public Integer insert1(Customer o);
	List<Customer> selects();
	public Integer update1(Customer b);
	public Integer update2(Customer b);
}
