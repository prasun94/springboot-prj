package com.prasun.springboot_aws_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prasun.springboot_aws_demo.controller.dto.Student;
import com.prasun.springboot_aws_demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	public StudentService sService;

	@PostMapping("/register")
	public Student addStudent(@RequestBody Student students) {
		return sService.addStudent(students);
	}

	@GetMapping("/getstudent/{sroll}")
	public Student findStudentbyRoll(@PathVariable String sroll) {
		return sService.findStudentByRoll(sroll);

	}

	@DeleteMapping("/deletestudent")
	public String deleteStudent(@RequestBody Student students) {
		return sService.deleteStudent(students);
	}
	
	@PutMapping("/updatestudent")
	public String updateStudent(@RequestBody Student st) {
		return sService.updateStudent(st);
	}

}
