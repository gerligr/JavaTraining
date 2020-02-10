package com.knits.spring.di.demo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cid.service.CidService;
import com.cid.utils.CidMocks;
import com.knits.spring.di.config.AppConfigCid;

@Slf4j
public class CidDemoJavaConfiguration {

	public static void main(String[] args) {
		demo01_saveUser();
		//demo02_collectionInjection();
	}
	
	private static void demo01_saveUser(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigCid.class);
		context.getBean(CidService.class).feature(CidMocks.mockUser());
	}		
	
}
