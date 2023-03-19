package ejemplo;

import java.util.Iterator;
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
	public Equipo findByName(String name) {
		List <Equipo> lista = equipos.stream()
									.filter(n -> n.getNombre().equalsIgnoreCase(name))
									.toList();
		return lista.get(0);
	}
	public void borrarEquipo(String nombre) {
		equipos.remove(findByName(nombre));
	}
	public void vaciarJugadoresEquipo(String nombre) {
		equipos.get(equipos.indexOf(findByName(nombre))).getCrud().getPlayers().clear();
	}
	public void calcularPuntosTodosEquipos() {
		int i = 0;
		Iterator <Equipo> itE = equipos.iterator();
		while(itE.hasNext() && i < equipos.size()) {
			equipos.get(i).calcularCantidadPuntosEquipo();
			i++;
		}
	}
}
