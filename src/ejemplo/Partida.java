package ejemplo;

import java.util.Map;

public class Partida {
	//Fields
	private Equipo e1, e2;
	private Map <Jugador, Double> cantKillsPorJugador, cantMuertesPorJugador, cantAsisPorJugador;
	private Map <Jugador, Integer> puntosPorEquipo;
	private String mapa;
	//Constructor
	public Partida(Equipo e1, Equipo e2, Map<Jugador, Double> cantKillsPorJugador,
			Map<Jugador, Double> cantMuertesPorJugador, Map<Jugador, Double> cantAsisPorJugador,
			Map<Jugador, Integer> puntosPorEquipo, String mapa) {
		super();
		this.e1 = e1;
		this.e2 = e2;
		this.cantKillsPorJugador = cantKillsPorJugador;
		this.cantMuertesPorJugador = cantMuertesPorJugador;
		this.cantAsisPorJugador = cantAsisPorJugador;
		this.puntosPorEquipo = puntosPorEquipo;
		this.mapa = mapa;
	}
	//Getter and Setter
	public Equipo getE1() {
		return e1;
	}
	public void setE1(Equipo e1) {
		this.e1 = e1;
	}
	public Equipo getE2() {
		return e2;
	}
	public void setE2(Equipo e2) {
		this.e2 = e2;
	}
	public Map<Jugador, Double> getCantKillsPorJugador() {
		return cantKillsPorJugador;
	}
	public void setCantKillsPorJugador(Map<Jugador, Double> cantKillsPorJugador) {
		this.cantKillsPorJugador = cantKillsPorJugador;
	}
	public Map<Jugador, Double> getCantMuertesPorJugador() {
		return cantMuertesPorJugador;
	}
	public void setCantMuertesPorJugador(Map<Jugador, Double> cantMuertesPorJugador) {
		this.cantMuertesPorJugador = cantMuertesPorJugador;
	}
	public Map<Jugador, Double> getCantAsisPorJugador() {
		return cantAsisPorJugador;
	}
	public void setCantAsisPorJugador(Map<Jugador, Double> cantAsisPorJugador) {
		this.cantAsisPorJugador = cantAsisPorJugador;
	}
	public Map<Jugador, Integer> getPuntosPorEquipo() {
		return puntosPorEquipo;
	}
	public void setPuntosPorEquipo(Map<Jugador, Integer> puntosPorEquipo) {
		this.puntosPorEquipo = puntosPorEquipo;
	}
	public String getMapa() {
		return mapa;
	}
	public void setMapa(String mapa) {
		this.mapa = mapa;
	}
	//toString
	@Override
	public String toString() {
		return "Partida [e1=" + e1 + ", e2=" + e2 + ", cantKillsPorJugador=" + cantKillsPorJugador
				+ ", cantMuertesPorJugador=" + cantMuertesPorJugador + ", cantAsisPorJugador=" + cantAsisPorJugador
				+ ", puntosPorEquipo=" + puntosPorEquipo + ", mapa=" + mapa + "]";
	}
	
}
