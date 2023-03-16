package ejemplo;

import java.util.List;

public class Equipo {
	//Fields
	private String nombre;
	private CRUDJugador crud;
	private int cantidadPuntos;
	//Constructor
	public Equipo(CRUDJugador crud, int cantidadPuntos) {
		super();
		this.crud = crud;
		this.cantidadPuntos = cantidadPuntos;
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
	@Override
	public String toString() {
		return "Equipo [crud=" + crud + ", cantidadPuntos=" + cantidadPuntos + "]";
	}
	//Methods
	
}
