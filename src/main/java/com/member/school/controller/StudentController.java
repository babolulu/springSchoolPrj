package com.member.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.member.school.model.Student;
import com.member.school.model.StudentLogin;
import com.member.school.service.StudentService;

@Controller
@SessionAttributes(value = { "student", "studentLogin"})
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@ModelAttribute("student") Student student) {
		boolean found = studentService.getStudentByLogin(
				student.getEmailAddress(), student.getPassword());
		if (found) {
			return "main";
		} else {
			return "index";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(@ModelAttribute("studentLogin") StudentLogin studentLogin, Model model) {
		System.out.println("session확인 : get login 호출 studentLogin.getEmailAddress() = " + studentLogin.getEmailAddress());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("studentLogin") StudentLogin studentLogin) {
		return "redirect:main.html";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(@ModelAttribute("student") Student student) {
		System.out.println("session확인 : student.getPassword() = " + student.getPassword());
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("student") Student student, Model model, SessionStatus sessionStatus) {
		if (studentService.getStudentByEmailAddress(student.getEmailAddress())) {
			model.addAttribute("message",
					"User Name exists. Try another user name");
			return "signup";
		} else {
			studentService.insertStudent(student);
			sessionStatus.setComplete();
			model.addAttribute("message", "Saved student details");
			return "redirect:login.html";
		}
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(@ModelAttribute("student") Student student, @ModelAttribute("studentLogin") StudentLogin studentLogin, Model model) {

		boolean found = studentService.getStudentByLogin(
				studentLogin.getEmailAddress(), studentLogin.getPassword());
		if (found) {
			model.addAttribute("student", new Student(studentLogin.getEmailAddress(), studentLogin.getPassword()));
			model.addAttribute("nickName", studentService.getNickNameByEmailAddress(studentLogin.getEmailAddress()));
			System.out.println("session확인 : student.getPassword() = " + studentLogin.getPassword());
			return "main";
		} else {
			return "failure";
		}
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(@ModelAttribute("student") Student student, Model model) {
		System.out.println("session확인 : student.getPassword() = " + student.getPassword());
		model.addAttribute("message", "연락처 안내합니다.");
		return "contact";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		model.addAttribute("message", "Logout student");
		return "redirect:login.html";
	}

}
