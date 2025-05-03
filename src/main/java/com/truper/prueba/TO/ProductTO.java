package com.truper.prueba.TO;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductTO implements Serializable {

  private Long id;

  private String code;

  private String description;

  private BigDecimal price;

  private Long orderId;

  public ProductTO() {}
  public ProductTO(Long id, String code, String description, BigDecimal price, Long orderId) {
    this.id = id;
    this.code = code;
    this.description = description;
    this.price = price;
    this.orderId = orderId;
  }
  public ProductTO(Long id, String code, String descrption, BigDecimal price) {
    this.id = id;
    this.code = code;
    this.description = descrption;
    this.price = price;
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

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }
}
