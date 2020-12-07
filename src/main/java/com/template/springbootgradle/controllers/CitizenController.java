package com.template.springbootgradle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.template.springbootgradle.models.Citizen;
import com.template.springbootgradle.services.CitizenService;

@RestController
public class CitizenController {
	
	@Autowired
	private CitizenService citizenSvc ;
	
	@RequestMapping(method = RequestMethod.GET, value ="/citizens")
	public List<Citizen> getAllCitizens(){
		return citizenSvc.getAllCitizens();
		
	}
	

	
	@RequestMapping(method = RequestMethod.POST, value = "/citizen/set")
	public void setCitizen(@RequestBody Citizen citizen){
		citizenSvc.addCitizen(citizen);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/citizen/update")
	public void updateCitizen(@RequestBody Citizen citizen){
		citizenSvc.updateCitizen(citizen);
	}

	@RequestMapping(method =  RequestMethod.DELETE, value = "/citizen/delete")
	public void deleteCitizen(@RequestBody Citizen citizen){
		citizenSvc.deleteCitizen(citizen);
	}
	
	
	

}
