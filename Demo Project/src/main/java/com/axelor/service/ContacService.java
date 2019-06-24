package com.axelor.service;

import java.util.List;

import com.axelor.db.Contact;

public interface ContacService {
	
	void insert(String name ,long phoneNo);
	
	List<Contact> show();
	
	int update(long oldpno , long newpno);
	
	int removeName(String name);
	int removePhone(long phoneNo);
	
	void deleteName(int cid);
    void deletePnone(int pid);
    
    void updatename(int cid , String name);
    void updatePhone(int pid , long pmobileno);
}