package models;

public class Localidad {
	private int id;
	private String desc;

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

	public Localidad(int id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}

	public Localidad() {
		super();
	}

}
