package com.prasun.springboot_aws_demo.controller.dto;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBDocument
@DynamoDBTable(tableName="student")
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@DynamoDBAttribute
	private String sname;
	@DynamoDBAttribute
	@DynamoDBHashKey(attributeName="sroll")
	private String sroll;
	@DynamoDBAttribute
	private String saddress;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Student(String sname, String sroll, String saddress) {
		
		this.sname = sname;
		this.sroll = sroll;
		this.saddress = saddress;
	}
	public Student() {
		
	}
	public String getSroll() {
		return sroll;
	}
	public void setSroll(String sroll) {
		this.sroll = sroll;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
}
