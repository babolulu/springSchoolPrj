package com.member.school.mapper;

import com.member.school.model.Student;

public interface SchoolMemberMapper {
	/*@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")*/
	public void insertStudent(Student student);
	public Student getStudentByEmailAddress(String emailAddress);
}
