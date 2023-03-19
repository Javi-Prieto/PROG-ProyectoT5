package ejemplo;

import java.util.Comparator;

public class CompararPorCantPuntosEquipo implements Comparator<Equipo>{

	@Override
	public int compare(Equipo o1, Equipo o2) {
		if(o1.getCantidadPuntos() > o2.getCantidadPuntos()) {
			return -1;
		}else {
			if(o1.getCantidadPuntos() < o2.getCantidadPuntos()) {
				return 1;
			}
			else{
				return 0;
			}
		}
	}

}
