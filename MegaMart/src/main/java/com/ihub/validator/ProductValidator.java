package com.ihub.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ihub.model.Login;
import com.ihub.model.Product;
import com.ihub.model.Register;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class args0) {
		
		return Register.class.equals(args0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Register register=(Register)target;
		
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "THIS FIELD CANNOT BE EMPTY");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.empty", "THIS FIELD CANNOT BE EMPTY");
		ValidationUtils.rejectIfEmpty(errors, "confirm_password", "confirm_password.empty", "THIS FIELD CANNOT BE EMPTY");
		ValidationUtils.rejectIfEmpty(errors, "email", "email.empty", "THIS FIELD CANNOT BE EMPTY");
		
	
		if(!register.getPassword().equals(register.getConfirm_password()))
		{
			errors.rejectValue("password", null, "Passwords are not matching!");
			return;
		}

	}
	public void validate1(Object target,Errors errors)
	{
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "Cant be empty!");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.empty", "Cant be empty!");
	}
	public void validate2(Object target,Errors errors)
	{
		
		errors.rejectValue("password", null, "Invalid Username and Password!");
		//errors.rejectValue("keyword", null, "Product not found!");
	}
	public void validate3(Object target,Errors errors)
	{
			errors.rejectValue("pname", null, "Product not found!");
		
		
	}
	

}
