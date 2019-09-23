package service_Impl;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Group_dao;
import entry.Group;

import service.GroupService;

@Service
public class GroupServiceImpl extends BasicServiceImpl<Group> implements GroupService{
	@Autowired
	Group_dao dao;

	public List<Group> select1() {
		return dao.select1();
	}

}
