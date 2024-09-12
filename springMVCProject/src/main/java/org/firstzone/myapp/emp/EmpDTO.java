package org.firstzone.myapp.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//DTO(Data Transfer Object), �뜲�씠�꽣媛� �쟾�넚�맆 �븣�뒗 �빆�긽 DTO瑜� �씠�슜�븳�떎.(�븳 嫄댁뿉 �뿬�윭 �뜲�씠�꽣瑜� �떞湲� �쐞�빐 �븘�슂�븳 �겢�옒�뒪)
//JavaBeans湲곗닠�뿉�꽌 �씠�슜(JSP, Spring, Mybatis�뒗 javabeans湲곗닠�쓣 �씠�슜�븳�떎.)
//�뼱�뼡 怨녹뿉�꽑 DTO ���떊 VO�씪怨� �븯湲곕룄 �븳�떎.
@Getter@Setter@ToString
@AllArgsConstructor //�븘�닔
@NoArgsConstructor //�븘�닔
public class EmpDTO {
	//移쇰읆�씠由� �꽑�뼵
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private int salary;
	private double commission_pct;
	private int manager_id;
	private int department_id;
	
	//ctrl+shift+y : ��臾몄옄 -> �냼臾몄옄
}
