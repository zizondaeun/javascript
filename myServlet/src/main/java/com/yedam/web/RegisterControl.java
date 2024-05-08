package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.EmpMapper;
import com.yedam.vo.EmployeeVO;

public class RegisterControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/info/registerEmp.jsp").forward(req, resp); //파일의 위치
		//registerEmp 에서 ../지우고 나니까 되네.. 밑에 필요 없네
		int id = (int) req.getAttribute("eid");
		String lName = (String) req.getAttribute("last_name");
		String fName = (String) req.getAttribute("first_name");
		String email = (String) req.getAttribute("email");
		String job = (String) req.getAttribute("job");
		
		EmployeeVO vo = new EmployeeVO();
		vo.setEmployeeId(id);
		vo.setLastName(lName);
		vo.setFirstName(fName);
		vo.setEmail(email);
		vo.setJobId(job);
		
		SqlSession session = DataSource.getInstance().openSession(true); //true 가 커밋
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		
		
	}

}
