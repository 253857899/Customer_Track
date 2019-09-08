package service_Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Type_dao;

import entry.Type;

import service.TypeService;

@Service
public class TypeServiceImpl extends BasicServiceImpl<Type> implements TypeService{
	@Autowired
	Type_dao dao;

}
