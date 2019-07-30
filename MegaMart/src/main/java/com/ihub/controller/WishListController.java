package com.ihub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ihub.repository.WishListRepo;

@Controller
public class WishListController {
	@Autowired WishListRepo wishlistrepository;
	@GetMapping("/addtoWishList/{pid}")
	public String addToWishList(@PathVariable("pid") String pid)
	{
		wishlistrepository.save(pid);
		return "wishList";
	}

}
