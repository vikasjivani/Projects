package com.axelor;

import com.google.inject.Inject;

import javax.ws.rs.FormParam;

import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Path("/hello")
public class HelloResource {
	private Greeter greeter;

	@Inject
   public HelloResource(Greeter greeter)
   {
      this.greeter = greeter;
   }

	@POST
   @Path("/insert")
   public void setdata(@FormParam("uname") String name , @FormParam("pnumber") String pno) {
      greeter.insert(name,pno);
   }
}