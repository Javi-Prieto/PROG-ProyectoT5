package ejemplo;

public class Jugador {
	//Fields
	private String nombre;
	private int cantPuntosIndv, cantidadKillsTotal;
	//Constructor
	public Jugador(String nombre, int cantPuntosIndv, int cantidadKillsTotal) {
		super();
		this.nombre = nombre;
		this.cantPuntosIndv = cantPuntosIndv;
		this.cantidadKillsTotal = cantidadKillsTotal;
	}
	//Getter and setter
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
	
}
