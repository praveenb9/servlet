package com.capg.webapplication;

public class Service {

ModelDAO daoobj=new ModelDAO();
	public int addUser(User uobject) {
		
	return  daoobj.addUser(uobject);
	}
}
