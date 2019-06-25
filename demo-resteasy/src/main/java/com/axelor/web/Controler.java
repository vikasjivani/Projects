package com.axelor.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.axelor.service.ContacService;
import com.google.inject.Inject;

@Path("/")
public class Controler {

  ContacService contacService;

  @Inject
  public Controler(ContacService contacService) {

    this.contacService = contacService;
  }

  @POST
  @Path("/insert")
  public void add(
      @FormParam("uname") String name,
      @Context HttpServletRequest request,
      @Context HttpServletResponse response)
      throws ServletException, IOException {
    contacService.insert(name);

    request.getRequestDispatcher("success.jsp").forward(request, response);
  }

}
