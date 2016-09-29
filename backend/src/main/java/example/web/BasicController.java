package example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BasicController {
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return "The server is running!  View the Swagger page <a href=\"swagger-ui.html\">here</a>.";
    }

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public Iterable<DiscussionEntity> test() {
//    	return repository.findAll();
////    	return null;
//    }
//
//    @RequestMapping(value = "/test", method = RequestMethod.POST)
//    public DiscussionEntity testInsert() {
//    	return repository.save(new DiscussionEntity("desc", "title"));
//    }
//    
}
