package com.pocketbuddy.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pocketbuddy.entity.VehicleEntity;
import com.pocketbuddy.repository.VehicleRepository;

@Controller

public class VehicleController {

	@Autowired
	VehicleRepository repositoryVehicle;
	
	@GetMapping("newvehicle")
	public String newVehicle() {
		return"NewVehicle";
	}
	
	@PostMapping("savevehicle")
	public String saveVehicle(VehicleEntity entityvehicle) {
		repositoryVehicle.save(entityvehicle);	
		return "ListVehicle";
	}
	
	@GetMapping("listvehicle")
	public String listVehicle(Model model) {
		List<VehicleEntity> listvehicle = repositoryVehicle.findAll();
		model.addAttribute("list", listvehicle);
		return "ListVehicle";
	}
	 

}
