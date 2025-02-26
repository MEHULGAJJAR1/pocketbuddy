package com.pocketbuddy.controller;

import java.util.List;
import java.util.Optional;

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
	
	@GetMapping("viewmembers")
	public String viewMembers(Integer memberId,Model model) {
		System.out.println("id ===>"+memberId);
		Optional<MemberEntity> op =repositoryMember.findById(memberId);
		if(op.isEmpty()) {
			
		}else {
			MemberEntity member =op.get();
			model.addAttribute("member", member);
		}
		return "ViewMembers";
	}
	
	@GetMapping("deletemembers")
	public String deleteMembers(Integer memberId) {
		repositoryMember.deleteById(memberId);//delete from members where memberID = :memberId
		return "redirect:/listmember";
	}
}
