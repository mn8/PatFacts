package example.service;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public void createFact(Fact fact){

		Fact factToSave = new Fact(fact.getTitle(), fact.getBody(), fact.getDate());
		int fk = factRepository.save(factToSave).getId();
		fact.getSources().forEach(source->source.setFact_fk(fk));
		sourcesRepository.save(fact.getSources());
		/*return factRepository.save(fact);*/
	}
	public Fact readFact(int id){
		return factRepository.findOne(id);
	}
	public Iterable<Fact> readFacts(){
		return factRepository.findAll();
	}
	public Fact updateFact(int id, Fact fact){
		Fact toEdit = factRepository.findOne(id);
		toEdit.setBody(fact.getBody());
		toEdit.setDate(fact.getDate());
		toEdit.setSources(fact.getSources());
		toEdit.setTitle(fact.getTitle());
		return factRepository.save(toEdit);
	}
	public void deleteFact(int id){
		factRepository.delete(id);
	}


}
