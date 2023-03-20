package ejemplo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utilidades.Leer;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BDD bd = new BDD();
		List <Jugador> listaJugs = new ArrayList<Jugador>(), listaJugsEqs = new ArrayList<Jugador>();
		List <Equipo> listaEqs = new ArrayList<Equipo>();
		CRUDJugador cj;
		CRUDEquipo ce ;
		GestionJugador gj ;
		GestionEquipos ge ;
		Mostrar mo;
		String nombreE, nombreJ;
		int op = 1, opInt = 1, puntos, kills, muertes, partidasGanadas, limit;
		//Rellenar los jugadaores
		listaJugs = Arrays.asList(bd.devolverJugadoresFnatic(), 
				bd.devolverJugadoresGiants(), 
				bd.devolverJugadoresHeretics(),
				bd.devolverJugadoresKarmine(),
				bd.devolverJugadoresKOI(),
				bd.devolverJugadoresNavi())
				//Hacemos una lista con todos los datos de los jugadores y de esta sacamos un stream
				.stream()
				//Con flat map hacemos un Stream de los datos interiores que venían divididos
				//en el Stream los juntamos en uno grande
				.flatMap(x -> x.stream())
				//Recogemos todos los datos y hacemos una lista para poder guardarlo
				.collect(Collectors.toList());
		
		listaEqs = Arrays.asList(bd.devolverFnatic(),
				bd.devolverGiants(),
				bd.devolverHeretics(),
				bd.devolverKarmine(),
				bd.devolverKOI(),
				bd.devolverNavi());
		
		cj = new CRUDJugador(listaJugs);
		ce = new CRUDEquipo(listaEqs);
		ce.calcularPuntosTodosEquipos();
		ge = new GestionEquipos(ce);
		gj = new GestionJugador(cj);
		mo = new Mostrar(gj, ge);
		do {
			menu();
			try {
				op = Leer.datoInt();
				switch(op) {
				//NO USAR EL PRIMER MÉTODO DA ERROR
					case 1:
						System.out.println("Diga el nombre del equipo");
						nombreE = Leer.dato();
						while(opInt == 1) {
							System.out.println("Diga el nombre del jugador");
							nombreJ = Leer.dato();
							System.out.println("Diga los puntos");
							puntos = Leer.datoInt();
							System.out.println("Diga la cantidad de kills");
							kills = Leer.datoInt();
							System.out.println("Diga la cantidad de muertes");
							muertes = Leer.datoInt();
							listaJugsEqs.add(new Jugador(nombreJ, puntos, kills, muertes, nombreE));
							gj.addJugador(new Jugador(nombreJ, puntos, kills, muertes, nombreE));
							System.out.println("¿Desea agregar otro jugador? Pulse 1(Si) o 0(No)");
							opInt = Leer.datoInt();
						}
						System.out.println("Diga la cantidad de partidas ganadas");
						partidasGanadas = Leer.datoInt();
						ge.addEquipo(new Equipo(nombreE, new CRUDJugador(listaJugsEqs), partidasGanadas));
						ge.getCrudE().calcularPuntosTodosEquipos();
						mo.setGe(ge);
						mo.setGj(gj);
						break;
					case 2:
						System.out.println("Diga el nombre del jugador");
						nombreJ = Leer.dato();
						System.out.println("Diga los puntos");
						puntos = Leer.datoInt();
						System.out.println("Diga la cantidad de kills");
						kills = Leer.datoInt();
						System.out.println("Diga la cantidad de muertes");
						muertes = Leer.datoInt();
						gj.addJugador(new Jugador(nombreJ, puntos, kills, muertes, "Sin Equipo"));
						mo.setGj(gj);
						System.out.println("Jugador añadido correctamente");
						break;
					case 3:
						mo.mostrarTodosLosEquipos();
						break;
					case 4:
						System.out.println("Diga el equipo");
						nombreE= Leer.dato();
						mo.mostrarJugadoresEquipo(nombreE);
						break;
					case 5:
						mo.mostrarJugadoresPorKills();
						break;
					case 6:
						System.out.println("El KD es la relación Bajas/Muertes se calcular"
								+ " dividiendo el número de Kills entre el número de muertes de un jugador");
						System.out.println("---------------------------------");
						System.out.println("1. Mostrar todos los jugadores");
						System.out.println("2. Mostrar solo algunos jugadores");
						System.out.println("0. Volver al menú");
						System.out.println("---------------------------------");
						System.out.println("¿Qué desea hacer?");
						opInt = Leer.datoInt();
						switch(opInt) {
							case 1:
								mo.mostrarTodosJugadoresPorKD();
								break;
							case 2:
								System.out.println("Diga cuantos jugadores desea mostrar");
								limit = Leer.datoInt();
								mo.mostrarJugadoresPedidosPorKD(limit);
								break;
							case 0:
								System.out.println("Volviendo al menú");
								break;
							default:
								System.out.println("Error: el número introducido no corresponde a ninguna de las opciones");
							
						}
						break;
					case 7:
						System.out.println("---------------------------------");
						System.out.println("1. Mostrar todos los equipos");
						System.out.println("2. Mostrar solo algunos equipos");
						System.out.println("0. Volver al menú");
						System.out.println("---------------------------------");
						System.out.println("¿Qué desea hacer?");
						opInt = Leer.datoInt();
						switch(opInt) {
							case 1:
								mo.mostrarEquiposPorPuntos();
								break;
							case 2:
								System.out.println("Diga cuantos equipos desea mostrar");
								limit = Leer.datoInt();
								mo.mostrarAlgunosEquiposPorPuntos(limit);
								break;
							case 0:
								System.out.println("Volviendo al menú");
								break;
							default:
								System.out.println("Error: el número introducido no corresponde a ninguna de las opciones");
							
						}
						break;
					case 8:
						System.out.println("Indique la posición ordenado por kills que ocupa el jugador en el equipo");
						System.out.println("Por ejemplo si usted desea el jugador con más kills de cada equipo pulse 1");
						limit = Leer.datoInt();
						mo.mostrarJugadorConKillsPorEquipo(limit);
						break;
					case 9:
						System.out.println("Cuando un equipo gana una partida se suman 10 ptos a cada jugador");
						System.out.println("Diga el nombre del equipo que ha ganado la partida");
						nombreE = Leer.dato();
						mo.mostrarEquipoPuntosSumados(nombreE);
						break;
					case 0:
						System.out.println("Gracias por usar el programa");
						break;
					default:
						System.out.println("Error: Número no perteneciente");
				}
			}catch(NumberFormatException e) {
				System.err.println("Error: Ha introducido un valor incorrecto");
			}catch(ArrayIndexOutOfBoundsException e){
				System.err.println("Error: Equipo inexistente");
			}catch(Exception e) {
				System.err.println("Error: Error desconocido, estamos trabajando en ello en estos momentos");
			}
		}while(op != 0);
	}
	public static void menu() {
		System.out.println("------------------------MENÚ------------------------");
		System.out.println("1. Agregar Equipo");
		System.out.println("2. Agregar Jugador sin Equipo");
		System.out.println("3. Mostrar todos los Equipos");
		System.out.println("4. Mostrar todos los Jugadores de un equipo");
		System.out.println("5. Mostrar todos los Jugadores por cantidad de Kills");
		System.out.println("6. Mostrar Jugadores por KD");
		System.out.println("7. Mostrar Equipos por puntos");
		System.out.println("8. Mostrar Jugadores por kills y según el equipo");
		System.out.println("9. Sumar puntos a jugadores por partida ganada");
		System.out.println("0. Salir");
		System.out.println("----------------------------------------------------");
		System.out.println("¿Qué desea hacer?");
	}
}
