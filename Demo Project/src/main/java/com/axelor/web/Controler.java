package com.axelor.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import com.axelor.db.Contact;
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
  public /*View*/ void add(
      @FormParam("uname") String name,
      @FormParam("pnumber") long pnumber,
      @Context HttpServletRequest request,
      @Context HttpServletResponse response)
      throws ServletException, IOException {
    contacService.insert(name, pnumber);
    System.err.println(request.getContextPath() + "/success.jsp");
    //    return new View("success.jsp");
    //     return new View(request.getContextPath() + "/url");

    request.getRequestDispatcher("success.jsp").forward(request, response);
  }

  @POST
  @Path("/update")
  public void update(
      @Context HttpServletRequest request,
      @Context HttpServletResponse respons,
      @FormParam("oldpno") long oldphoneno,
      @FormParam("newpno") long newphoneno)
      throws ServletException, IOException {
    int ok = contacService.update(oldphoneno, newphoneno);

    if (ok != 0) {
      request.getRequestDispatcher("updatesuccess.jsp").forward(request, respons);
    } else request.getRequestDispatcher("updateError.jsp");
  }

  @GET
  @Path("/show")
  public void showData(@Context HttpServletRequest request, @Context HttpServletResponse respons)
      throws ServletException, IOException {

    List<Contact> contacts = contacService.show();
    System.out.println(contacts);
    request.setAttribute("contactdetails", contacts);
    request.getRequestDispatcher("showall.jsp").forward(request, respons);
  }

  @POST
  @Path("/deleteName")
  public void deletename(
      @FormParam("uname") String name,
      @Context HttpServletRequest request,
      @Context HttpServletResponse respons)
      throws ServletException, IOException {
    int ok = contacService.removeName(name);

    if (ok != 0) {
      request.getRequestDispatcher("donedelete.jsp").forward(request, respons);

    } else {
      request.getRequestDispatcher("updateError.jsp").forward(request, respons);
    }
  }

  @POST
  @Path("/deletephone")
  public void deletephone(
      @FormParam("phoneno") long phoneNo,
      @Context HttpServletRequest request,
      @Context HttpServletResponse respons)
      throws ServletException, IOException {
    int ok = contacService.removePhone(phoneNo);
    System.out.println(ok + " test");
    if (ok != 0) {
      request.getRequestDispatcher("donedelete.jsp").forward(request, respons);

    } else {
      request.getRequestDispatcher("updateError.jsp").forward(request, respons);
    }
  }

  @GET
  @Path("/deletecotact/{cid}")
  public void deletecontact(
      @PathParam("cid") int cid,
      @Context HttpServletRequest request,
      @Context HttpServletResponse respons)
      throws ServletException, IOException {

    contacService.deleteName(cid);

    request.getRequestDispatcher("/donedelete.jsp").forward(request, respons);
  }

  @GET
  @Path("/deletephoneno/{pid}")
  public void deletephoneno(
      @PathParam("pid") int pid,
      @Context HttpServletRequest request,
      @Context HttpServletResponse respons)
      throws ServletException, IOException {
    System.out.println(pid);
    contacService.deletePnone(pid);

    request.getRequestDispatcher("/donedelete.jsp").forward(request, respons);
  }


  @POST
  @Path("/updatename/{cid}")
  public void updateName(
      @Context HttpServletRequest request,
      @Context HttpServletResponse respons,
      @FormParam("name") String name,
      @PathParam("cid") int cid)
      throws ServletException, IOException {
    System.out.println("contact id " + cid);
    System.out.println("new name " + name);
        contacService.updatename(cid, name);

    request.getRequestDispatcher("/updatesuccess.jsp").forward(request, respons);
  }

 
  @POST
  @Path("/updatephone/{pid}")
  public void updatephone(
      @FormParam("phoneno") long phoneno,
      @Context HttpServletRequest request,
      @Context HttpServletResponse respons,
      @PathParam("pid") int pid)
      throws ServletException, IOException {
    System.out.println("phone id " + pid);
    System.out.println("phoneno " + phoneno);
        contacService.updatePhone(pid, phoneno);

    request.getRequestDispatcher("/updatesuccess.jsp").forward(request, respons);
  }
}
