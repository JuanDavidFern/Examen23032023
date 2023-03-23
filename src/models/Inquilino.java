package models;

import java.util.Date;

public class Inquilino {
	private int id;
	private String dni;
	private String nombre;
	private Date fechaIni;
	private Date fechaFin;
	private float cuota;
	private Vivienda vivienda;

	@Override
	public String toString() {
		return "Inquilino [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", fechaIni=" + fechaIni + ", fechaFin="
				+ fechaFin + ", cuota=" + cuota + ", vivienda=" + vivienda + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public float getCuota() {
		return cuota;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public Inquilino(int id, String dni, String nombre, Date fechaIni, Date fechaFin, float cuota, Vivienda vivienda) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.cuota = cuota;
		this.vivienda = vivienda;
	}

	public Inquilino() {
		super();
	}

}
