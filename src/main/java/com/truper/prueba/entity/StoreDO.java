package com.truper.prueba.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "store")
public class StoreDO implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "store_id")
  private Long id;

  private String name;

  public StoreDO() {
  }

  public StoreDO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
