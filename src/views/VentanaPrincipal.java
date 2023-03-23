package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.InquilinoController;
import controllers.LocalidadController;
import controllers.ViviendaController;
import models.Inquilino;
import models.Localidad;
import models.Vivienda;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfDni;
	private JTextField jtfNombre;
	private JTextField jtfFecha;
	private JTextField jtfFin;
	private JTextField jtfCoste;
	private JComboBox<Localidad> jcbLocalidad;
	private JCheckBox check;
	private JComboBox<Vivienda> jcbVivienda;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JLabel lblNewLabel_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel_1 = new JLabel("Modificacion de alquileres");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Localidad");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		jcbLocalidad = new JComboBox<Localidad>();
		jcbLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcbLocalidad.getSelectedItem() != null) {
					cargarViviendas();

				}
			}
		});
		GridBagConstraints gbc_jcbLocalidad = new GridBagConstraints();
		gbc_jcbLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jcbLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbLocalidad.gridx = 1;
		gbc_jcbLocalidad.gridy = 1;
		contentPane.add(jcbLocalidad, gbc_jcbLocalidad);

		JLabel lblNewLabel_2 = new JLabel("Vivienda");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbVivienda = new JComboBox<Vivienda>();
		jcbVivienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcbVivienda.getSelectedItem() != null) {
					cargarInquilino();
				}
			}
		});
		GridBagConstraints gbc_jcbVivienda = new GridBagConstraints();
		gbc_jcbVivienda.insets = new Insets(0, 0, 5, 0);
		gbc_jcbVivienda.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbVivienda.gridx = 1;
		gbc_jcbVivienda.gridy = 2;
		contentPane.add(jcbVivienda, gbc_jcbVivienda);

		JLabel lblNewLabel_3 = new JLabel("Datos del inquilino");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Id");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 4;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("dni");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		contentPane.add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Nombre Completo");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 6;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Fecha inicio");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 7;
		contentPane.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);

		check = new JCheckBox("");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check.isSelected()) {
					jtfFin.setEnabled(false);
					jtfFin.setText("");
				} else {
					jtfFin.setEnabled(true);

				}
			}
		});
		GridBagConstraints gbc_check = new GridBagConstraints();
		gbc_check.anchor = GridBagConstraints.EAST;
		gbc_check.insets = new Insets(0, 0, 5, 5);
		gbc_check.gridx = 0;
		gbc_check.gridy = 8;
		contentPane.add(check, gbc_check);

		JLabel lblNewLabel_8 = new JLabel("Alquiler en activo");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 8;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Fecha fin");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 9;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);

		jtfFin = new JTextField();
		GridBagConstraints gbc_jtfFin = new GridBagConstraints();
		gbc_jtfFin.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFin.gridx = 1;
		gbc_jtfFin.gridy = 9;
		contentPane.add(jtfFin, gbc_jtfFin);
		jtfFin.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Coste mensual (€)l");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 10;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);

		jtfCoste = new JTextField();
		jtfCoste.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					float cuotaSinIVA = Integer.parseInt(jtfCoste.getText());
					float cuotaConIVA = (float) (cuotaSinIVA * 1.21);
					lblNewLabel_12.setText(cuotaConIVA + "");
				} catch (Exception e2) {

				}
			}
		});
		GridBagConstraints gbc_jtfCoste = new GridBagConstraints();
		gbc_jtfCoste.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCoste.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCoste.gridx = 1;
		gbc_jtfCoste.gridy = 10;
		contentPane.add(jtfCoste, gbc_jtfCoste);
		jtfCoste.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Total mesual (IVA incluido)(€)");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 11;
		contentPane.add(lblNewLabel_11, gbc_lblNewLabel_11);

		lblNewLabel_12 = new JLabel("Precio con IVA");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_12.gridx = 1;
		gbc_lblNewLabel_12.gridy = 11;
		contentPane.add(lblNewLabel_12, gbc_lblNewLabel_12);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 12;
		contentPane.add(panel, gbc_panel);

		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobaciones()) {
					modificar();
				}

			}
		});
		panel.add(btnNewButton);

		cargarLocalidad();
		jtfId.setEnabled(false);

	}

	private void cargarLocalidad() {
		List<Localidad> li = LocalidadController.cargarLocalidades();

		for (Localidad lo : li) {
			jcbLocalidad.addItem(lo);
		}

	}

	private void cargarViviendas() {
		Localidad lo = (Localidad) jcbLocalidad.getSelectedItem();
		List<Vivienda> li = ViviendaController.cargarViviendas(lo.getId());

		jcbVivienda.removeAllItems();

		for (Vivienda vivienda : li) {
			jcbVivienda.addItem(vivienda);
		}

	}

	private void cargarInquilino() {
		Vivienda vi = (Vivienda) jcbVivienda.getSelectedItem();
		Inquilino i = InquilinoController.cargarLocalidades(vi.getId());
		jtfId.setText(i.getId() + "");
		jtfDni.setText(i.getDni());
		jtfNombre.setText(i.getNombre());
		jtfFecha.setText(sdf.format(i.getFechaIni()));
		if (i.getFechaFin() != null) {
			jtfFin.setText(sdf.format(i.getFechaFin()));
			check.setSelected(true);
		} else {
			check.setSelected(false);
		}
		jtfCoste.setText(i.getCuota() + "");

	}

	private boolean comprobaciones() {
		if (jtfNombre.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "El nombre no puede estar en blanco");
			return false;
		}

		Pattern pat = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
		Matcher mat = pat.matcher(jtfDni.getText());
		if (!(mat.find())) {
			JOptionPane.showMessageDialog(null, "El dni no tiene el formato correcto");
			return false;
		}

		return true;
	}

	private void modificar() {
		Inquilino i = new Inquilino();
		i.setId(Integer.parseInt(jtfId.getText()));
		i.setDni(jtfDni.getText());
		i.setNombre(jtfNombre.getText());
		try {
			i.setFechaIni(sdf.parse(jtfFecha.getText()));
			if (sdf.parse(jtfFin.getText()) != null) {
				i.setFechaFin(sdf.parse(jtfFin.getText()));
			}
		} catch (ParseException e) {
		}
		i.setCuota(Float.parseFloat(jtfCoste.getText()));
		Vivienda vi = (Vivienda) jcbVivienda.getSelectedItem();
		i.setVivienda(vi);
		InquilinoController.modificar(i);
	}

}
