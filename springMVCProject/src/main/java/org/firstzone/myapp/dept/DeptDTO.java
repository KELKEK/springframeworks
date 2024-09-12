package org.firstzone.myapp.dept;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//�젣�씪 癒쇱�
//移쇰읆 �씠由� 媛숈븘�빞 醫뗭쓬
//run sql �뿉�꽌 alt + �뒪�겕濡ㅽ빐�꽌 �슦�겢由��빐�꽌 蹂듭궗
//ctrl shift y濡� �냼臾몄옄, ; 遺숈씠湲�

//VO (Value Object)
//DTO(Data Transfer Object
//JavaBeans湲곗닠�뿉�꽌 �씠�슜(Jsp, String, Mybatis�뒗 javabeans湲곗닠�쓣 �씠�슜�븳�떎.)


@ToString
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeptDTO {
	int department_id;
	String department_name;
	int manager_id;
	int location_id;
}
