package facts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import facts.dbo.Fact;
import facts.repository.FactsDAO;

@RestController
@RequestMapping("/fact")
public class Controller {
	@Autowired
	FactsDAO factsDAO;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MappingJacksonValue getFact(@PathVariable int id, @RequestParam String callback){
		Fact fact = factsDAO.findOne(id);
		MappingJacksonValue jsonpResponse = new MappingJacksonValue(fact);
		jsonpResponse.setJsonpFunction(callback);
		return jsonpResponse;
	}
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Fact> getFacts(){
		return factsDAO.findAll();

	}
	
}
