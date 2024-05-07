package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.common.DAO;
import com.yedam.vo.EmpVO;

public class EmpDAO extends DAO {
	//<Map<String, Object>> map은 key와 value를 가진 컬렉션의 종류
	//Object는 자바에서 모든 클래스의 부모 클래스입니다. 
	//즉, 모든 자바 객체는 Object 클래스의 하위 클래스입니다. 
	//이것은 모든 종류의 객체를 저장할 수 있는 map을 만들기 위해 Object 타입을 사용하는 것입니다.
	
	public List<Map<String, Object>> empList() { 
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		conn(); //conn() 메소드 호출은 데이터베이스에 대한 연결하는 역할.
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
			e.printStackTrace(); //예외가 발생했을 때 발생한 예외의 스택 트레이스를 출력하는 메소드
			//어떤 메소드에서 어떤 예외가 발생했는지,예외가 발생한 이유를 추적할수 있음
		} finally {
			disCon(); //disCon() 메소드 호출은 데이터베이스 연결을 닫는 역할. (안전하게 종료하는 것을 보장하기 위함)
		}
		return list;
	}
	
	//메소드를 사용하여 데이터베이스 작업을 캡슐화하는 이유(select,insert,update,delete)
	//데이터베이스 작업을 메소드로 추상화하면 코드의 가독성, 유지보수성, 재사용성이 향상되며, 에러 처리와 예외 처리도 효율적으로 관리가능
	
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
	
	//부서별 인원 현황 메소드. 부서: 인원 현황
	public Map<String, Integer> getCntPerDept(){
		conn();
		Map<String, Integer> map = new HashMap<>();
		String sql = " select d.department_name " //부서정보 /String:department_name, Integer:count(1)
				+ "        , count(1) as cnt " //cnt
				+ " from hr.employees e "
				+ " join hr.departments d "
				+ " on e.department_id = d.department_id "
				+ " group by d.department_name";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				map.put(rs.getString("department_name"), rs.getInt("cnt"));
				
			}
		}catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			disCon(); 
		}
		return map;
	}
	
	//datatable 생성예제
	public List<List<String>> getDataTable(){ //json의 데이터값들을 보니 list의 문자타입으로 하면 될거같아서
		List<List<String>> list = new ArrayList<List<String>>(); //처음부터 map컬렉션으로 할수는 없는지?
		conn();
		String sql = " select e.* "
				+ " from hr.employees e";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				List<String> row = new ArrayList<>();
				row.add(rs.getString("employee_id"));
				row.add(rs.getString("first_name"));
				row.add(rs.getString("email"));
				row.add(rs.getString("phone_number"));
				row.add(rs.getString("salary"));
				
				list.add(row);
			}
		}catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			disCon(); 
		}
		return list;
	}
	
	//jsp에 있는 employees 테이블의 사원번호값을 찾아서 한건 삭제하는 기능 추가하기
	public boolean deleteEmployee(int eno){
		conn();
		String sql = " delete from employees "
				+ " where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eno); //맞나?

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return false; //이렇게 하고 db에서도 실제로 지워졌는지 다시 확인해보기
	}


}
