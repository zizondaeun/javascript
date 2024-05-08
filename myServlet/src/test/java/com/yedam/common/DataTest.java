package com.yedam.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.mapper.EmpMapper;

public class DataTest {
	public static void main(String[] args) { //apptest를 환경변수에 넣으려다 datatest로 새로 만듦
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true); //자동커밋false
		
		//삭제
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		int r = mapper.deleteEmp(206);
		System.out.println(r + "건 처리");
	}
}
