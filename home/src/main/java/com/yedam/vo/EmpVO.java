package com.yedam.vo;

import lombok.Data;
//VO-필드들만 모아놓은 클래스
//lombok:이클립스에 설치, 라이브러리 필요

@Data
public class EmpVO {
	private int empNo; //오라클(emp_no) / 자바(empNO)
	private String empName;
	private String empPhone;
	private String email;
	private String hireDate; //2020-05-01
	private int salary;
	//private String dept;
	

}
