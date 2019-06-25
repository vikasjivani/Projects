package com.axelor.service;

import javax.persistence.EntityManager;
import com.axelor.db.Contact;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class ContactServiceImp implements ContacService {

  Contact contact = new Contact();
  @Inject EntityManager em;


  @Override
  @Transactional
  public void insert(String name) {

    contact.setName(name);
      em.persist(contact);

  }
}
