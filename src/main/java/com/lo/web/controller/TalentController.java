package com.lo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lo.web.bean.TalentRequest;

@RestController
@RequestMapping("/talent")
public class TalentController {
	

	@PostMapping
//	@ResponseBody
	public String addTalent(@RequestBody TalentRequest talentRequest) {
		
		System.out.println(talentRequest.toString());
		
		return "SUCCESS";
	}
	
	@GetMapping
//	@ResponseBody
	public String getTalent() {
		
		return "SUCCESS";
	}
}
