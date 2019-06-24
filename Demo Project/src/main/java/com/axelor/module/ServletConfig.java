package com.axelor.module;


import com.axelor.service.ContacService;
import com.axelor.service.ContactServiceImp;
import com.axelor.web.Controler;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;

import com.google.inject.Module;

public class ServletConfig extends AbstractModule {

	@Override
	public void configure() {
	
		bind(Controler.class);
		bind(ContacService.class).to(ContactServiceImp.class);
	
	}

}