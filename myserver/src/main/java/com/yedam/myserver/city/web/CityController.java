package com.yedam.myserver.city.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yedam.myserver.city.CityVO;
import com.yedam.myserver.city.modifyVO;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*",  maxAge = 3600)
public class CityController {

	@PutMapping("/modifyData")
	@ResponseBody
	public boolean modifyData(@RequestBody modifyVO<CityVO> mvo) {
		System.out.println(mvo);
		return true;
	}
}
