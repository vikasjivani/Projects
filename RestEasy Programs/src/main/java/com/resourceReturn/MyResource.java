package com.resourceReturn;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/student")
public class MyResource {
	
	Student stu = new Student();
	
	@GET
	public Student getData()
	{
		stu.setMarks(54);
		stu.setName("naveen");
		return stu;
	}
}
