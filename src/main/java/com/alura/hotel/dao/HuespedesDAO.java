package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.modelo.Huespedes;

public class HuespedesDAO {
	private Connection con;

	public HuespedesDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Huespedes huespedes) {
		try {
			PreparedStatement statement;
			statement = con.prepareStatement(
					"INSERT INTO HUESPEDES " + "(nombre, apellido, fechadenacimiento, nacionalidad,telefono,idreserva)"
							+ " VALUES (?, ?, ?, ?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {

				statement.setString(1, huespedes.getNombre());
				statement.setString(2, huespedes.getApellido());
				statement.setDate(3, huespedes.getFechadenacimiento());
				statement.setString(4, huespedes.getNacionalidad());
				statement.setInt(5, huespedes.getTelefono());
				statement.setInt(6, huespedes.getIdreserva());

				statement.execute();

				final ResultSet resultSet = statement.getGeneratedKeys();

				try (resultSet) {
					while (resultSet.next()) {
						huespedes.setId(resultSet.getInt(1));

					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> listar() {

		List<Huespedes> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con.prepareStatement("SELECT * FROM huespedes");

			try (statement) {
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Huespedes(resultSet.getInt("id"), resultSet.getString("nombre"),
								resultSet.getString("apellido"), resultSet.getDate("fechadenacimiento"),
								resultSet.getString("nacionalidad"), resultSet.getInt("telefono"),
								resultSet.getInt("idreserva")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public int modificar(Integer id, String nombre, String apellido, Date fechadenacimiento, String nacionalidad,
			Integer telefono, Integer idreserva) {

		try {
			final PreparedStatement statement = con.prepareStatement("UPDATE huespedes SET nombre = ?, "
					+ " apellido = ?, fechadenacimiento = ?, nacionalidad = ?, telefono =?, idreserva=? WHERE id = ?");

			try (statement) {
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setDate(3, fechadenacimiento);
				statement.setString(4, nacionalidad);
				statement.setInt(5, telefono);
				statement.setInt(6, idreserva);
				statement.setInt(7, id);
				statement.execute();

				int updateCount = statement.getUpdateCount();

				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void eliminar(Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE ID = ?");

			try (statement) {
				statement.setInt(1, id);
				statement.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> filtrar(String apellidobuscado) {
		List<Huespedes> resultadofiltrado = new ArrayList<>();
		try {
			final PreparedStatement statement = con.prepareStatement("SELECT * FROM huespedes WHERE apellido like ?");

			try (statement) {
				statement.setString(1,"%"+apellidobuscado+"%");
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultadofiltrado.add(new Huespedes(resultSet.getInt("id"), resultSet.getString("nombre"),
								resultSet.getString("apellido"), resultSet.getDate("fechadenacimiento"),
								resultSet.getString("nacionalidad"), resultSet.getInt("telefono"),
								resultSet.getInt("idreserva")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultadofiltrado;	
	}
	public boolean buscaReserva_Huesped(int id) {
		boolean retorno;
		try {
			final PreparedStatement statement = con.prepareStatement("SELECT ID FROM huespedes WHERE idreserva= ?");

			try (statement) {
				statement.setInt(1,id);
				statement.execute();
				retorno=statement.getResultSet().next();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return retorno;	
	}
}
