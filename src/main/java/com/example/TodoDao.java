package com.example;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class TodoDao {
	@PersistenceContext(name = "jpa-unit")
	private EntityManager em;
	
	public void create(TodoDto todo) {
		em.persist(todo);
	}
	
	public TodoDto read(int id) {
		return em.find(TodoDto.class, id);
	}
	
	public void update(TodoDto todo) {
		em.merge(todo);
	}
	
	public void delete(TodoDto todo) {
		em.remove(todo);
	}
	
	@SuppressWarnings("unchecked")
	public List<TodoDto> readAll() {
		return em.createNativeQuery("select * from todos", TodoDto.class).getResultList();
	}
}
