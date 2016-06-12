package com.member.school.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.member.school.mapper.SchoolMemberMapper;
import com.member.school.model.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private SchoolMemberMapper schoolMemberMapper;
	
	@Value("2. set Method 수행")
	private String message;
	
	public StudentServiceImpl(){
		System.out.println("1. StudentServiceImpl 생성자 메서드 수행");
	}
	
	@Transactional
	public void insertStudent(Student student) {
		schoolMemberMapper.insertStudent(student);
	}

	@PostConstruct
	public void initMethod(){
		System.out.println("2." + message);
		System.out.println("3. init method invoked");
	}
	
	@PreDestroy
	public void destroyMethod(){
		System.out.println("4. destroy method invoked");
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
