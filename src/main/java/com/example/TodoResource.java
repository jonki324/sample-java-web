package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("todo")
public class TodoResource {
  @GET
  @Path("todos")
  @Produces(MediaType.TEXT_PLAIN)
  public String getTodos() {
    return "todos";
  }
}
