package com.firstzone.day1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter@ToString
public class carVO {
	String model;
	int price;
	
	public static void main(String[] args) {
		carVO car1 = new carVO("abc", 1000);
		System.out.println(car1);
	}
}
