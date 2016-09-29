package example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import example.data.entity.Fact;
import example.data.repository.FactRepository;

@RestController
@RequestMapping("facts")
@CrossOrigin
public class FactController {
	@Autowired
	FactRepository factsDAO;
	
	
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
