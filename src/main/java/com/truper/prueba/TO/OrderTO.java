package com.truper.prueba.TO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderTO implements Serializable {

  private Long id;

  private LocalDate date;

  private BigDecimal total;

  private Long storeId;

  private List<ProductTO> products;

  public OrderTO() {}
  public OrderTO(Long id, LocalDate date, BigDecimal total, List<ProductTO> products) {
    this.id = id;
    this.date = date;
    this.total = total;
    this.products = products;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public List<ProductTO> getProducts() {
    return products;
  }

  public void setProducts(List<ProductTO> products) {
    this.products = products;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }
}
