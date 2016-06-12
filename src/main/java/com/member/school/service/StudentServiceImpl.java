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
	
	@Value("set Method invoked using @Value to set message field")
	private String message;
	
	public StudentServiceImpl(){
		System.out.println("1. StudentServiceImpl() constructor method invoked");
	}
	
	@Transactional
	public void insertStudent(Student student) {
		schoolMemberMapper.insertStudent(student);
	}

	@PostConstruct
	public void initMethod(){
		System.out.println("3. " + message);
		System.out.println("4. initMethod() method invoked");
	}
	
	@PreDestroy
	public void destroyMethod(){
		System.out.println("6. destroyMethod() method invoked");
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
