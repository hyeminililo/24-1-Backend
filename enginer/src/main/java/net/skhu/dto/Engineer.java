package net.skhu.dto;

import lombok.Data;

@Data
public class Engineer {
	int id;
	String engineerNo;
	String name;
	int roleId;
	String phone;	
	String sex;
	String email;
	
	String roleName;
}
