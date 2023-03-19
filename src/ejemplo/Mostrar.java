package ejemplo;



public class Mostrar {
	//Fields
	private GestionJugador gj;
	private GestionEquipos ge;
	//Constructor
	public Mostrar(GestionJugador gj, GestionEquipos ge) {
		this.ge = ge;
		this.gj = gj;
	}
	//Getter and setter
	public GestionJugador getGj() {
		return gj;
	}

	public void setGj(GestionJugador gj) {
		this.gj = gj;
	}

	public GestionEquipos getGe() {
		return ge;
	}

	public void setGe(GestionEquipos ge) {
		this.ge = ge;
	}

	public void mostrarTodosJugadoresPorKD() {
		for(Jugador j : gj.extraerJugadoresPorKd()) {
			System.out.println("---------------------------------");
			System.out.println("Nombre: " + j.getNombre());
			System.out.printf("Kd: %.2f \n", j.calcularKd());
			System.out.println("Equipo: " + j.getNombreEquipo());
		}
	}
	public void mostrarJugadoresPedidosPorKD( int limit) {
		for(Jugador j : gj.extraerJugadoresPorKd(limit)) {
			System.out.println("---------------------------------");
			System.out.println("Nombre: " + j.getNombre());
			System.out.printf("Kd: %.2f \n", j.calcularKd());
			System.out.println("Equipo: " + j.getNombreEquipo());
		}
	}
	public void mostrarEquiposPorPuntos() {
		for(Equipo e : ge.getCrudE().getEquipos().stream()
				.sorted(new CompararPorCantPuntosEquipo())
				.toList()) {
			System.out.println("---------------------------------");
			System.out.println("Nombre: " + e.getNombre());
			System.out.println("Puntos: " + e.getCantidadPuntos());
			
		}
	}
	public void mostrarAlgunosEquiposPorPuntos(int limit) {
		for(Equipo e : ge.extraerEquiposConMasPuntos(limit)) {
			System.out.println("---------------------------------");
			System.out.println("Nombre: " + e.getNombre());
			System.out.println("Puntos: " + e.getCantidadPuntos());
			
		}
	}
	public void mostrarJugadoresPorKills() {
		for(Jugador j : gj.getCrudJ().getPlayers().stream().sorted().toList()) {
			System.out.println("---------------------------------");
			System.out.println("Nombre: " + j.getNombre());
			System.out.println("Kills: " + j.getCantidadKillsTotal());
			System.out.println("Equipo: " + j.getNombreEquipo());
		}
	}
	public void mostrarJugadorConKillsPorEquipo(int limit) {
		for( Jugador j : ge.extraerJugadorConKills(limit)) {
			
			System.out.println("--------------------------------");
			System.out.println("Jugador: "+ j.getNombre());
			System.out.println("Kills: "+ j.getCantidadKillsTotal());
			System.out.println("Equipo: " + j.getNombreEquipo());
			
		}
	}
	public void mostrarEquipo(String name) {
		Equipo e = ge.getCrudE().findByName(name);
		System.out.println("----------------------------");
		System.out.println("Nombre: " + e.getNombre());
		System.out.println("PG: " + e.getCantPartidasGanadas());
		System.out.println("Puntos: " + e.getCantidadPuntos());
		
	}
	public void mostrarTodosLosEquipos() {
		for(Equipo e : ge.getCrudE().getEquipos().stream().sorted().toList()) {
			System.out.println("----------------------------");
			System.out.println("Nombre: " + e.getNombre());
			System.out.println("PG: " + e.getCantPartidasGanadas());
			System.out.println("Puntos: " + e.getCantidadPuntos());
			
		}
	}
	public void mostrarJugadoresEquipo(String name) {
		
		for(Jugador j: ge.getCrudE().findByName(name).getCrud().getPlayers() ) {
			System.out.println("--------------------------------");
			System.out.println("Nombre: " + j.getNombre());
			System.out.println("Kills: " + j.getCantidadKillsTotal());
			System.out.println("Puntos: " + j.getCantPuntosIndv());
			System.out.println("Muertes: " + j.getCantMuertesTotal());
		}
	}
	public void mostrarEquipoPuntosSumados(String nombre) {
		for(Jugador j : ge.sumarPuntosJugadores(nombre).getCrud().getPlayers()) {
			System.out.println("---------------------------");
			System.out.println("Nombre: " + j.getNombre());
			System.out.println("Puntos: " + j.getCantPuntosIndv());
			
		}
		ge.sumarPuntosJugadores(nombre).calcularCantidadPuntosEquipo();
		mostrarEquipo(nombre);
	}
}
