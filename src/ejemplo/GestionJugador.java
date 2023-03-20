package ejemplo;

import java.util.List;

public class GestionJugador {
	//Fields
	private CRUDJugador crudJ;
	//Constructor

	public GestionJugador(CRUDJugador crudJ) {
		super();
		this.crudJ = crudJ;
	}
	//Getter and setter

	public CRUDJugador getCrudJ() {
		return crudJ;
	}

	public void setCrudJ(CRUDJugador crudJ) {
		this.crudJ = crudJ;
	}
	//toString

	@Override
	public String toString() {
		return "GestionJugador [crudJ=" + crudJ + "]";
	}
	//Methods
	public void addJugador(Jugador J) {
		crudJ.agregarJugador(J);
	}
	/*Devolverá la lista de todos los jugadores ordenadas por KD*/
	public List<Jugador> extraerJugadoresPorKd(){
		return crudJ.getPlayers().stream()
										.sorted(new CompararPorKD())
										.toList();
	}
	/*Con este método podremos extraer la cantidad de jugadores deseada ordenados por kd , el primero,
	 * los dos primeros o los deseados*/
	public List<Jugador> extraerJugadoresPorKd(int limit){
		return crudJ.getPlayers().stream()
				//Generamos un stream ordenamos por KD
				.sorted(new CompararPorKD())
				//Limitamos la cantidad de jugadores a la cantidad deseada
				.limit(limit)
				//Convertimos a una lista y lo devolvemos
				.toList();
	}
}
