package com.onboard.model;

import java.util.Date;

public class Resource {
	
	private long id;
	
	private String email;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private boolean offshore;
	
	private boolean onboarded;
	
	private String sowname;
	
	private String sowrole;
	
	private Date initiatedDate;
	
	
	public Resource(String email, String firstName, String middleName,
			String lastName) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	

	public Date getInitiatedDate() {
		return initiatedDate;
	}

	public void setInitiatedDate(Date initiatedDate) {
		this.initiatedDate = initiatedDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isOffshore() {
		return offshore;
	}

	public void setOffshore(boolean offshore) {
		this.offshore = offshore;
	}

	public boolean isOnboarded() {
		return onboarded;
	}

	public void setOnboarded(boolean onboarded) {
		this.onboarded = onboarded;
	}

	public String getSowname() {
		return sowname;
	}

	public void setSowname(String sowname) {
		this.sowname = sowname;
	}

	public String getSowrole() {
		return sowrole;
	}

	public void setSowrole(String sowrole) {
		this.sowrole = sowrole;
	}
	

}
