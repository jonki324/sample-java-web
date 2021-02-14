package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todos")
public class TodoDto {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "task")
	private String task;
	
	@Column(name = "isDone")
	private Boolean isDone;
}
