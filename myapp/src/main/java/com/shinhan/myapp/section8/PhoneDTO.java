package com.shinhan.myapp.section8;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("my")
@Data
public class PhoneDTO {
	String model;
	String color;
}
