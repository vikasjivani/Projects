package com.axelor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DefaultGreeter implements Greeter
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
	EntityManager em = emf.createEntityManager();

@Override
public void insert(String name, String pno) {
	em.getTransaction().begin();
	Student st = new Student();
	
	st.setName(name);
	st.setPno(pno);
	
	em.persist(st);
	em.getTransaction().commit();
	System.out.println("test 1 ");
}
}