package com.template.springbootgradle.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.template.springbootgradle.models.Citizen;

@Service
public class CitizenService {
	

	private List<Citizen> CitizenList = new ArrayList<>(Arrays.asList(
            new Citizen(1,"John Doe"),
            new Citizen(2,"Michael Jackson"),
            new Citizen(3,"Mannie Queen")
	));
	
	@SuppressWarnings("unchecked")
	public Hashtable<Integer, String> citizenHash = new Hashtable();
	
	
	public List<Citizen> getAllCitizens(){
		return CitizenList;
	}
	
	

	

	public void addCitizen(Citizen citizen){
		CitizenList.add(citizen);
	}
	
	public void deleteCitizen(Citizen citizen) {
		// Getting ID of the citizen -> get the index -> remove that index from the list
		Iterator<Citizen> iter = CitizenList.iterator(); 
		while (iter.hasNext()) {
			Citizen ctz = iter.next();
			if (ctz.getId().equals(citizen.getId())){
				iter.remove();
			}
			
		}

	}
	
	public void updateCitizen(Citizen citizen) {
		for(Citizen ct : CitizenList) {
			if(ct.getId().equals(citizen.getId())) {
				CitizenList.set(citizen.getId()-1,citizen);
			}
		}
	}
	
	



}
