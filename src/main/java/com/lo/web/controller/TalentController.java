package com.lo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lo.web.domain.TalentRequest;
import com.lo.web.es.builder.GeoLocationBuilder;

@RestController
@RequestMapping("/talent")
public class TalentController {
	
	@Autowired
	GeoLocationBuilder geoLocationBuilder;

	@PostMapping
//	@ResponseBody
	public String addTalent(@RequestBody TalentRequest talentRequest) {
		
		System.out.println(talentRequest.toString());
		
		geoLocationBuilder.findNearByLocations();
		
		return "SUCCESS";
	}
	
	@GetMapping
//	@ResponseBody
	public String getTalent() {
		
		return "SUCCESS";
	}
}
