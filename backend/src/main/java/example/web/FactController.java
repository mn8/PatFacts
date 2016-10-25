package example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import example.data.entity.Fact;
import example.data.entity.Source;
import example.data.repository.FactRepository;
import example.model.FactModel;
import example.model.SourceModel;
import example.service.FactService;
import example.service.SourceService;

@RestController
@RequestMapping("facts")
@CrossOrigin
public class FactController {
	@Autowired
	FactRepository factsDAO;
	@Autowired 
	FactService factService;
/*	@Autowired 
	SourceService sourceService;*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Fact getFact(@PathVariable int id, @RequestParam String callback){
		Fact fact = factsDAO.findOne(id);
		return fact;
	}
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Fact> getFacts(){
		return factsDAO.findAll();

	}
	@RequestMapping(method = RequestMethod.POST)
	public Fact createFact(@RequestBody Fact fact){
		System.out.println("Fact To Save"+fact.toString());
		factService.createFact(fact);
		return fact;
	}
}
