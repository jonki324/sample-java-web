package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

public class EndPointIT {
	private static final Jsonb jsonb = JsonbBuilder.create();
	
	@Test
	public void testGetTodos() {
		String port = System.getProperty("http.port");
		String context = System.getProperty("context.root");
		String url = String.format("http://localhost:%s/%s/api/todo", port, context);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);
		Response response = target.request().get();
		
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		
		response.close();
	}
}
