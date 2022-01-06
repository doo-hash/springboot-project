package com.mockpage.schoolwebapp.parentportal.parent.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mockpage.schoolwebapp.parentportal.parent.model.Parent;
import com.mockpage.schoolwebapp.parentportal.parent.repository.ParentRepository;


@Controller
@RequestMapping(path="/parent")
public class ParentController {

	@Autowired
	ParentRepository parentRepo;
	
	@GetMapping("/add")
	public String parentForm(Model model) {
		model.addAttribute("parent",new Parent());
		return "Parent_form";
	}
	
	@GetMapping("/login")
	public String parentLogin() {
		return "Login";
	}

	
	@GetMapping("/{parentid}")
	public String parentDetails(Model model,@PathVariable Long parentid) {
		
		Optional<Parent> parent = parentRepo.findById(parentid);
		model.addAttribute("parent",parent);
		
		return "paretn_potal";
	}
	
	@PostMapping("/welcome")
	public String parentSubmit(@Valid @ModelAttribute Parent parent,Model model) {
		model.addAttribute("parent",parent);

		parentRepo.save(parent);

		return "welcome";
	}
	
	@PostMapping("/parent_portal")
	public String parentLogin(@Valid @RequestParam String studentId,@Valid @RequestParam String password,Model model) {
		
		if(parentRepo.existsBystudentId(studentId)) {
			Parent parent =	parentRepo.findBystudentId(studentId);
			model.addAttribute(parent);
			return "parent_portal";
		}else {
			return "Login";
		}
	}
	/*
	@PostMapping(path = "/add")
	public @ResponseBody String addNewParent(
			@RequestParam String fn,
			@RequestParam String ln,
			@RequestParam String sn,
			@RequestParam String sid,
			@RequestParam String em,
			@RequestParam String psd
			) {
		
		Parent parent = new Parent();
		parent.setFirstName(fn);
		parent.setLastName(ln);
		parent.setStudentId(sid);
		parent.setStudentName(sn);
		parent.setEmail(em);
		parent.setPassword(psd);
		
		parentRepo.save(parent);
		
		return "saved";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Parent> getAllParents() {
				
		return parentRepo.findAll();
	}*/
}
