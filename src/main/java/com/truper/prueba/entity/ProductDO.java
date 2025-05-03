package com.truper.prueba.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class ProductDO implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long id;

  private String code;

  private String description;

  private BigDecimal price;

  @OneToOne
  @JoinColumn(name = "order_id", referencedColumnName = "order_id")
  private OrderDO order;

  public ProductDO() {}

  public ProductDO(Long id, String code, String description, BigDecimal price, OrderDO order) {
    this.id = id;
    this.code = code;
    this.description = description;
    this.price = price;
    this.order = order;
  }

  public ProductDO(String code, String description, BigDecimal price, OrderDO order) {
    this.code = code;
    this.description = description;
    this.price = price;
    this.order = order;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public OrderDO getOrder() {
    return order;
  }

  public void setOrder(OrderDO order) {
    this.order = order;
  }
}
