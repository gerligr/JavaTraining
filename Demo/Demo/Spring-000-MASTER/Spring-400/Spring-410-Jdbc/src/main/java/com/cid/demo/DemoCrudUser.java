package com.cid.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cid.config.AppConfigCid;
import com.cid.dao.UserDao;
import com.cid.model.User;


public class DemoCrudUser {

	public static void main(String[] args) {		
		
		demoDaoImplByName("userDaoJdbcSupportImpl");
		demoDaoImplByName("userDaoJdbcTemplate");
		demoDaoImplByName("userDaoNamedParametersJdbcTemplate");		
	}
	
	
	private static void demoDaoImplByName(String daoBeanImpl){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigCid.class);
		UserDao userDao= context.getBean(daoBeanImpl,UserDao.class);
		User user= userDao.findById(8);		
		System.out.println("Found "+user.toString());
	}

}
