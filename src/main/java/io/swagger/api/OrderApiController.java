package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.dao.CustomerDAO;
import io.swagger.dao.OrderDAO;
import io.swagger.model.Customer;
import io.swagger.model.Orders;
import io.swagger.model.OrderStatus;

import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Date;

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
public class OrderApiController implements OrderApi {

    private static final Logger log = LoggerFactory.getLogger(OrderApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    
    @Autowired
    private OrderDAO orderDAO;
    
    @Autowired
    private CustomerDAO customerDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public OrderApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Orders> createOrder(@ApiParam(value = "Order object that needs to be created" ,required=true )  @Valid @RequestBody Orders body) {
    	Customer customer = customerDAO.findOne(body.getCustomer().getId());
    	Orders order = null;
    	if(customer != null) {
    		body.setCustomer(customer);
    		body.setOrderDate(Date.from(Instant.now()));
    		body.setStatus(body.getStatus());
        	order = orderDAO.save(body);
        	return new ResponseEntity<Orders>(order, HttpStatus.CREATED);
    	}
    	return new ResponseEntity<Orders>(order, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Long> deleteOrder(@ApiParam(value = "Order ID that needs to be deleted",required=true) @PathVariable("orderId") Long orderId) {
    	if(orderDAO.exists(orderId)) {
    		orderDAO.delete(orderId);
        	return new ResponseEntity<Long>(orderId, HttpStatus.OK);
    	}
    	
    	return new ResponseEntity<Long>(orderId, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Orders> getOrder(@ApiParam(value = "OrderIdID to return",required=true) @PathVariable("orderId") Long orderId) {
    	Orders order;
    	order = orderDAO.findOne(orderId);
    	if(order != null) {
    		return new ResponseEntity<Orders>(order, HttpStatus.FOUND);
    	}
    	
    	return new ResponseEntity<Orders>(order, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Orders> updateOrder(@ApiParam(value = "Order object that needs to be updated" ,required=true )  @Valid @RequestBody Orders body) {
    	log.error("update order: ", body.getId());
    	Orders order;
    	order = orderDAO.findOne(body.getId());
    	if(order != null) {
    		if(body.getStatus() != null) {
    			order.setStatus(body.getStatus());
    		}
    		orderDAO.save(order);
        	return new ResponseEntity<Orders>(order, HttpStatus.OK);
    	}
    	
    	return new ResponseEntity<Orders>(body, HttpStatus.NOT_FOUND);
    }

}
