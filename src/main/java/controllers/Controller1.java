package controllers;
import javax.validation.ValidationException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DAO.Model1DAO;
import constants.RETURN;
import exceptions.NotFoundException;
import models.Model1;
import models.Response;

@RestController
public class Controller1 {

    @RequestMapping("/create")
    public Response create(@RequestParam(value="content", required=true) String content) {
    	try{        	
        	//pass to the first layer TODO:Use Interfaces? Clear the confusion
    		Model1 m1 =new Model1DAO().create(content);
        	
        	//conversion for out-object; return
    		if(m1 == null) {
    			throw new ValidationException();
    		} else {
            	return new Response(RETURN.SUCCESS, m1);
    		}
    	}
    	catch(ValidationException ve) {
    		return new Response(RETURN.ERROR_VALIDATION);
    	}
    	catch(Exception e){
    		return new Response(RETURN.ERROR);
    	}
    }

    @RequestMapping("/read")
    public Response read(@RequestParam(value="id", required=true) Integer id) {
    	try{   		
    		//conversion from in-object
        	//not needed here
    		
        	//pass to the first layer TODO:Use Interfaces? Clear the confusion
    		Model1 m1 =new Model1DAO().read(id);
        	
        	//conversion for out-object; return
    		if(m1 == null) {
    			throw new NotFoundException();
    		} else {
            	return new Response(RETURN.SUCCESS, m1);
    		}
    	}
    	catch(NotFoundException nfe) {
    		return new Response(RETURN.ERROR_VALIDATION);
    	}
    	catch(Exception e){
    		return new Response(RETURN.ERROR);
    	}
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public Response update(@RequestBody Model1 m1) { //TODO:<ResponseEntity<>)
    	try{
    		//validation TODO:use annotations
        	if (!m1.isValid()) {
        		throw new ValidationException();
        	}

    		//conversion from in-object
        	//not needed here
    		
        	//pass to the first layer TODO:Use Interfaces? Clear the confusion
    		m1 =new Model1DAO().update(m1);
        	
        	//conversion for out-object; return
    		if(m1 == null) {
    			throw new NotFoundException();
    		} else {
            	return new Response(RETURN.SUCCESS, m1);
    		}
    	}
    	catch(ValidationException ve) {
    		return new Response(RETURN.ERROR_VALIDATION);
    	}
    	catch(NotFoundException nfe) {
    		return new Response(RETURN.ERROR_VALIDATION);
    	}
    	catch(Exception e){
    		return new Response(RETURN.ERROR);
    	}
    }

    @RequestMapping("/delete")
    public Response delete(@RequestParam(value="id") Integer id) {
    	try{
    		//conversion from in-object
        	//not needed here
    		
        	//pass to the first layer TODO:Use Interfaces? Clear the confusion
    		 Boolean del_result = new Model1DAO().delete(id);
        	
        	//conversion for out-object; return
    		if(del_result == null) {
    			throw new NotFoundException();
    		} else if (del_result == true){
            	return new Response(RETURN.SUCCESS, null);
    		} else {
    			return new Response(RETURN.ERROR, null);
    		}
    	}
    	catch(ValidationException ve) {
    		return new Response(RETURN.ERROR_VALIDATION);
    	}
    	catch(NotFoundException nfe) {
    		return new Response(RETURN.ERROR_VALIDATION);
    	}
    	catch(Exception e){
    		return new Response(RETURN.ERROR);
    	}
    }
    
}