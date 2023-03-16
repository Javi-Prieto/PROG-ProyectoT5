package ejemplo;

import java.util.List;

public class Equipo {
	//Fields
	private List<Jugador> players;
	private int cantidadPuntos;
	//Constructor
	public Equipo(List<Jugador> players) {
		super();
		this.players = players;
	}
	//Getter and setter
	public List<Jugador> getPlayers() {
		return players;
	}
	public void setPlayers(List<Jugador> players) {
		this.players = players;
	}
	public int getCantidadPuntos() {
		return cantidadPuntos;
	}
	public void setCantidadPuntos(int cantidadPuntos) {
		this.cantidadPuntos = cantidadPuntos;
	}
	//toString
	@Override
	public String toString() {
		return "Equipo [players=" + players + ", cantidadPuntos=" + cantidadPuntos + "]";
	}
	//Methods
	public void addPlayer(Jugador j) {
		players.add(j);
	}
	
}
