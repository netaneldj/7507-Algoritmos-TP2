package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import ObjetosChat.ListaDesdeUno;

public class PruebaListaDesdeUno {
	 @Test
	 public void test01posicionListaDesdeUno(){
		 
		 String pos3 = new String("Estoy en la posicion 3");
		 String pos2 = new String("Estoy en la posicion 2");
		 String pos1 = new String("Estoy en la posicion 1");
		 
		 ListaDesdeUno miLista = new ListaDesdeUno();
		 
		 miLista.add(pos1);
		 miLista.add(pos2);
		 miLista.add(pos3);
	
		 assertEquals(miLista.get(3),pos3);
		 assertEquals(miLista.get(2),pos2);
		 assertEquals(miLista.get(1),pos1);
	 }

}
