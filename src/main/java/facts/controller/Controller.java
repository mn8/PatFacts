package facts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import facts.dbo.Facts;
import facts.repository.FactsDAO;

@RestController
public class Controller {
	@Autowired
	FactsDAO factsDAO;
	
	
	@RequestMapping("/fact/{id}")
	@ResponseBody
	public MappingJacksonValue getFact(@PathVariable int id, @RequestParam String callback){
		Facts fact = factsDAO.findOne(id);
		MappingJacksonValue jsonpResponse = new MappingJacksonValue(fact);
		jsonpResponse.setJsonpFunction(callback);
		return jsonpResponse;
	}
	@RequestMapping("/facts")
	@ResponseBody
	public MappingJacksonValue getFacts(@RequestParam String callback){
		Iterable<Facts> facts = factsDAO.findAll();
		MappingJacksonValue jsonpResponse = new MappingJacksonValue(facts);
		jsonpResponse.setJsonpFunction(callback);
		return jsonpResponse;
	}
	
}
