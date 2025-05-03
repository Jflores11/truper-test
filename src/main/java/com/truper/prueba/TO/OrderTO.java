package com.truper.prueba.TO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderTO implements Serializable {

  private Long id;

  private LocalDate date;

  private BigDecimal total;

  private Long storeId;

  private StoreTO store;

  private List<ProductTO> products;

  public OrderTO() {}
  public OrderTO(Long id, LocalDate date, BigDecimal total, List<ProductTO> products) {
    this.id = id;
    this.date = date;
    this.total = total;
    this.products = products;
  }

  public OrderTO(Long id, LocalDate date, BigDecimal total, List<ProductTO> products, StoreTO store) {
    this.id = id;
    this.date = date;
    this.total = total;
    this.products = products;
    this.store = store;
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

  public StoreTO getStore() {
    return store;
  }

  public void setStore(StoreTO store) {
    this.store = store;
  }

}
