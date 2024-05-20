package com.yedam.vo;

import lombok.Data;

@Data
public class CenterVO {
	private int id;
	private String centerName;
	private String sido;
	private String address;
	private String centerType;
	private String createdAt; //문자열을 날짜타입으로 바꿔줌 2024-12-31
	private String facilityName;
	private String lat;
	private String lng;
	private String org;
	private String phoneNumber;
	private String sigungu;
	private String updatedAt;
	private String zipCode;
}
