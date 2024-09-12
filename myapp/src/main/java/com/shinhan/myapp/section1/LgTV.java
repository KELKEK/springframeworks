package com.shinhan.myapp.section1;

public class LgTV implements TV{
	public LgTV(){
		System.out.println("default LgTV 모델 : ");
	}
	public LgTV(String model){
		System.out.println("default LgTV 모델 : " + model);
	}
	
	public void powerOn() {
		System.out.println("*****LG POWER ON&***");
		System.out.println(getClass().getSimpleName() + "전원을 켠다.");
	}
	public void powerOff() {
		System.out.println("*****LG POWER ON&***");
		System.out.println(getClass().getSimpleName() + "전원을 끈다.");
	}

}
