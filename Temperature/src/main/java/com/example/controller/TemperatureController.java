package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.FormObject;
import com.example.service.TemperatureService;


@Controller
public class TemperatureController {

	@Autowired
	TemperatureService temperatureService;
	
	@RequestMapping(value={"/","home"},method=RequestMethod.GET)
	public String getZipCode(){
		//System.out.println("hello");
		return "inputForm";
	}
	
	@RequestMapping(value="/loadTemperature",method=RequestMethod.GET)
	public @ResponseBody FormObject loadTemperature(@RequestParam String zip){
		
		FormObject result=temperatureService.getTemperatureforWeek(zip);
		return result;
	}
}
