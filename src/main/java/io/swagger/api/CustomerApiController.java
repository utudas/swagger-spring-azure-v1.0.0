package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.dao.CustomerDAO;
import io.swagger.model.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-22T10:30:43.681Z")

@Controller
public class CustomerApiController implements CustomerApi {

    private static final Logger log = LoggerFactory.getLogger(CustomerApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    
    @Autowired
    private CustomerDAO customerDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public CustomerApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Customer> createCustomer(@ApiParam(value = "Customer object that needs to be created" ,required=true )  @Valid @RequestBody Customer body) {
    	Customer customer;
    	customer = customerDAO.save(body);
    	return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
    }

    public ResponseEntity<Long> deleteCustomer(@ApiParam(value = "Customer ID that needs to be deleted",required=true) @PathVariable("customerId") Long customerId) {
    	if(customerDAO.exists(customerId)) {
    		customerDAO.delete(customerId);
        	return new ResponseEntity<Long>(customerId, HttpStatus.OK);
    	}
    	
    	return new ResponseEntity<Long>(customerId, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Customer> getCustomer(@ApiParam(value = "CustomerID to return",required=true) @PathVariable("customerId") Long customerId) {
    	Customer customer;
    	customer = customerDAO.findOne(customerId);
    	if(customer != null) {
    		return new ResponseEntity<Customer>(customer, HttpStatus.FOUND);
    	}
    	
    	return new ResponseEntity<Customer>(customer, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Customer> updateCustomer(@ApiParam(value = "Customer object that needs to be updated" ,required=true )  @Valid @RequestBody Customer body) {
    	if(customerDAO.exists(body.getId())) {
    		customerDAO.save(body);
        	return new ResponseEntity<Customer>(body, HttpStatus.OK);
    	}
    	
    	return new ResponseEntity<Customer>(body, HttpStatus.NOT_FOUND);
    }

}
