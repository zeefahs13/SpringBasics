package com.springbasics.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class IoCClient {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		
		InvOfControl ioc1 = (InvOfControl) context.getBean("ioc");
		
		InvOfControl ioc2 = context.getBean("ioc",InvOfControl.class);
		
		System.out.println("********************* Spring IoC in Action***************************");
		
		System.out.println(ioc1.toString());
		System.out.println(ioc2.toString());
		
		
		
		Resource res = new ClassPathResource("IoC.xml");
		BeanFactory factory = new XmlBeanFactory(res); //Spring container which will parse xml and construct Object
		InvOfControl ioc = (InvOfControl) factory.getBean("ioc");
		System.out.println(ioc.toString());
		
	}
	
	
	

}
