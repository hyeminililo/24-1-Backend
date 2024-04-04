package net.skhu.dto;

import lombok.Data;

@Data
public class Student {
	
	int id;
	String studentNo;
	String name;
	String phone;
	String sex;
	String email;
	
	int departmentId;
	String departmentName;
}
