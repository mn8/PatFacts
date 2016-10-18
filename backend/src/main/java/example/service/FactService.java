package example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.data.entity.Fact;
import example.data.entity.Source;
import example.data.repository.FactRepository;
import example.data.repository.SourcesRepository;
import example.model.FactModel;

@Service
public class FactService {

	@Autowired
	FactRepository factRepository;
	@Autowired SourcesRepository sourcesRepository;
	
	public void createFact(Fact factModel){

		Fact factToSave = new Fact(factModel.getTitle(), factModel.getBody(), factModel.getDate());
		int fk = factRepository.save(factToSave).getId();
		factModel.getSources().forEach(source->source.setFact_fk(fk));
		sourcesRepository.save(factModel.getSources());
		/*return factRepository.save(fact);*/
	}
	public void readFact(){
		
	}
	public void updateFact(){
		
	}
	public void deleteFact(int id){
		
	}

	
	
}
