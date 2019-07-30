package com.ihub.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.ihub.model.Item;
import com.ihub.model.Login;
import com.ihub.model.Product;
import com.ihub.model.ProductModel;
import com.ihub.model.Register;
import com.ihub.repository.LoginRepo;
import com.ihub.repository.ProductRepo;
import com.ihub.repository.RegisterRepo;

import com.ihub.validator.ProductValidator;

@Controller
public class MegamartController {
	@Autowired
	RegisterRepo rg;
	@Autowired
	LoginRepo lg;
	@Autowired
	ProductRepo pr;

	@GetMapping("/")
	public String home(@ModelAttribute("test") Register reg) {
		return "shop";
	}

	@PostMapping("/register")
	public String registerPage(@ModelAttribute("test") Register reg) {
		return "register";
	}

	@PostMapping("/login")
	public String loginPage(@ModelAttribute("login") Login login,HttpSession session) {
		return "login";
	}

	@RequestMapping(value = "/Register", method = RequestMethod.POST)

	public String register(@Valid @ModelAttribute("login") Register reg, BindingResult result) {
		new ProductValidator().validate(reg, result);
		if (result.hasErrors()) {
			return "register";
		}

		System.out.println(reg.getName() + reg.getPassword() + reg.getConfirm_password() + reg.getEmail());
		rg.save(reg);
		return "login";

	}

	@PostMapping("/Login")
	public String login(@Valid @ModelAttribute("login") Login login, BindingResult result, ModelAndView model,HttpSession session) {
		new ProductValidator().validate1(login, result);
		System.out.println(login.getName() + login.getPassword());
		Optional<Login> username = lg.findById(login.getName());
		Optional<Login> password = (Optional<Login>) lg.findByPassword(login.getPassword());
		System.out.println(username.toString());
		System.out.println(password.toString());
		if (result.hasErrors()) {
			return "login";
		}

		else if (!username.isPresent() || !password.isPresent() || !username.equals(password)) {

			new ProductValidator().validate2(login, result);
			return "login";

		}

		else {

			session.setAttribute("username", username.get());
			return "cart";
		}

	}

	@PostMapping("/shop")
	public String shopping(@ModelAttribute("product") Product prod,ModelMap model) {

		List<Product> products = (List<Product>) pr.findAll();


		model.addAttribute("Products", products);
		for (int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i).toString());
		
		}
		return "product";
	}
	@GetMapping("/search")
	public String searchProduct(@ModelAttribute("search") Product product,ModelMap model,@Valid BindingResult result,@RequestParam String pname)
	{
		List<Product> prod=pr.findProductByPname(pname);
		if(prod.isEmpty())
		{
			new ProductValidator().validate3(product, result);
			return "product";
		}
		model.addAttribute("ProductSearch", prod);
		return "productDetail";
	}
	}
