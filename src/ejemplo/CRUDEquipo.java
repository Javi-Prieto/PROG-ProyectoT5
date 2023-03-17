package ejemplo;

import java.util.List;

public class CRUDEquipo {
	//Fields
	private List<Equipo> equipos;
	//Constructor

	public CRUDEquipo(List<Equipo> equipos) {
		super();
		this.equipos = equipos;
	}
	//Getter and setter
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	//toString
	@Override
	public String toString() {
		return "CRUDEquipo [equipos=" + equipos + "]";
	}
	//Methods
	public void agregarEquipo(Equipo e) {
		equipos.add(e);
	}
}
