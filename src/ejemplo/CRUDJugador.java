package ejemplo;

import java.util.List;

public class CRUDJugador {
	//Fields
	private List <Jugador> players;

	public CRUDJugador(List<Jugador> players) {
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
	//toString

	@Override
	public String toString() {
		return "CRUDJugador [players=" + players + "]";
	}
	
}
