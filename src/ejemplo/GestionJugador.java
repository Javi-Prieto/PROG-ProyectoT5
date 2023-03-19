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
	public List<Jugador> extraerJugadoresPorKd(){
		return crudJ.getPlayers().stream()
										.sorted(new CompararPorKD())
										.toList();
	}
	public List<Jugador> extraerJugadoresPorKd(int limit){
		return crudJ.getPlayers().stream()
				.sorted(new CompararPorKD())
				.limit(limit)
				.toList();
	}
}
