package io.swagger.model;

//import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Customer;







//import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Order
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-22T10:30:43.681Z")

@Entity
@Table(name="orders")
public class Orders {
	
  @Id
  @GeneratedValue(generator="ordersSequence")
  @SequenceGenerator(name="ordersSequence",sequenceName="orders_sequence", allocationSize=1)	
  @Column(name="orders_id")
  @JsonProperty("id")
  private Long id = null;

  @JoinColumn(name = "customer_id")
  @OneToOne
  @JsonProperty("customer")
  private Customer customer = null;

  /**
   * Gets or Sets status
   */
  /*public enum StatusEnum {
    IN_PROGRESS("1"),
    
    SHIPPED("Shipped"),
    
    COMPLETED("Completed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  } */

  @JsonProperty("status")
  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private OrderStatus status = null;

  @JsonProperty("order_date")
  @Column(name = "order_date")
  @Temporal(TemporalType.TIMESTAMP)
  //private OffsetDateTime orderDate = null;
  private Date order_date = null;

  public Orders id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Orders customer(Customer customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Orders status(OrderStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public Orders orderDate(Date orderDate) {
    this.order_date = orderDate;
    return this;
  }

  /**
   * Get orderDate
   * @return orderDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Date getOrderDate() {
    return order_date;
  }

  public void setOrderDate(Date orderDate) {
    this.order_date = orderDate;
    //this.orderDate = org.threeten.bp.DateTimeUtils.toDate(orderDate.toInstant());
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Orders order = (Orders) o;
    return Objects.equals(this.id, order.id) &&
        Objects.equals(this.customer, order.customer) &&
        Objects.equals(this.status, order.status) &&
        Objects.equals(this.order_date, order.order_date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customer, status, order_date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    orderDate: ").append(toIndentedString(order_date)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

