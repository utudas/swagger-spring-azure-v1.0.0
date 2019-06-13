package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.dao.ArticleDAO;
import io.swagger.dao.CustomerDAO;
import io.swagger.dao.OrderDAO;
import io.swagger.dao.OrderLineDAO;
import io.swagger.model.Article;
import io.swagger.model.Customer;
import io.swagger.model.Orders;
import io.swagger.model.OrderLine;

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
public class OrderLineApiController implements OrderLineApi {

    private static final Logger log = LoggerFactory.getLogger(OrderLineApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    
    @Autowired
    private OrderDAO orderDAO;
    
    @Autowired
    private ArticleDAO articleDAO;
    
    @Autowired
    private OrderLineDAO orderLineDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public OrderLineApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }


	@Override
	public ResponseEntity<OrderLine> createOrderLine(@ApiParam(value = "Order object that needs to be created" ,required=true )  @Valid @RequestBody OrderLine body) {
		Article article = articleDAO.findOne(body.getArticle().getId());
		Orders order = orderDAO.findOne(body.getOrder().getId());
		OrderLine orderLine = null;
		
    	if(article != null && order != null) {
    		body.setArticle(article);
    		body.setOrder(order);
    		orderLine = orderLineDAO.save(body);
        	return new ResponseEntity<OrderLine>(orderLine, HttpStatus.CREATED);
    	}
    	
		return new ResponseEntity<OrderLine>(orderLine, HttpStatus.NOT_FOUND);
	}


	@Override
	public ResponseEntity<OrderLine> getOrderLine(@ApiParam(value = "OrderLine Oject that needs to be returned",required=true) @PathVariable("orderLineId") Long orderLineId) {
		OrderLine orderLine;
		orderLine = orderLineDAO.findOne(orderLineId);
    	if(orderLine != null) {
    		return new ResponseEntity<OrderLine>(orderLine, HttpStatus.FOUND);
    	}
    	
    	return new ResponseEntity<OrderLine>(orderLine, HttpStatus.NOT_FOUND);
	}


	@Override
	public ResponseEntity<OrderLine> updateOrderLine(@ApiParam(value = "OrderLine object that needs to be updated" ,required=true )  @Valid @RequestBody OrderLine body) {
		OrderLine orderLine;
		orderLine = orderLineDAO.findOne(body.getId());
    	if(orderLine != null) {
    		if(body.getQuantity() != orderLine.getQuantity()) {
    			orderLine.setQuantity(body.getQuantity());
    		}
    		orderLineDAO.save(orderLine);
        	return new ResponseEntity<OrderLine>(orderLine, HttpStatus.OK);
    	}
    	
    	return new ResponseEntity<OrderLine>(body, HttpStatus.NOT_FOUND);
	}


	@Override
	public ResponseEntity<Long> deleteOrderLine(@ApiParam(value = "OrderLine ID that needs to be deleted",required=true) @PathVariable("orderLineId") Long orderLineId) {
		if(orderLineDAO.exists(orderLineId)) {
			orderLineDAO.delete(orderLineId);
        	return new ResponseEntity<Long>(orderLineId, HttpStatus.OK);
    	}
    	
    	return new ResponseEntity<Long>(orderLineId, HttpStatus.NOT_FOUND);
	}

}
