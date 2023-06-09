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
	//methods
	public void agregarJugador(Jugador j) {
		players.add(j);
	}
	public Jugador findByName(String name) {
		Jugador j = players.stream()
						.filter(n -> n.getNombre().equalsIgnoreCase(name))
						.toList().get(0);
		return j;
	}
	public void borrarJugador(String nombre) {
		players.remove(findByName(nombre));
	}
	public void editarJugadorCantKills(String nombre, int kills) {
		players.get(players.indexOf(findByName(nombre))).setCantidadKillsTotal(kills);
	}
}
