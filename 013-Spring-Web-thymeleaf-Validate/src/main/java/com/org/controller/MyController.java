package com.org.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.entity.Product;
import com.org.repository.ProductRepo;

@Controller
public class MyController {

	@Autowired
	private ProductRepo repo;

	@GetMapping("/delete")
	public String delete(@RequestParam("pid") Integer pid ,Model model) {
		if(repo.findById(pid) != null)
		          repo.deleteById(pid);
		model.addAttribute("msg","product deleted");
		model.addAttribute("products", repo.findAll());
		return "view";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("pid") Integer id ,Model model) {
		Optional<Product> findById = repo.findById(id);
		if(findById.isPresent()) {
			Product product = findById.get();
			model.addAttribute("prod", product);
		}
		
		return "index";
	}
	
	@GetMapping("/view")
	public String viewProduct(Model model) {
		List<Product> list = repo.findAll();
		model.addAttribute("products", list);
		return "view";
	}
	
	@PostMapping("/save")
	public String save(@Validated @ModelAttribute("prod") Product p ,BindingResult result, Model model) {
		if(result.hasErrors())
			     return "index";
		
		p = repo.save(p);
		if(p.getPid() != null)
			model.addAttribute("msg","Product Save..!");
		init(model);
		return "index";
	}
	
	@GetMapping("/")
	public String form(Model model) {
		init(model);
		return "index";
	}

	private void init(Model model) {
		model.addAttribute("prod", new Product());
	}
}
