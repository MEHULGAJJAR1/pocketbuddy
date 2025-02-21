package com.pocketbuddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pocketbuddy.entity.MemberEntity;
import com.pocketbuddy.repository.MemberRepository;

@Controller

public class MemberController {
	
	@Autowired
	MemberRepository repositoryMember;
	
   @GetMapping("newmember")
   public String newmember() {
	   return "NewMember";
   }
   
   @PostMapping("savemember")
   public String savemember(MemberEntity entityMember) {
	   repositoryMember.save(entityMember);
	   return "NewMember";
   }
    
	@GetMapping("listmember")
	public String listmember(Model model) {
		List<MemberEntity> memberList = repositoryMember.findAll();
		model.addAttribute("memberlist", memberList);
		return "ListMember";
	}

}
