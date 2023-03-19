package ejemplo;

import java.util.Comparator;

public class CompararPorKD implements Comparator<Jugador>{

	@Override
	public int compare(Jugador o1, Jugador o2) {
		if(o1.calcularKd()>o2.calcularKd()) {
			return -1;
		}else {
			if(o1.calcularKd() < o2.calcularKd()) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}

}
