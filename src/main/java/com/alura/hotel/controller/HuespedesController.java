package com.alura.hotel.controller;

import java.sql.Date;
import java.util.List;

import com.alura.hotel.dao.HuespedesDAO;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Huespedes;

public class HuespedesController {
	private HuespedesDAO huespedesDAO;

	public HuespedesController() {
		var factory = new ConnectionFactory();
		this.huespedesDAO = new HuespedesDAO(factory.recuperaConexion());
	}

	public void guardar(Huespedes huespedes) {
		huespedesDAO.guardar(huespedes);
	}

	public List<Huespedes> listar() {
		return huespedesDAO.listar();
	}

	public int modificar(Integer id, String nombre, String apellido, Date fechadenacimiento, String nacionalidad,
			Integer telefono, Integer idreserva) {
		return huespedesDAO.modificar(id, nombre, apellido, fechadenacimiento, nacionalidad, telefono, idreserva);

	}

	public void eliminar(Integer id) {
		huespedesDAO.eliminar(id);
	}

	public List<Huespedes> filtrar(String apellidobuscado) {
		return huespedesDAO.filtrar(apellidobuscado);
	}
	public boolean buscaReserva_Huesped(int id) {
		return huespedesDAO.buscaReserva_Huesped(id);
	}
}
