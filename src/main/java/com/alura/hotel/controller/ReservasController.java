package com.alura.hotel.controller;

import java.sql.Date;
import java.util.List;

import com.alura.hotel.dao.ReservasDAO;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Reservas;

public class ReservasController {

    private ReservasDAO reservasDAO;
    
    public ReservasController() {
        var factory = new ConnectionFactory();
        this.reservasDAO = new ReservasDAO(factory.recuperaConexion());
    }

   public void guardar(Reservas reservas) {
        reservasDAO.guardar(reservas);
    }
   public List<Reservas> listar() {
       return reservasDAO.listar();
   }
   public int modificar(int id, Date fechaentrada,Date fechasalida,double valor, String formapago) {
       return reservasDAO.modificar(id,fechaentrada,fechasalida,valor, formapago);
   }

public void eliminar(int id) {
	reservasDAO.eliminar(id);
}

public  List<Reservas> filtrar(int num_reserva) {
       return reservasDAO.filtrar(num_reserva);
}
   

}
