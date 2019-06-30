package developer.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * MiddleController
 */
@Controller
public class MiddleController {

    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String requestMethodName( String param) {
        return "index";
    }

    @GetMapping("/index")
    public String home(){
        return "home";
    }
    
}