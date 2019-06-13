package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Article;
import io.swagger.model.Orders;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderLine
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-22T10:30:43.681Z")

@Entity
@Table(name="order_line")
public class OrderLine   {
	
  @Id
  @GeneratedValue(generator="orderLineSequence")
  @SequenceGenerator(name="orderLineSequence",sequenceName="order_line_sequence", allocationSize=1)	
  @Column(name="order_line_id")
  @JsonProperty("id")
  private Long id = null;

  @JoinColumn(name = "orders_id")
  @OneToOne
  @JsonProperty("order")
  private Orders order = null;

  @JoinColumn(name = "article_id")
  @OneToOne
  @JsonProperty("article")
  private Article article = null;

  @Column(name="quantity")
  @JsonProperty("quantity")
  private Long quantity = null;

  public OrderLine id(Long id) {
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

  public OrderLine order(Orders order) {
    this.order = order;
    return this;
  }

  /**
   * Get order
   * @return order
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Orders getOrder() {
    return order;
  }

  public void setOrder(Orders order) {
    this.order = order;
  }

  public OrderLine article(Article article) {
    this.article = article;
    return this;
  }

  /**
   * Get article
   * @return article
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }

  public OrderLine quantity(Long quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  **/
  @ApiModelProperty(value = "")


  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderLine orderLine = (OrderLine) o;
    return Objects.equals(this.id, orderLine.id) &&
        Objects.equals(this.order, orderLine.order) &&
        Objects.equals(this.article, orderLine.article) &&
        Objects.equals(this.quantity, orderLine.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, order, article, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderLine {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    article: ").append(toIndentedString(article)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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

