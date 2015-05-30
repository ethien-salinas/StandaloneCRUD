package com.ethien.main;

import com.ethien.dao.PersonaDAO;
import com.ethien.dao.PersonaDAOImpl;
import com.ethien.model.Persona;

public class MainApp {

	public static void main(String[] args) {
		// ***** Data Access Object *****
		PersonaDAO dao = new PersonaDAOImpl();
		dao.createTable();

		// ***** Definición de personas con constructor sobrecargado *****
		Persona p0 = new Persona(
				"Homero","Simpson",
				"Evergreen Terrace",
				"Springfield");
		Persona p1 = new Persona(
				"Marge", "Simpson", 
				"Evergreen Terrace", 
				"Springfield");
		// ***** operación CREATE *****
		dao.create(p0);
		dao.create(p1);
		// ***** operación READ *****
		System.out.println(dao.read(0));
		System.out.println(dao.read(1));
		// ***** operación UPDATE *****
		p0.setNombre("Bar");
		dao.update(0, p0);
		System.out.println(dao.read(0));
		System.out.println(dao.read(1));
		// ***** operación UPDATE *****
		dao.delete(0);
		System.out.println(dao.read(0));
		System.out.println(dao.read(1));

	}

}
