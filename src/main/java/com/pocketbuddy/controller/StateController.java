package com.pocketbuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pocketbuddy.entity.StateEntity;
import com.pocketbuddy.repository.StateRepository;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class StateController {
	
	@Autowired
	
	StateRepository repoState;

	@GetMapping("newstate")
	public String newState() {
		return "NewState";
	}
	@PostMapping("savestate")
	public String saveState(StateEntity state) {
		System.out.print(state.getStateName());
		repoState.save(state);
		return "NewState";
		
	}
}
