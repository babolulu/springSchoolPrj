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
	
	public boolean getStudentByLogin(String emailAddress, String password) {
		Student student = schoolMemberMapper.getStudentByEmailAddress(emailAddress);
		
		if(student != null && student.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}

	public boolean getStudentByEmailAddress(String emailAddress) {
		Student student = schoolMemberMapper.getStudentByEmailAddress(emailAddress);
		
		if(student != null) {
			return true;
		}
		
		return false;
	}

}
