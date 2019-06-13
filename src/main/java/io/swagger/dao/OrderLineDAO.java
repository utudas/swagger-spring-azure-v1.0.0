package io.swagger.dao;

import io.swagger.model.OrderLine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineDAO extends JpaRepository<OrderLine, Long>{

}
