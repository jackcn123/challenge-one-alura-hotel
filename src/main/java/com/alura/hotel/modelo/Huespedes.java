package com.alura.hotel.modelo;

import java.sql.Date;

public class Huespedes {

	
	private int id;
	private String nombre;
	private String apellido;
	private Date fechadenacimiento;
	private String nacionalidad;
	private int telefono;
	private int idreserva;
	
	public Huespedes(String nombre, String apellido, Date fechadenacimiento, String nacionalidad, int telefono,
			int idreserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechadenacimiento = fechadenacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idreserva = idreserva;
	}

	public Huespedes(int id, String nombre, String apellido, Date fechadenacimiento, String nacionalidad, int telefono,
			int idreserva) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechadenacimiento = fechadenacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idreserva = idreserva;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Date getFechadenacimiento() {
		return fechadenacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public int getTelefono() {
		return telefono;
	}

	public int getIdreserva() {
		return idreserva;
	}
	
	
}
