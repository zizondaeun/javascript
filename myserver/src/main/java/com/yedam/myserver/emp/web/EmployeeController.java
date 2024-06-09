package com.yedam.myserver.emp.web;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.emp.mapper.EmployeeMapper;
import com.yedam.myserver.emp.vo.Employee;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",  maxAge = 3600)
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeMapper employeeDao;   
	
	//사원검색
	@GetMapping(value="/empSelect")
	public List<Employee> selectDepartment() {
		return employeeDao.findEmployees();
	}	
	
	//사원 ID검색
	@GetMapping(value="/empId")
	public Employee findById(Employee emp) {
		return employeeDao.findById(emp);
	}
	
	//부서와 직업 검색
	@GetMapping(value="/empDeptJob")
	public Map<String, Object> jobDeptList() {
		Map<String, Object> map = new HashMap<>();
		map.put("jobs", employeeDao.findJobs());
		map.put("depts", employeeDao.findDepartments());
		return map;		
	}	
	
	//사원등록
	@PostMapping(value="/empInsert")
	public  Employee insertEmployees(@RequestBody Employee emp, HttpServletResponse response) {
		employeeDao.persist(emp);
		return emp;
	}
	
	//사원정보수정
	@PostMapping(value="/empUpdate" )
	public  Employee updateEmployees(@RequestBody Employee emp, HttpServletResponse response) {
		employeeDao.merge(emp);
		return emp;
	}	
	
	//사원삭제
	@PostMapping(value="/empDelete")
	public  Employee deleteEmployees(@RequestBody Employee emp, HttpServletResponse response) {
		employeeDao.remove(emp);
		return emp;
	}
}
