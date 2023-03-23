package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Localidad;
import models.Vivienda;

public class ViviendaController {
	private static Connection conn = null;

	public static List<Vivienda> cargarViviendas(int id) {
		List<Vivienda> lc = new ArrayList<Vivienda>();
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM vivienda where idLocalidad = " + id);
			ResultSet rs = ps.executeQuery();
			Vivienda vi = null;
			while (rs.next()) {
				vi = new Vivienda();
				vi.setId(rs.getInt(1));
				vi.setDesc(rs.getString(2));
				Localidad lo = new Localidad();
				lo.setId(rs.getInt(3));
				vi.setLocalidad(lo);
				lc.add(vi);
			}
			rs.close();
			ps.close();
			conn.close();
			return lc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
