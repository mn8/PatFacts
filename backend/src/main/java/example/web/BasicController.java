package example.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BasicController {
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return "The server is running!";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String testAuthenticated() {
        return "this endpoint is secured";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String test() {
        return "this endpoint is for admins only!";
    }

}
