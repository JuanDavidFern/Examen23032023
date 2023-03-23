package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.Inquilino;
import models.Vivienda;

public class InquilinoController {
	private static Connection conn = null;

	public static Inquilino cargarLocalidades(int id) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM alquileres.inquilino where idVivienda = " + id);
			ResultSet rs = ps.executeQuery();
			Inquilino i = null;
			if (rs.next()) {
				i = new Inquilino();
				i.setId(rs.getInt(1));
				i.setDni(rs.getString(2));
				i.setNombre(rs.getString(3));
				i.setFechaIni(rs.getDate(4));
				i.setFechaFin(rs.getDate(5));
				i.setCuota(rs.getFloat(6));
				Vivienda vi = new Vivienda();
				vi.setId(rs.getInt(7));
				i.setVivienda(vi);

			}
			rs.close();
			ps.close();
			conn.close();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void modificar(Inquilino i) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update inquilino set dni = ?, nombreCompleto = ?, fechaInicioAlquiler = ?, fechaFinAlquiler = ?, cuotaMensual = ? where idVivienda = "
							+ i.getId());

			ps.setString(1, i.getDni());
			ps.setString(2, i.getNombre());
			ps.setDate(3, new java.sql.Date(i.getFechaIni().getTime()));
			if (i.getFechaFin() != null) {
				ps.setDate(4, new java.sql.Date(i.getFechaFin().getTime()));
			} else {
				ps.setDate(4, null);
			}
			ps.setFloat(5, i.getCuota());

			JOptionPane.showMessageDialog(null, "filas afectadas" + ps.executeUpdate());
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
