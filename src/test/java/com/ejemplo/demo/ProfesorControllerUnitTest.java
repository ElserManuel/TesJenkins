package com.ejemplo.demo;

import com.ejemplo.demo.controller.ProfesorController;
import com.ejemplo.demo.model.Profesor;
import com.ejemplo.demo.service.ProfesorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProfesorControllerUnitTest {

    private ProfesorService profesorServiceMock;
    private ProfesorController profesorController;

    @BeforeEach
    public void setup() {
        profesorServiceMock = mock(ProfesorService.class);
        profesorController = new ProfesorController(profesorServiceMock);
    }

    @Test
    public void testListarProfesores() {
        List<Profesor> mockProfesores = Arrays.asList(
                new Profesor(1L, "Juan Pérez"),
                new Profesor(2L, "Ana Gómez")
        );
        when(profesorServiceMock.obtenerTodos()).thenReturn(mockProfesores);

        List<Profesor> resultado = profesorController.listar();

        assertEquals(2, resultado.size());
        assertEquals("Juan Pérez", resultado.get(0).getNombre());
        verify(profesorServiceMock, times(1)).obtenerTodos();

        System.out.println("Resultado de listar():");
        resultado.forEach(p -> System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre()));
    }
}
