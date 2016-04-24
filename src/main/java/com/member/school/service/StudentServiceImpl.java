package com.member.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.member.school.mapper.SchoolMemberMapper;
import com.member.school.model.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private SchoolMemberMapper schoolMemberMapper;
	
	@Transactional
	public void insertStudent(Student student) {
		schoolMemberMapper.insertStudent(student);
	}

	public boolean getStudentByLogin(String userName, String password) {
		Student student = schoolMemberMapper.getStudentByUserName(userName);
		
		if(student != null && student.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}

	public boolean getStudentByUserName(String userName) {
		Student student = schoolMemberMapper.getStudentByUserName(userName);
		
		if(student != null) {
			return true;
		}
		
		return false;
	}

}
