package ejemplo;

import java.util.Iterator;

public class Equipo implements Comparable<Equipo>{
	//Fields
	private String nombre;
	private CRUDJugador crud;
	private int cantidadPuntos, cantPartidasGanadas;
	//Constructor
	public Equipo(String nombre, CRUDJugador crud, int cantPartidasGanadas) {
		super();
		this.nombre = nombre;
		this.crud = crud;
		this.cantPartidasGanadas = cantPartidasGanadas;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CRUDJugador getCrud() {
		return crud;
	}
	public void setCrud(CRUDJugador crud) {
		this.crud = crud;
	}
	public int getCantidadPuntos() {
		return cantidadPuntos;
	}
	public void setCantidadPuntos(int cantidadPuntos) {
		this.cantidadPuntos = cantidadPuntos;
	}
	public int getCantPartidasGanadas() {
		return cantPartidasGanadas;
	}

	public void setCantPartidasGanadas(int cantPartidasGanadas) {
		this.cantPartidasGanadas = cantPartidasGanadas;
	}

	@Override
	public String toString() {
		return "Equipo [crud=" + crud + ", cantidadPuntos=" + cantidadPuntos + "]";
	}
	
	//Methods

	@Override
	public int compareTo(Equipo o) {
		if(this.cantPartidasGanadas > o.cantPartidasGanadas) {
			return -1;
		}else {
			if(this.cantPartidasGanadas < o.cantPartidasGanadas) {
				return 1;
			}else {
				return 0;
			}
		}
	}
	public void calcularCantidadPuntosEquipo() {
		int cantPuntos = 0;
		Iterator <Jugador> it = crud.getPlayers().iterator();
		Jugador j;
		while(it.hasNext()) {
			j = it.next();
			cantPuntos += j.getCantPuntosIndv();
		}
		this.cantidadPuntos = cantPuntos;
	}
	public void addJugador(Jugador j) {
		crud.agregarJugador(j);
	}
}
