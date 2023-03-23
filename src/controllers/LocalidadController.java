package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Localidad;

public class LocalidadController {
	private static Connection conn = null;

	public static List<Localidad> cargarLocalidades() {
		List<Localidad> lc = new ArrayList<Localidad>();
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement("select * from localidad");
			ResultSet rs = ps.executeQuery();
			Localidad l = null;
			while (rs.next()) {
				l = new Localidad();
				l.setId(rs.getInt(1));
				l.setDesc(rs.getString(2));
				lc.add(l);
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
