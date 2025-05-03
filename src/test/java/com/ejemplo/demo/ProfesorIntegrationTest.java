package com.ejemplo.demo;

import com.ejemplo.demo.model.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfesorIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testObtenerProfesorPorId() {
		String url = "http://localhost:" + port + "/profesores"; // endpoint general

		Profesor[] profesores = restTemplate.getForObject(url, Profesor[].class);

		assertNotNull(profesores);
		assertTrue(profesores.length > 0);

		System.out.println("Resultado de GET /profesores:");
		for (Profesor p : profesores) {
			System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre());
		}
	}
}
