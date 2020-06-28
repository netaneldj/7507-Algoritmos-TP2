package ObjetosChat;

import java.util.ArrayList;

import Excepciones.PosicionInvalida;

public class ListaDesdeUno extends ArrayList {
	
	public Object get(int pos){
		if(pos<1){
			throw new PosicionInvalida();
		}
		return super.get(pos-1);
	}

}
