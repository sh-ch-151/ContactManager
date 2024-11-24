package com.springboot.web.controller;

import com.springboot.dao.UserRepository;
import com.springboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SmartContact
{
	@Autowired
	private UserRepository userRepo;

//	@GetMapping("/test")
//	@ResponseBody
//	public String getTest()
//	{
//		User user = new User();
//		user.setName("hoi");
//		user.setEmail("hoi");
//		user.setPassword("hoi");
//		user.setRole("hoi");
//		user.setEnabled(true);
//		user.setImgUrl("hoi");
//		user.setAbout("hoi");
//		userRepo.save(user);
//		return "working";
//	}

	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title", "Home - Smart contact manager");
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model)
	{
		model.addAttribute("title", "About - Smart contact manager");
		return "about";
	}

	@GetMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("title", "SignUp - Smart contact manager");
		return "signup";
	}
}
