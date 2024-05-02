package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.common.DAO;
import com.yedam.vo.EmpVO;

public class EmpDAO extends DAO {
	public List<Map<String, Object>> empList() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		conn();
		try {
			psmt = conn.prepareStatement("select * from emp");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("사원번호", rs.getString("emp_no"));
				map.put("사원이름", rs.getString("emp_name"));
				map.put("연락처", rs.getString("emp_phone"));
				map.put("이메일", rs.getString("email"));

				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return list;
	}

	// 목록 가져오기 List<EmpVO> selectList();
	public List<EmpVO> selectList() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		conn();
		try {
			psmt = conn.prepareStatement("select * from emp");
			rs = psmt.executeQuery();
			while (rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmpNo(rs.getInt("emp_no"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpPhone(rs.getString("emp_phone"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_Date"));
				emp.setSalary(rs.getInt("salary"));
				// emp.setDept(rs.getString("dept"));
				
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return list;
	}//end of selectList

	public EmpVO selectEmp(int empNo) {
		conn();
		try {
			psmt = conn.prepareStatement("select * from emp where emp_no = ?");
			psmt.setInt(1, empNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				EmpVO evo = new EmpVO();
				evo.setEmpNo(rs.getInt("emp_no"));
				evo.setEmpName(rs.getString("emp_name"));
				evo.setEmpPhone(rs.getString("emp_phone"));
				evo.setEmail(rs.getString("email"));
				evo.setHireDate(rs.getString("hire_Date"));
				evo.setSalary(rs.getInt("salary"));
				// emp.setDept(rs.getString("dept"));
				return evo; //있으면 evo 리턴해주고 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return null; //없으면 null 리턴
	}
	
	// 등록 리턴타입 boolean insertEmp(EmpVO evo);
	public boolean insertEmp(EmpVO evo) {
		conn();
		String sql = "insert into emp (emp_no,emp_name,emp_phone,email,hire_date,salary) "
				+ "values(?,?,?,?,?,?)"; //사번이 시퀀스로 되어있기때문에 시퀀스 가져오는 쿼리 만든다
		String seqSql = "select emp_seq.nextval from dual ";
		int seq = 0;
		try {
			psmt = conn.prepareStatement(seqSql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				seq = rs.getInt(1);
				evo.setEmpNo(seq); //매개변수의 evo에 empNo에 저장 /이거 뭐지..?
			}//시퀀스 가져오는거
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(2, evo.getEmpName());
			psmt.setString(3, evo.getEmpPhone());
			psmt.setString(4, evo.getEmail());
			psmt.setString(5, evo.getHireDate());
			psmt.setInt(6, evo.getSalary());
			psmt.setInt(1, seq);

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return false;
	}

	// 수정 boolean updateEmp(EmpVO evo); /수정항목 : 이메일, 급여
	public boolean updateEmp(EmpVO evo) {
		conn();
		String sql = "update emp " 
				+ "set email = ? " 
				+ ",salary = ? " 
				+ "where emp_no = ? ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, evo.getEmail());
			psmt.setInt(2, evo.getSalary());
			psmt.setInt(3, evo.getEmpNo());

			int r = psmt.executeUpdate();
			if (r > 0) { //성공
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return false;
	}

	// 삭제 boolean deleteEmp(int empNo);
	public boolean deleteEmp(int empNo) {
		conn();
		String sql = "delete from emp " 
				+ "where emp_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empNo);

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return false;
	}

}
