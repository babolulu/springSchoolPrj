package com.member.school.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.member.school.model.Student;
import com.member.school.model.StudentLogin;

@ControllerAdvice
public class AdviceController {

	@ModelAttribute(value="student")
	public void createStudentSession(Model model) {
		model.addAttribute("student", new Student());
	}
	
	@ModelAttribute(value="studentLogin")
	public void createStudentLoginSession(Model model) {
		model.addAttribute("studentLogin", new StudentLogin());
	}
	
}
