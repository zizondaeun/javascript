package com.yedam.vo;

import lombok.Data;
//VO(Value Object)-필드들만 모아놓은 클래스(값 객체)
//애플리케이션에서 전송되거나 처리되는 데이터를 담는 객체를 말함
//주로 데이터 전송을 위한 목적으로 사용됩니다.데이터를 보유하고 있는 객체

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
