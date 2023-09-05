package com.alura.hotel.modelo;

import java.sql.Date;

public class Reservas {
	private int id;
	private Date fechaentrada;
	private Date fechasalida;
	private double valor;
	private String formapago;
	
	public Reservas(Date fechaentrada, Date fechasalida, Double valor,String formapago) {
		this.fechaentrada=fechaentrada;
		this.fechasalida=fechasalida;
		this.valor= valor;
		this.formapago= formapago;
	}
	
	public Reservas(int id, Date fechaentrada, Date fechasalida, double valor, String formapago) {
		super();
		this.id = id;
		this.fechaentrada = fechaentrada;
		this.fechasalida = fechasalida;
		this.valor = valor;
		this.formapago = formapago;
	}



	public Date getFechaentrada() {
		return fechaentrada;
	}

	public Date getFechasalida() {
		return fechasalida;
	}

	public double getValor() {
		return valor;
	}

	public String getFormapago() {
		return formapago;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	

	


}
