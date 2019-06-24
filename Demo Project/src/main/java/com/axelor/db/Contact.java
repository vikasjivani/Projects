package com.axelor.db;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int cId;

  private String name;
  @OneToMany(cascade = CascadeType.ALL, mappedBy ="contact",orphanRemoval = true)
  List<PhoneNo> list;

  public int getcId() {
    return cId;
  }

  public void setcId(int cId) {
    this.cId = cId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<PhoneNo> getList() {
    return list;
  }

  public void setList(List<PhoneNo> list) {
    this.list = list;
  }

//  @Override
//  public String toString() {
//    return "Contact [cId=" + cId + ", name=" + name + ", list="+"]";
//  }
}