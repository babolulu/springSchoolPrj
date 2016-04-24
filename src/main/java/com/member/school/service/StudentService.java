package com.member.school.service;

import com.member.school.model.Student;

public interface StudentService {
	void insertStudent(Student student);
	boolean getStudentByLogin(String userName, String password);
	boolean getStudentByUserName(String userName);
}
