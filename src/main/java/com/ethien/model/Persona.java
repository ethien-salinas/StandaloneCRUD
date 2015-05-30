package com.ethien.model;

public class Persona {
	
	public Persona() {}
	
	public Persona(String nombre, String apellido, String direccion, String estado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.ciudad = estado;
	}

	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String ciudad;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String estado) {
		this.ciudad = estado;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", direccion=" + direccion + ", ciudad=" + ciudad
				+ "]";
	}

}
