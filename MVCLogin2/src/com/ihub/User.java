package com.ihub;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty; 

public class User {
@NotEmpty
String userID;
@NotEmpty @Size(min=8 , max=15)
String password;
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
