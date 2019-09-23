package service_Impl;


import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dao.Order_dao;
import dao.Orderdetails_dao;
import entry.Order;
import entry.Orderdetails;
import service.OrderService;
import service.OrderdetailsService;


@Service
public class OrderdetailsServiceImpl extends BasicServiceImpl<Orderdetails> implements OrderdetailsService{
	@Autowired
	Orderdetails_dao dao;

	public List<Orderdetails> select1() {
		return dao.select1();
	}

	public Orderdetails selectByOrderId(Integer orderid) {
		return dao.selectByOrderId(orderid);
	} 

}
