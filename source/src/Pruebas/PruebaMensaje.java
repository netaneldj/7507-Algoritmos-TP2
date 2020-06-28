package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import ObjetosChat.Mensaje;

public class PruebaMensaje {
	 @Test
	 public void test01CrearMensaje(){
		 
		 String emisor = new String("Netanel");
		 String receptor = new String("Eliel");
		 String contenido = new String("Hola");
		 
		 Mensaje miMensaje = new Mensaje(emisor,receptor,contenido);
		 
		 assertEquals(miMensaje.verEmisor(),emisor);
		 assertEquals(miMensaje.verReceptor(),receptor);
		 assertEquals(miMensaje.verContenido(),contenido);
		 
	 }
}
