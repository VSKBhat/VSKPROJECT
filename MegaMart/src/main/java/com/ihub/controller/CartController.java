package com.ihub.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ihub.model.Item;
import com.ihub.model.Login;
import com.ihub.model.Order;
import com.ihub.model.Product;
import com.ihub.model.ProductModel;
import com.ihub.model.Register;
import com.ihub.repository.OrderRepo;
import com.ihub.repository.ProductRepo;

@Controller
public class CartController {

	@Autowired
	ProductRepo productRepository;
	@Autowired
	OrderRepo orderRepository;

	@PostMapping(value = "/Addtocart/{pid}")
	public String addToCart(@PathVariable("pid") String pid, Model model, HttpSession session) {

		Optional<Product> product = productRepository.findById(pid);
		System.out.println(product);
		if (session.getAttribute("cart") == null && product.isPresent()) {
			System.out.println("+++++++++++++++inside if");
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(product.get(), 1));
			System.out.println("=============" + cart.toString());
			session.setAttribute("cart", cart);

			System.out.println("after session.setAttribute");
		} else {
			System.out.println("inside else");
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = this.exists(pid, cart);
			if (index == -1) {
				cart.add(new Item(product.get(), 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);

		}
		System.out.println("after else block");
		return "cart";

	}

	private int exists(String pid, List<Item> cart) {

		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getPid().equals(pid)) {
				return i;
			}
		}
		return -1;
	}
	public double total(HttpSession session)
	{
		double s=0;
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for(Item item:cart) {
			s=s+item.getQuantity()*item.getProduct().getPrice();
		}
		return s;
	}

	@RequestMapping(value = "/cart/remove/{pid}", method = RequestMethod.GET)
	public String remove(@PathVariable("pid") String pid, HttpSession session) {
		// ProductModel productModel = new ProductModel();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = this.exists(pid, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "cart";
	}

	@RequestMapping(value = "/cart/update", method = RequestMethod.POST)
	public String update(HttpSession session, HttpServletRequest request) {
		String[] quantities = request.getParameterValues("quantity");
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for (int i = 0; i < cart.size(); i++) {
			cart.get(i).setQuantity(Integer.parseInt(quantities[i]));
		}
		session.setAttribute("cart", cart);
		return "cart";
	}
	@RequestMapping(value="/cart/checkout",method=RequestMethod.POST)
	public String checkout(HttpSession session,@ModelAttribute("login")Login login,Product product) {
		if(session.getAttribute("username")==null) {
			return "login";
			
		}else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			List<Order> orderList= new ArrayList<Order>();
			Order order =new Order();
			for(Item item:cart)
			{
				
				order.setDisplay_name(item.getProduct().getPname());
				System.out.println((item.getProduct().getPname()));
				
				order.setPrice(item.getProduct().getPrice());
				System.out.println(item.getProduct().getPrice());
				
				order.setQuantity(item.getQuantity());
				System.out.println(item.getQuantity());

				order.setSname(item.getProduct().getSeller_name());
				System.out.println(item.getProduct().getSeller_name());

				order.setTotal_price(total(session));
				System.out.println(total(session));

				order.setOrder_date(new Date());
				System.out.println(new Date());

				order.setOrder_status("Order Placed");
				System.out.println("Order Placed");
				//orderList.add(order);
				//System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++="+orderList);

				orderRepository.save(order);
				System.out.println("After save");
			}
			//orderRepository.saveAll(orderList);
			
			
			
			return "thanks";
		}
		
	}
}