package com.example;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class TodoApplication extends Application {
  @Override
  public Set<Class<?>> getClasses() {
    System.out.println("ok");
    Set<Class<?>> classes = new HashSet<Class<?>>();
    classes.add(TodoResource.class);
    return classes;
  }
}
