package ejemplo;

public class Jugador implements Comparable<Jugador>{
	//Fields
	private String nombre, nombreEquipo;
	private int cantPuntosIndv, cantidadKillsTotal, cantMuertesTotal;
	//Constructor
	public Jugador(String nombre, int cantPuntosIndv, int cantidadKillsTotal, int cantMuertesTotal, String nombreEquipo) {
		super();
		this.nombre = nombre;
		this.cantPuntosIndv = cantPuntosIndv;
		this.cantidadKillsTotal = cantidadKillsTotal;
		this.cantMuertesTotal = cantMuertesTotal;
		this.nombreEquipo = nombreEquipo;
	}
	
	

	//Getter and setter
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public int getCantMuertesTotal() {
		return cantMuertesTotal;
	}
	public void setCantMuertesTotal(int cantMuertesTotal) {
		this.cantMuertesTotal = cantMuertesTotal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantPuntosIndv() {
		return cantPuntosIndv;
	}
	public void setCantPuntosIndv(int cantPuntosIndv) {
		this.cantPuntosIndv = cantPuntosIndv;
	}
	public int getCantidadKillsTotal() {
		return cantidadKillsTotal;
	}
	public void setCantidadKillsTotal(int cantidadKillsTotal) {
		this.cantidadKillsTotal = cantidadKillsTotal;
	}
	//toString
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", cantPuntosIndv=" + cantPuntosIndv + ", cantidadKillsTotal="
				+ cantidadKillsTotal + "]";
	}
	@Override
	public int compareTo(Jugador o) {
		if(this.cantidadKillsTotal > o.cantidadKillsTotal) {
			return -1;
		}else {
			if(o.cantidadKillsTotal > this.cantidadKillsTotal) {
				return 1;
			}else {
				return 0;
			}
		}
	}
	public double calcularKd() {
		return (double)this.cantidadKillsTotal/(double)this.cantMuertesTotal;
	}
}
