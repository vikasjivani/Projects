package com.axelor.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
// import javax.persistence.EntityManagerFactory;
// import javax.persistence.Persistence;
import javax.persistence.Query;

import com.axelor.db.Contact;
import com.axelor.db.PhoneNo;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class ContactServiceImp implements ContacService {

  Contact contact = new Contact();
  //  EntityManagerFactory emf = Persistence.createEntityManagerFactory("contactdemo");

  //  EntityManager em = emf.createEntityManager();
  // Provider<EntityManager> emp;
  @Inject EntityManager em;
  PhoneNo phoneno = new PhoneNo();

  @Override
  @Transactional
  public void insert(String name, long phoneNo) {
    System.out.println("test 1");

    //        em.getTransaction().begin();
    contact.setName(name);
    phoneno.setPhoneNo(phoneNo);

    List<PhoneNo> list = new ArrayList<PhoneNo>();
    list.add(phoneno);

    contact.setList(list);
    phoneno.setContact(contact);

    System.out.println("test 2");

    Contact temp = null;

    Query query = em.createQuery("from Contact");

    @SuppressWarnings("unchecked")
    List<Contact> list1 = query.getResultList();
    System.out.println(list);
//    temp = list1.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        for (Contact c : list1) {
          if (c.getName().equals(name)) {
            temp = c;
          }
        }
//        System.out.println("value of i=" + i);

    if (temp == null) {
      em.persist(contact);

    } else {
      phoneno.setContact(temp);
      em.persist(phoneno);
    }
    System.out.println("test 3");
    //        em.getTransaction().commit();

  }

  @Override
  @Transactional
  public int update(long oldphoneno, long newphonno) {
    //    em.getTransaction().begin();
    //    Query query =
    //        em.createQuery(
    //            "UPDATE PhoneNo pn SET pn.phoneNo= '" + newphonno + "'" + " WHERE = :" +
    // oldphoneno);

    //    Query query =
    //        em.createQuery("UPDATE PhoneNo phno SET phno.phoneNo = '"+newphonno+"' " + "WHERE
    // phno.phoneNo= :'"+oldphoneno+"'");

    Query query =
        em.createQuery("UPDATE PhoneNo pno SET pno.phoneNo = :new" + " WHERE pno.phoneNo = :old");

    query.setParameter("new", newphonno);
    query.setParameter("old", oldphoneno);

    int ok = query.executeUpdate();
    //    em.getTransaction().commit();
    return ok;
  }

  @Override
  @Transactional
  public List<Contact> show() {

    Query query = em.createQuery("from Contact ");

    List<Contact> list = query.getResultList();
    return list;
  }

  @Override
  @Transactional
  public int removeName(String name) {
    //    em.getTransaction().begin();

    Query query = em.createQuery("DELETE FROM Contact contact WHERE contact.name = :name");
    query.setParameter("name", name);
    int ok = query.executeUpdate();
    //    Query query = em.createQuery("from Contact contact WHERE contact.name = :name");
    //    query.setParameter("name", name);
    //    System.out.println(query.getFirstResult());
    //    List<Contact> list = query.getResultList();
    System.out.println(ok);
    //    em.remove(conact);
    //    em.getTransaction().commit();
    return ok;
  }

  @Override
  @Transactional
  public int removePhone(long phoneNo) {
    //    em.getTransaction().begin();
    Query query = em.createQuery("DELETE FROM PhoneNo phoneno WHERE phoneno.phoneNo =:pno");
    query.setParameter("pno", phoneNo);
    int ok = query.executeUpdate();
    System.out.println(ok);
    //    em.getTransaction().commit();
    return ok;
  }

  @Override
  @Transactional
  public void deleteName(int cid) {

    Contact contact = em.find(Contact.class, cid);
    em.remove(contact);
  }

  @Override
  @Transactional
  public void deletePnone(int pid) { // TODO Auto-generated method stub

    PhoneNo phone = em.find(PhoneNo.class, pid);
    em.remove(phone);
  }

  @Override @Transactional
  public void updatename(int cid , String name) { 
	  Contact contact = em.find(Contact.class, cid);
	  contact.setName(name);
  }

  @Override @Transactional
  public void updatePhone(int pid , long phoneno) { 
	  PhoneNo phone = em.find(PhoneNo.class, pid);
	  phone.setPhoneNo(phoneno);
  }
}
