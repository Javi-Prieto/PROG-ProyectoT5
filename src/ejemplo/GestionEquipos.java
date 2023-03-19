package ejemplo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class GestionEquipos {
	//Fields
	private CRUDEquipo crudE;
	//Constructor

	public GestionEquipos(CRUDEquipo crudE) {
		super();
		this.crudE = crudE;
	}
	//Getter and setter

	public CRUDEquipo getCrudE() {
		return crudE;
	}

	public void setCrudE(CRUDEquipo crudE) {
		this.crudE = crudE;
	}
	//toString

	@Override
	public String toString() {
		return "GestionEquipos [crudE=" + crudE + "]";
	}
	//Methods
	public void addEquipo(Equipo e) {
		crudE.agregarEquipo(e);
	}
	public List<Equipo> extraerEquiposConMasPuntos(int limit){
		return crudE.getEquipos().stream()
								.sorted(new CompararPorCantPuntosEquipo())
								.limit(limit)
								.toList();
	}
	public Equipo sumarPuntosJugadores(String nombre){
		Jugador j;
		Equipo e = crudE.findByName(nombre);
		List <Jugador> lista= new ArrayList<Jugador>();
		Iterator<Jugador> itJug = e
				.getCrud()
				.getPlayers()
				.iterator();
		Iterator<Integer> itInt = e
				.getCrud()
				.getPlayers()
				.stream()
				.map(n -> n.getCantPuntosIndv()+10)
				.collect(Collectors.toList())
				.iterator();
		
		
		while(itJug.hasNext() && itInt.hasNext()) {
			j = itJug.next();
			j.setCantPuntosIndv(itInt.next());
			lista.add(j);
		}
		crudE.vaciarJugadoresEquipo(nombre);
		crudE.findByName(nombre).getCrud().setPlayers(lista);
		crudE.findByName(nombre).setCantPartidasGanadas(crudE.findByName(nombre).getCantPartidasGanadas()+1);
		return e;
	}
	public List<Jugador> extraerJugadorConKills(int limit){
		List<Jugador> lista= new ArrayList<Jugador>();
		Iterator<Equipo> itEq = crudE.getEquipos().iterator();
		while(itEq.hasNext()) {
			lista.add(itEq.next().getCrud().getPlayers()
					.stream()
					.sorted()
					.limit(limit)
					.skip(limit-1)
					.toList()
					.get(0)); 
		}
		return lista;
	}
	public void agregarPartidaGanada(String name) {
		crudE.findByName(name).setCantPartidasGanadas(
				crudE.findByName(name).getCantPartidasGanadas()+1);
	}
}
