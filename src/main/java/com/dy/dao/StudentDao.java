package com.dy.dao;


import com.dy.entity.Student;

public interface StudentDao {

	public Student findStudentById(String idCard);
}
