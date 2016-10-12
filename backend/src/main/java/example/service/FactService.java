package example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.data.entity.Fact;
import example.data.repository.FactRepository;
import example.model.FactModel;

@Service
public class FactService {

	@Autowired
	FactRepository factRepository;
	
	
	public Fact createFact(Fact fact){
		//Add mapper

		return factRepository.save(fact);
	}
	public void readFact(){
		
	}
	public void updateFact(){
		
	}
	public void deleteFact(int id){
		
	}

	
	
}
