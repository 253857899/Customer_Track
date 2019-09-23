package service_Impl;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Reserved_dao;
import entry.Reserved;
import service.ReservedService;


@Service
public class ReservedServiceImpl extends BasicServiceImpl< Reserved> implements  ReservedService{
	@Autowired
	Reserved_dao dao;

	public List<Reserved> select1() {
		return dao.select1();
	}
	public Integer insert1(Reserved o) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		o.setCreatedate(dateStr);
		return dao.insert(o);
	}
}
