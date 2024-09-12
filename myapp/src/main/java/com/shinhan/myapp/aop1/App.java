package com.shinhan.myapp.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop1.xml");
		Calculator cal = ctx.getBean("proxyCal", Calculator.class);
		cal.add(10, 30);
	}

}
