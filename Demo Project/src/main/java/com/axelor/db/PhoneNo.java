package com.axelor.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PhoneNo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int pId;

  private long phoneNo;

  @ManyToOne private Contact contact;

  public int getpId() {
    return pId;
  }

  public void setpId(int pId) {
    this.pId = pId;
  }

  public long getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(long phoneNo) {
    this.phoneNo = phoneNo;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  //  @Override
  //  public String toString() {
  //    return "PhoneNo [pId=" + pId + ", phoneNo=" + phoneNo + ", contact=" + contact + "]";
  //  }
}
