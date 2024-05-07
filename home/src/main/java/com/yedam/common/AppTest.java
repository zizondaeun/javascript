package com.yedam.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yedam.dao.EmpDAO;
import com.yedam.vo.EmpVO;

public class AppTest {
	public static void main(String[] args) {
		EmpDAO edao = new EmpDAO();
		EmpVO evo = new EmpVO();
		
		evo.setEmpName("홍길동");
		evo.setEmpPhone("01-222-222");
		evo.setEmail("ekdms@naver");
		evo.setHireDate("2024-02-02");
		evo.setSalary(111);
		
		edao.insertEmp(evo);
		
		System.out.println("====목록====");
		List<EmpVO> list  = edao.selectList();
		for(EmpVO vo : list) {
			System.out.println(vo.toString());
		}
		//기능되는지 테스트 해보는거
		Map<String, Integer> resultMap = edao.getCntPerDept(); //key값을 알아야 value알수있으니까
		Set<String> keyset = resultMap.keySet();
		for (String key : keyset) {
			System.out.println("key: " +key + ", val: " + resultMap.get(key));
		}
		//end of main(). 이걸가지고 서블릿(data가져와야하니까)에서 json형태로 바꿔
		
//		if(edao.insertEmp(evo)) {
//			System.out.println("처리성공");
//		}else {
//			System.out.println("처리실패");
//		}
		
		//*다시!!
		//evo = new EmpVO();
//		evo.setEmail("ddd@nnnnnn");
//		evo.setSalary(30000);
//		evo.setEmpNo(4);

//		edao.updateEmp(evo);
//		
//		if(edao.updateEmp(evo)) {
//			System.out.println("처리성공");
//		}else {
//			System.out.println("처리실패");
//		}
//		edao.deleteEmp(39);
		
//		if(edao.deleteEmp(46)) {
//			System.out.println("처리성공");
//		}else {
//			System.out.println("처리실패");
//		}
		

	}
	
	
}
