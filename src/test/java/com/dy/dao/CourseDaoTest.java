package com.dy.dao;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.dy.entity.Course;

public class CourseDaoTest {

	@Test
	public void findCourseById() {
		SqlSessionFactory sqlSessionFactory = getSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(); 
		CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
		Course course = courseDao.findCourseById(1);
	}
	
	
	//Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
	private static SqlSessionFactory getSessionFactory() {  
        SqlSessionFactory sessionFactory = null;  
        String resource = "mybatis-conf.xml";  
        try {  
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources  
                    .getResourceAsReader(resource));
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return sessionFactory;  
    }  
}
