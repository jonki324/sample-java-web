package com.example;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("todo")
public class TodoResource {
	@Inject
	private TodoDao dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getTodos() {
		List<TodoDto> todoList = dao.readAll();
		Response response = Response.status(Response.Status.OK).entity(todoList).build();
		return response;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getTodo(@PathParam("id") Integer id) {
		TodoDto todo = dao.read(id);
		Response response = Response.status(Response.Status.OK).entity(todo).build();
		return response;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response create(TodoDto todo) {
		dao.create(todo);
		Response response = Response.status(Response.Status.CREATED).entity(todo).build();
		return response;
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response update(@PathParam("id") Integer id, TodoDto todo) {
		TodoDto preTodo = dao.read(id);
		preTodo.setTask(todo.getTask());
		preTodo.setIsDone(todo.getIsDone());
		dao.update(preTodo);
		Response response = Response.status(Response.Status.CREATED).entity(preTodo).build();
		return response;
	}
	
	@DELETE
	@Path("{id}")
	@Transactional
	public Response delete(@PathParam("id") Integer id) {
		TodoDto todo = dao.read(id);
		dao.delete(todo);
		Response response = Response.status(Response.Status.CREATED).build();
		return response;
	}
}
