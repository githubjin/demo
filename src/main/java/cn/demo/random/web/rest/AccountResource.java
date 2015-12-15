package cn.demo.random.web.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/api")
public class AccountResource {

	 /**
     * POST  /register -> register the user.
     */
    @RequestMapping(value = "/activate")
    @Timed
    public String registerAccount() {
    	return "123";
    }
	
}
