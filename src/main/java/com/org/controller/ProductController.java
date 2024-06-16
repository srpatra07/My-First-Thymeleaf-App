package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.org.entities.Product;
import com.org.repo.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	ProductRepository repo;
	
	@GetMapping("/")
	public String loadIndexPage(Model model)
	{
		model.addAttribute("product",new Product());
		return "index";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product p, Model model)
	{
		Product pro = repo.save(p);
		
		if(pro!=null)
		{
			model.addAttribute("success","Data saved successfully...");
		}
		
		return "index";
	}
	
	@GetMapping("/view")
	public String viewProducts(Model model)
	{
		List<Product> list = repo.findAll();
		model.addAttribute("products",list);
		return "data";
	}
	
}
