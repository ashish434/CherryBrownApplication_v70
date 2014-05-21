package com.tcs.ilp.domain;

/**
 * @author H55 - Group 1 The Domain class encapsulating Login Management
 */
public class Login {
	private String userid;
	private String password;
	private String role;

	public Login(String userid, String password) {

		this.userid = userid;
		this.password = password;
	}

	public Login(String userid, String password, String role) {

		this.userid = userid;
		this.password = password;
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Login [userid=" + userid + ", password=" + password + ", role="
				+ role + "]";
	}

	public Login() {
	}
	
	public boolean equals(Object o)
	{
		Login objLogin=(Login)o;
		
		if(this.getUserid().equals(objLogin.getUserid()) && this.getPassword().equals(objLogin.getPassword())
			&& this.role.equals(objLogin.getRole()))
			
			return true;
		else
			return false;
	}
	

}
