package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("todo")
public class TodoResource {
  private static List<TodoDto> todoList = new ArrayList<>();
  static {
    todoList.add(new TodoDto(1, "task1", true));
    todoList.add(new TodoDto(2, "task2", false));
    todoList.add(new TodoDto(3, "task3", false));
  }

  @GET
  @Path("todos")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getTodos() {
    Response response = Response.status(Response.Status.OK).entity(todoList).build();
    return response;
  }

  @GET
  @Path("todos/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getTodo(@PathParam("id") Integer id) {
    TodoDto todo = todoList.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    Response response = Response.status(Response.Status.OK).entity(todo).build();
    return response;
  }

  @POST
  @Path("todos")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response create(TodoDto todo) {
    Response response = Response.status(Response.Status.OK).entity(todo).build();
    return response;
  }
}
