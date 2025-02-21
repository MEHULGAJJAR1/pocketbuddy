package com.pocketbuddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pocketbuddy.entity.MemberEntity;
import com.pocketbuddy.repository.MemberRepository;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class MemberController {
	
	@Autowired
	MemberRepository repositoryMember;
	
	@GetMapping("newmemeber")
	public String newMember() {
		return"NewMember";
	}
	
	@PostMapping("savemember")
	public String saveMember(MemberEntity entityMember) {
		repositoryMember.save(entityMember);
		return "NewMember";
	}
	@GetMapping("listmember")
	public String listMember(Model model) {
		List<MemberEntity> memberList = repositoryMember.findAll();
		
		model.addAttribute("memberList",memberList);
		return"ListMember";
	}
	
	

}
