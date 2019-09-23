package service_Impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dao.Order_dao;
import entry.Order;
import entry.Reserved;
import service.OrderService;


@Service
public class OrderServiceImpl extends BasicServiceImpl<Order> implements OrderService{
	@Autowired
	Order_dao dao;

	public List<Order> select1() {
		return dao.select1();
	}
	public Integer insert1(Order o) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		o.setCreatedate(dateStr);
		return dao.insert(o);
	}
}
