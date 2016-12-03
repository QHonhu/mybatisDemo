package com.dy.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.dy.entity.Course;
import com.dy.entity.Student;

public class StudentDaoTest {

	@Test
	public void findCourseById() {
		SqlSessionFactory sqlSessionFactory = getSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(); 
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		Student student = studentDao.findStudentById("20140101");
		List<Course> courseList = student.getCourseList();
		for (Course course: courseList) {
			System.out.println(course.getId() + "   " + course.getName());
		}
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
