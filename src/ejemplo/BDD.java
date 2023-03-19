package ejemplo;

import java.util.ArrayList;
import java.util.List;

public class BDD {
	public List<Jugador> devolverJugadoresHeretics(){
		List<Jugador> heretics = new ArrayList<Jugador>();
		heretics.add(new Jugador("Mixwell", 75, 30, 34, "Heretics"));
		heretics.add(new Jugador("Keloqz", 40, 38, 33, "Heretics"));
		heretics.add(new Jugador("Avova", 65, 20, 37, "Heretics"));
		heretics.add(new Jugador("Zeek", 101, 32, 32, "Heretics"));
		heretics.add(new Jugador("Boo", 19, 19, 29, "Heretics"));
		return heretics;
	}
	public List<Jugador> devolverJugadoresGiants(){
		List<Jugador> giants = new ArrayList<Jugador>();
		giants.add(new Jugador("Fit1nho", 13, 72, 69, "Giants"));
		giants.add(new Jugador("Hoody", 30, 61, 65, "Giants"));
		giants.add(new Jugador("Nukkye", 63, 68, 58, "Giants"));
		giants.add(new Jugador("Rhyme", 17, 47, 68, "Giants"));
		giants.add(new Jugador("Cloud", 16, 80, 66, "Giants"));
		return giants;
	}
	public List<Jugador> devolverJugadoresKarmine(){
		List<Jugador> karmine = new ArrayList<Jugador>();
		karmine.add(new Jugador("Scream", 83, 69, 75, "Karmine Corp"));
		karmine.add(new Jugador("Nivera", 45, 93, 70, "Karmine Corp"));
		karmine.add(new Jugador("Sh1n", 5, 98, 73, "Karmine Corp"));
		karmine.add(new Jugador("Newzera", 4, 55, 62, "Karmine Corp"));
		karmine.add(new Jugador("xms", 3, 56, 69, "Karmine Corp"));
		return karmine;
	}
	public List<Jugador> devolverJugadoresKOI(){
		List<Jugador> KOI = new ArrayList<Jugador>();
		KOI.add(new Jugador("Koldamenta", 50, 17, 34, "KOI"));
		KOI.add(new Jugador("Wolfen", 6, 28, 38, "KOI"));
		KOI.add(new Jugador("Trexx", 20, 46, 27, "KOI"));
		KOI.add(new Jugador("Starxo", 107, 17, 29, "KOI"));
		KOI.add(new Jugador("Sheydos", 110, 27, 24, "KOI"));
		return KOI;
	}
	public List<Jugador> devolverJugadoresNavi(){
		List<Jugador> navi = new ArrayList<Jugador>();
		navi.add(new Jugador("Cned", 121, 146, 125, "Navi"));
		navi.add(new Jugador("Suygetsu", 95, 125, 115, "Navi"));
		navi.add(new Jugador("Zyppan", 107, 133, 112, "Navi"));
		navi.add(new Jugador("Shao", 107, 140, 95, "Navi"));
		navi.add(new Jugador("Ange1", 107, 121, 112, "Navi"));
		return navi;
	}
	public List<Jugador> devolverJugadoresFnatic(){
		List<Jugador> fnatic = new ArrayList<Jugador>();
		fnatic.add(new Jugador("Derke", 102, 274, 220, "Fnatic"));
		fnatic.add(new Jugador("Alfajer", 60, 220, 191, "Fnatic"));
		fnatic.add(new Jugador("Leo", 50, 242, 175, "Fnatic"));
		fnatic.add(new Jugador("Boaster", 103, 193, 125, "Fnatic"));
		fnatic.add(new Jugador("Chronicle", 130, 210, 190, "Fnatic"));
		return fnatic;
	}
	
	public Equipo devolverHeretics() {
		return new Equipo("Heretics", new CRUDJugador(devolverJugadoresHeretics()), 1);
	}
	public Equipo devolverGiants() {
		return new Equipo("Giants", new CRUDJugador(devolverJugadoresGiants()), 3);
	}
	public Equipo devolverKarmine() {
		return new Equipo("Karmine Corp", new CRUDJugador(devolverJugadoresKarmine()), 2);
	}
	public Equipo devolverKOI() {
		return new Equipo("KOI", new CRUDJugador(devolverJugadoresKOI()), 2);
	}
	public Equipo devolverNavi() {
		return new Equipo("Navi", new CRUDJugador(devolverJugadoresNavi()), 4);
	}
	public Equipo devolverFnatic() {
		return new Equipo("Fnatic", new CRUDJugador(devolverJugadoresFnatic()), 5);
	}
}
