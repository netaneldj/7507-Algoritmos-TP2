package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import ObjetosChat.Agenda;
import ObjetosChat.Contacto;

public class PruebaAgenda {
	
	 @Test
	 public void test01AgregarContactoCantidad(){
		 
		 	Agenda miAgenda = new Agenda();
		 	assertEquals(miAgenda.cantidadDeContactos(),0);
		 	
		 	Contacto Netanel = new Contacto("Netanel");
		 	miAgenda.agregarContacto(Netanel);
		 	assertEquals(miAgenda.cantidadDeContactos(),1);
		 	
		 	Contacto Ilanit = new Contacto("Ilanit");
		 	Contacto Eliel = new Contacto("Eliel");
		 	miAgenda.agregarContacto(Ilanit);
		 	miAgenda.agregarContacto(Eliel);
		 	assertEquals(miAgenda.cantidadDeContactos(),3);
	 }
	 
	 @Test
	 public void test02ExisteContacto(){
		 
		 Agenda miAgenda = new Agenda();
		 
		 assertFalse(miAgenda.existeContacto("Netanel"));
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 miAgenda.agregarContacto(Netanel);
		 miAgenda.agregarContacto(Ilanit);
		 miAgenda.agregarContacto(Eliel);
		 
		 assertTrue(miAgenda.existeContacto("Netanel"));
		 assertFalse(miAgenda.existeContacto("Pepe"));
	 }

}
