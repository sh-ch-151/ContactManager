package com.springboot.web.controller;

import com.springboot.dao.UserRepository;
import com.springboot.entities.User;
import com.springboot.helper.Message;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/do_register")
	public String register(@ModelAttribute("user")User user, @RequestParam(value="agreement", defaultValue = "false") boolean agreement, Model model, HttpSession session)
	{
		try
		{
			if(!agreement)
			{
				System.out.println("You have not agreed termm and conditions");
				throw new Exception("You have not agreed termm and conditions");
			}
			user.setRole("Admin");
			user.setEnabled(true);
			user.setImgUrl("default.png");
			System.out.println("agreement = " +agreement);
			System.out.println("User=" +user);
			User userStr = userRepo.save(user);
//			model.addAttribute("user", userStr);
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully register" , "alert-success"));
			return "signup";
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something Went wrong" +e.getMessage(), "alert-danger"));
			return "signup";
		}
	}
}
