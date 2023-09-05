package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.alura.hotel.modelo.Reservas;

public class ReservasDAO {
	private Connection con;

	public ReservasDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Reservas reservas) {
		try {
			PreparedStatement statement;
			statement = con.prepareStatement(
					"INSERT INTO RESERVAS " + "(fechaentrada, fechasalida, valor, formapago)" + " VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {

				statement.setDate(1, reservas.getFechaentrada());
				statement.setDate(2, reservas.getFechasalida());
				statement.setDouble(3, reservas.getValor());
				statement.setString(4, reservas.getFormapago());

				statement.execute();

				final ResultSet resultSet = statement.getGeneratedKeys();

				try (resultSet) {
					while (resultSet.next()) {
						reservas.setId(resultSet.getInt(1));

					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reservas> listar() {
		List<Reservas> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con.prepareStatement("SELECT * FROM reservas");
			try (statement) {
				statement.execute();
				final ResultSet resultSet = statement.getResultSet();
				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Reservas(resultSet.getInt("id"), resultSet.getDate("fechaentrada"),
								resultSet.getDate("fechasalida"), resultSet.getDouble("valor"),
								resultSet.getString("formapago")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public int modificar(int id, Date fechaentrada, Date fechasalida, double valor, String formapago) {
		try {
			final PreparedStatement statement = con.prepareStatement("UPDATE reservas SET fechaentrada = ?, "
					+ " fechasalida = ?, valor = ?, formapago = ? WHERE id = ?");

			try (statement) {
				statement.setDate(1, fechaentrada);
				statement.setDate(2, fechasalida);
				statement.setDouble(3, valor);
				statement.setString(4, formapago);
				statement.setInt(5, id);
				statement.execute();

				int updateCount = statement.getUpdateCount();

				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void eliminar(int id) {
		try {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM reservas WHERE ID = ?");

			try (statement) {
				statement.setInt(1, id);
				statement.execute();

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reservas> filtrar(int num_reserva) {
		List<Reservas> resultado = new ArrayList<>();
		try {
			final PreparedStatement statement = con.prepareStatement("SELECT * FROM reservas WHERE id=?");
			try (statement) {
				statement.setInt(1, num_reserva);
				statement.execute();
				final ResultSet resultSet = statement.getResultSet();
				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Reservas(resultSet.getInt("id"), resultSet.getDate("fechaentrada"),
								resultSet.getDate("fechasalida"), resultSet.getDouble("valor"),
								resultSet.getString("formapago")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;

	}
}
