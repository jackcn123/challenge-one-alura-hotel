package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.alura.hotel.controller.HuespedesController;
import com.alura.hotel.controller.ReservasController;
import com.alura.hotel.modelo.Huespedes;
import com.alura.hotel.modelo.Reservas;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
	private ReservasController reservasController;
	private HuespedesController huespedesController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		this.reservasController = new ReservasController();
		this.huespedesController = new HuespedesController();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 332, 42);
		contentPane.add(lblNewLabel_4);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table,
				null);
		scroll_table.setVisible(true);

		cargarTablaReservas(reservasController.listar(), modelo);

		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")),
				scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);

		cargarTablaHuespedes(huespedesController.listar(), modeloHuesped);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) { // Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) { // Al usuario quitar el mouse por el botón este volverá al estado
													// original
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);

		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscar(panel);
			}
		});

		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int num = panel.getSelectedIndex();
				if (num == 0) {
					editarReservas();
				} else {
					editarHuespedes();
				}
			}
		});
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnEliminar = new JPanel();
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int num = panel.getSelectedIndex();
				if (num == 0) {
					eliminar(tbReservas, modelo, num);
				} else {
					eliminar(tbHuespedes, modeloHuesped, num);
				}
			}

		});
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);

	}

//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

	private void cargarTablaReservas(List<Reservas> list, DefaultTableModel modelo2) {
		if (list.isEmpty()) {
			modelo2.setRowCount(0);
			return;
		}
		modelo2.getDataVector().clear();
		list.forEach(reservas -> modelo.addRow(new Object[] { reservas.getId(), reservas.getFechaentrada(),
				reservas.getFechasalida(), reservas.getValor(), reservas.getFormapago() }));
	}

	private void cargarTablaHuespedes(List<Huespedes> list, DefaultTableModel modeloHuesped2) {
		if (list.isEmpty()) {
			modeloHuesped2.setRowCount(0);
			return;
		}
		modeloHuesped2.getDataVector().clear();
		list.forEach(huespedes -> modeloHuesped2.addRow(new Object[] { huespedes.getId(), huespedes.getNombre(),
				huespedes.getApellido(), huespedes.getFechadenacimiento(), huespedes.getNacionalidad(),
				huespedes.getTelefono(), huespedes.getIdreserva() }));
	}

	private void editarReservas() {
		if (notieneFilaElegida(tbReservas)) {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
			return;
		}

		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
				.ifPresentOrElse(fila -> {
					Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
					Date fechaentrada = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
					Date fechasalida = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
					Double valor = Double.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString());
					String formapago = modelo.getValueAt(tbReservas.getSelectedRow(), 4).toString();

					var filaModificada = this.reservasController.modificar(id, fechaentrada, fechasalida, valor,
							formapago);

					JOptionPane.showMessageDialog(this, String.format("%d item modificado con éxito!", filaModificada));
				}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));

	}

	private void editarHuespedes() {
		if (notieneFilaElegida(tbHuespedes)) {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
			return;
		}

		Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
				.ifPresentOrElse(fila -> {
					Integer id = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
					String nombre = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1).toString();
					String apellido = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2).toString();
					Date fechadenacimiento = Date
							.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3).toString());
					String nacionalidad = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4).toString();
					Integer telefono = Integer
							.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5).toString());
					Integer idreserva = Integer
							.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 6).toString());

					var filaModificada = this.huespedesController.modificar(id, nombre, apellido, fechadenacimiento,
							nacionalidad, telefono, idreserva);

					JOptionPane.showMessageDialog(this, String.format("%d item modificado con éxito!", filaModificada));
				}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));

	}

	private boolean notieneFilaElegida(JTable tabla) {
		return tabla.getSelectedRowCount() == 0 || tabla.getSelectedColumnCount() == 0;
	}

	private void eliminar(JTable tabla, DefaultTableModel modeloelegido, int idtabla) {

		if (notieneFilaElegida(tabla)) {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
			return;
		}
		if (deseaContinuar() == false)
			return;

		Optional.ofNullable(modeloelegido.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
				.ifPresentOrElse(fila -> {
					int id = Integer.valueOf(modeloelegido.getValueAt(tabla.getSelectedRow(), 0).toString());
					switch (idtabla) {
					case 0:
						if (!TieneHuesped(id)) {
							this.reservasController.eliminar(id);
						} else {
							JOptionPane.showMessageDialog(this,
									"No es posible eliminar la reserva debido a que está asignada a un huesped");
							return;
						}
						break;
					case 1:
						this.huespedesController.eliminar(id);
						break;
					}
					modeloelegido.removeRow(tabla.getSelectedRow());
					JOptionPane.showMessageDialog(this, String.format(" item eliminado con éxito!"));
				}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));

	}

	private boolean TieneHuesped(int id) {
		return huespedesController.buscaReserva_Huesped(id);
	}

	private boolean validaEsNumero(String in) {
		try {
			Integer.parseInt(in);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean deseaContinuar() {
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Confirma que desea eliminar el item seleccionado?");
		return (JOptionPane.OK_OPTION == respuesta);
	}

	private void buscar(JTabbedPane panel) {
		String buscado = txtBuscar.getText();
		if (!buscado.isEmpty()) {
			if (validaEsNumero(buscado)) {
				var reservafiltrada = reservasController.filtrar(Integer.parseInt(buscado));
				cargarTablaReservas(reservafiltrada, modelo);
				panel.setSelectedIndex(0);
			} else {
				var huespedfiltrado = huespedesController.filtrar(buscado);
				cargarTablaHuespedes(huespedfiltrado, modeloHuesped);
				panel.setSelectedIndex(1);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ingrese un apellido o número de reserva para la búsqueda");
			cargarTablaReservas(reservasController.listar(), modelo);
			cargarTablaHuespedes(huespedesController.listar(), modeloHuesped);
		}
	}
}