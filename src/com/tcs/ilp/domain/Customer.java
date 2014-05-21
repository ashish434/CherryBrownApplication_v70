package com.tcs.ilp.domain;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/**
 * @author H55 - Group 1 The Domain class encapsulating a Customer It contains
 *         all the getter and setter methods
 */
public class Customer extends Object {

	private String name;
	private String customerId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	String password;

	private int age;
	private String gender;
	private String location;
	private String emailId;
	private String contactNumber;

	public Customer() {

	}

	public Customer(String name, int age, String gender, String location,
			String emailId, String contactNumber) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
	}

	public Customer(String customerId, String password, String name, int age,
			String gender, String location, String emailId, String contactNumber) {
		this.name = name;
		this.age = age;
		this.customerId = customerId;
		this.gender = gender;
		this.password = password;
		this.location = location;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
	}

	@RequiredStringValidator(fieldName = "name", message = "Name is required")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@RequiredFieldValidator(fieldName = "age", message = "You must enter a age.")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@RequiredStringValidator(fieldName = "gender", message = "Gender is required")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@RequiredStringValidator(fieldName = "location", message = "Location is required")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@RequiredStringValidator(fieldName = "emailId", message = "EmailId is required")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@RequiredStringValidator(fieldName = "contactNumber", message = "ContactNumber is required")
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String toString() {
		return "Customer [Name=" + name + "Age=" + age + ", Contact Number="
				+ contactNumber + ", Email-id=" + emailId + ", Gender="
				+ gender + ", Location=" + location + "]";
	}
	
	public boolean equals(Object o)
	{
		Customer objCustomer=(Customer)o;
		
		if(this.getName().equals(objCustomer.getName()) && this.getAge()==objCustomer.getAge()
			&& this.getGender().equals(objCustomer.getGender()) && this.getLocation().equals(objCustomer.getLocation())
			&& this.emailId.equals(objCustomer.getEmailId()) && this.getContactNumber().equals(objCustomer.getContactNumber()))
			
			return true;
		else
			return false;
	}
	
}