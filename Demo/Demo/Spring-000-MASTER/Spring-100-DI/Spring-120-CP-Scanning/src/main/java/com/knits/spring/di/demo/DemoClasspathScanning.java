package com.knits.spring.di.demo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cid.service.CidService;
import com.cid.utils.CidMocks;



@Slf4j
public class DemoClasspathScanning {

	public static void main(String[] args) {
		demo01_saveUser();
	}

	private static void demo01_saveUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cid-beans.xml");
		context.getBean(CidService.class).feature(CidMocks.mockUser());
	}

}
