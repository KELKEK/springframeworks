package com.shinhan.myapp.section1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TVUser {
	public static void main(String[] args) {
		f5();
	}
	private static void f5() {
		ApplicationContext context = new ClassPathXmlApplicationContext("dil.xml");
		
		TV tv = (TV)context.getBean("samsung1");
		TV tv2 = context.getBean("samsung2", TV.class); //바로 윗줄이랑 같은 말
		TV tv3 = context.getBean("lg", TV.class);
		
		tv.powerOn();
		tv.powerOff();
	}

	private static void f4() {
		Resource resource = new ClassPathResource("dil.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		TV tv = (TV)factory.getBean("samsung1");
		TV tv2 = factory.getBean("samsung2", TV.class); //바로 윗줄이랑 같은 말
		TV tv3 = factory.getBean("lg", TV.class);
		
		tv.powerOn();
		tv.powerOff();
	}

	private static void f3() {
		new SamsungTV("ABC");
		// TODO Auto-generated method stub
		//Factory pattrn : 생성은 Factory가 한다.
		TV tv = TVFactory.makeTV("lg");
		tv.powerOn();
		tv.powerOff();
	}
	private static void f2() {
		// TODO Auto-generated method stub
		LgTV tv = new LgTV();
		//interface패턴을 사용하면 구현객체가 없어도 사용법이 같다.
		tv.powerOn();
		tv.powerOff();
	}
	private static void f1() {
		// TODO Auto-generated method stub
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
	}
}
