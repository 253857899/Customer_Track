package service;


import java.util.List;

import entry.Group;

public interface GroupService extends BasicService<Group>{
	List<Group> select1();
}

