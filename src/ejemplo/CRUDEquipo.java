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
	/*Método encargado de buscar un equipo por nombre*/
	public Equipo findByName(String name) {
		List <Equipo> lista = equipos.stream()
				//Una vez generado un stream de la lista de equipos le aplicamos un filter en el que usa un predicate y todo el que lo cumpla es el que continua en el stream
									.filter(n -> n.getNombre().equalsIgnoreCase(name))
									.toList();
		//Al ser único el nombre  devuelvo la posición 0 ya que solo va a haber uno con un nombre
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
