package com.truper.prueba.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "order")
public class OrderDO implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Long id;

  @Temporal(TemporalType.DATE)
  private LocalDate date;

  @Column
  private BigDecimal total = new BigDecimal(0.0);

  @OneToOne
  @JoinColumn(name = "store_id", referencedColumnName = "store_id")
  private StoreDO store;

  @OneToMany(mappedBy = "order")
  private List<ProductDO> productList;

  public OrderDO(Long id, LocalDate date, BigDecimal total, StoreDO store, List<ProductDO> productList) {
    this.id = id;
    this.date = date;
    this.total = total;
    this.store = store;
    this.productList = productList;
  }
  public OrderDO(LocalDate date, StoreDO store, List<ProductDO> productList) {
    this.date = date;
    this.store = store;
    this.productList = productList;
  }

  public OrderDO() {}

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

  public StoreDO getStore() {
    return store;
  }

  public void setStore(StoreDO store) {
    this.store = store;
  }

  public List<ProductDO> getProductList() {
    return productList;
  }

  public void setProductList(List<ProductDO> productList) {
    this.productList = productList;
  }
}
