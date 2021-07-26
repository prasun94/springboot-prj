package com.prasun.springboot_aws_demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasun.springboot_aws_demo.controller.dto.Student;
import com.prasun.springboot_aws_demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository sRepo;
	
	public Student addStudent(Student st) {
		sRepo.addStudent(st);
		return st;
	}
	public String deleteStudent(Student st) {
		return sRepo.deleteStudent(st);
		
	}
	
	public String updateStudent(Student st) {
		return sRepo.updateStudent(st);
	}
	
	public Student findStudentByRoll(String srollno) {
		return sRepo.findStudentbyRoll(srollno);
	}

}
