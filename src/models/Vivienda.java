package models;

public class Vivienda {
	private int id;
	private String desc;
	private Localidad localidad;

	@Override
	public String toString() {
		return desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Vivienda(int id, String desc, Localidad localidad) {
		super();
		this.id = id;
		this.desc = desc;
		this.localidad = localidad;
	}

	public Vivienda() {
		super();
	}

}
