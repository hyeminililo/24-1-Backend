package net.skhu.dto;

import lombok.Data;

@Data
public class Course {
	
	int id;
	int year;
	String semester;
	String gubun;
	int professorId;
	String code;
	String title;
	String sigan;

	String professorName;
}
