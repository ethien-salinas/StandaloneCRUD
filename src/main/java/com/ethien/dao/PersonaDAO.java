package com.ethien.dao;

import com.ethien.model.Persona;

public interface PersonaDAO {

	public void createTable();
	public void create(Persona persona);
	public Persona read(int id);
	public void update(int id, Persona persona);
	public void delete(int id);

}
