package com.prasun.springboot_aws_demo.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.prasun.springboot_aws_demo.controller.dto.Student;

@Repository
public class StudentRepository {

	@Autowired
	private DynamoDBMapper mapper;

	public Student addStudent(Student st) {
		mapper.save(st);
		return st;
	}

	public Student findStudentbyRoll(String srollno) {
		return mapper.load(Student.class, srollno);
	}

	public String deleteStudent(Student st) {
		mapper.delete(st);
		return "Student has been delete";

	}

	public String updateStudent(Student st) {
		mapper.save(st,buildExpression(st));
		return "Student record updated";
	}

	private DynamoDBSaveExpression buildExpression(Student st) {
		DynamoDBSaveExpression dynamoDBSaveexpression=new DynamoDBSaveExpression();
		Map<String,ExpectedAttributeValue> expectedMap=new HashMap<>();
		expectedMap.put("srollno",new ExpectedAttributeValue(new AttributeValue().withS(st.getSroll())));
		dynamoDBSaveexpression.setExpected(expectedMap);
		return dynamoDBSaveexpression;
		
	}
}
