package com.ihub.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

	private String name;
	private String password;
	private String confirm_password;
	private String email;
	private String message;
	@Override
	public void initialize(final FieldMatch constraintAnnotation)
	{
		password=constraintAnnotation.first();
		confirm_password = constraintAnnotation.second();
		
		message = constraintAnnotation.message();

	}

	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		boolean valid = true;
		try {
			final Object firstObj = BeanUtils.getProperty(value, password);
            final Object secondObj = BeanUtils.getProperty(value,confirm_password );
           
            valid =  firstObj == null && secondObj == null  || firstObj != null && firstObj.equals(secondObj);
		}
		catch(final Exception e)
		{
			System.out.println(e);
		}
		if (!valid){
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(password)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
	}
}
