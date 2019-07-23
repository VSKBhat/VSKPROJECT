package com.ihub;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
@RequestMapping(value="/login",method=RequestMethod.GET)
public ModelAndView login(ModelMap model)
{
	return new ModelAndView("Login","command",new User());
	
}
@RequestMapping(value="/loginUser",method=RequestMethod.POST)
public ModelAndView loginValid(@Valid @ModelAttribute("command") User user,BindingResult result,ModelMap model) 
{
	System.out.println(user.getUserID()+user.getPassword());
	 //ModelAndView modelAndView = new ModelAndView();
	
	if(result.hasErrors())
	{
		ModelAndView modelAndView= new ModelAndView("Login");
		return modelAndView;
	}
	else
	{
		ModelAndView modelAndView=new ModelAndView("Success");
		return modelAndView;
	}

}
}
