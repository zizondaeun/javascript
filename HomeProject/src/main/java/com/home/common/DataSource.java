package com.home.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {

		//SqlSessionFactory 반환하기 위한 메소드 만들기
		public static SqlSessionFactory getInstance(){
			String resource = "config/mybatis-config.xml"; //xml을 가지고 객체를 만든대 /저기 안에 환경설정 파일들 따로 넣으실거래
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource); //스트림을 읽어드리기위한 클래스:Resources
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //inputStream초기값이 없어 null넣어줌
			
			return sqlSessionFactory;
		}
}
