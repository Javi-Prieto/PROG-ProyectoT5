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
	/*Método usado para extrear la cantidad de equipos que desee ordenado por puntos
	 * Es decir, podemos extreaer los 2 equipos con más puntos o los deseados*/
	public List<Equipo> extraerEquiposConMasPuntos(int limit){
		return crudE.getEquipos().stream()
								//Creamos un stream y lo ordenamos de forma no natural por cantidad de Puntos
								.sorted(new CompararPorCantPuntosEquipo())
								//Lo limitamos a la cantidad de equipos deseada
								.limit(limit)
								//Lo recogemos en una lista
								.toList();
	}
	/*Este método se encarga de sumar 10 puntos a cada jugador de un equipo, es cierto que se podría hacer de forma más sencilla pero lo realizo así para ver el uso
	 * del método map*/
	public Equipo sumarPuntosJugadores(String nombre){
		Jugador j;
		Equipo e = crudE.findByName(nombre);
		List <Jugador> lista= new ArrayList<Jugador>();
		Iterator<Jugador> itJug = e
				.getCrud()
				.getPlayers()
				.iterator();
		//Es el encargado de crear un iterator a partir de un Stream que juntamos en una lista
		Iterator<Integer> itInt = e
				.getCrud()
				.getPlayers()
				.stream()
				//Aquí usamos el método map que recoge de n que sería cada uno de los jugadores del equipo y dentro de
				//estos recoge los datos de puntos individuales y a estos les suma 10
				//lo que devuelve esté método al hacerlo así NO SON jugadores completos devuelve solo los INTEGER sumados
				//de cada uno de los jugadores
				.map(n -> n.getCantPuntosIndv()+10)
				.collect(Collectors.toList())
				.iterator();
		
		//En una lista generada anteriormente cómo cada uno de los valores int van a ir en el mismo orden que los jugadores
		//uso un while para ir añadiendo los jugadores y usando un setter para agregar la nueva cantidad de puntos
		while(itJug.hasNext() && itInt.hasNext()) {
			j = itJug.next();
			j.setCantPuntosIndv(itInt.next());
			lista.add(j);
		}
		//Una vez hecho esto vacío el equipo completo ya que creo que va a ser lo más como vaciarlo y volverlo a llenar
		crudE.vaciarJugadoresEquipo(nombre);
		crudE.findByName(nombre).getCrud().setPlayers(lista);
		//Con este paso final lo que hago es sumarle 1 partida ganada al equipo que queramos
		agregarPartidaGanada(nombre);
		return e;
	}
	/*Este método se encarga de extraer dentro de un equipo el jugador con la posición que queremos ordenado por kills*/
	public List<Jugador> extraerJugadorConKills(int limit){
		List<Jugador> lista= new ArrayList<Jugador>();
		Iterator<Equipo> itEq = crudE.getEquipos().iterator();
		while(itEq.hasNext()) {
			//Lo que voy haciendo es agregar a la lista anteriormente creada el jugador deseado
			lista.add(itEq.next().getCrud().getPlayers()
					.stream()
					//Generamos el Stream y lo ordenamos de forma natural ya que así tendriamos los jugadores por kills
					// de mayor a menor
					.sorted()
					//Limitamos el stream a la cantidad de jugadores del jugador que deseamos, si deseamos el 3 limitamos a 3 jugadores
					.limit(limit)
					//con el método skip saltamos los jugadores previos restando 1 al límite antes puesto para así solo quedarnos con el
					//deseado
					.skip(limit-1)
					.toList()
					//Lo converimos a una lista con un solo elemento y por tanto sacamos el primero que es el único existente
					.get(0)); 
		}
		return lista;
	}
	public void agregarPartidaGanada(String name) {
		crudE.findByName(name).setCantPartidasGanadas(
				crudE.findByName(name).getCantPartidasGanadas()+1);
	}
}
