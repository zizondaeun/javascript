package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.mapper.EmpMapper;
import com.yedam.vo.EmployeeVO;

public class Apptest {
	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true); //자동커밋false
		
		//삽입
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		EmployeeVO evo = new EmployeeVO();
		evo.setEmployeeId(999);
		evo.setFirstName("길동");
		evo.setLastName("홍");
		evo.setEmail("hong@email");
		evo.setJobId("IT_PROG");
		
		//삽입
		int r = mapper.insertEmp(evo);
		//삭제
		mapper.deleteEmp(999);
		//int r = mapper.deleteEmp(evo.getEmployeeId());
		System.out.println(r + "건 처리");
		//session.commit(); //커밋
		
		List<EmployeeVO> list = mapper.selectEmp(); 
		//이게 더 자바스러운 코드.. 자바스럽다..?/session.selectList("com.yedam.mapper.EmpMapper.selectEmp"); //selectList은 목록 가져오기
		System.out.println(list.size());
		for(EmployeeVO emp : list) {
			System.out.println(emp.toString());
		}
	}
}
