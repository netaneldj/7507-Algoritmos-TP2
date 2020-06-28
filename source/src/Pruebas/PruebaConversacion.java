package Pruebas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ObjetosChat.Conversacion;

public class PruebaConversacion {
	
	@Test
	public void test01ConversoCon(){
		
		String persona = new String("Eliel");
		Conversacion miConversacion = new Conversacion(persona);
		
		assertEquals(miConversacion.conversoCon(),persona);
	}
	
	@Test
	public void test02AgregarMensajesObtenerConversacion(){
		
		String persona = new String("Eliel");
		Conversacion miConversacion = new Conversacion(persona);
		
		miConversacion.agregarMensaje("Netanel", "Hola, como estas?");
		miConversacion.agregarMensaje("Eliel","Muy bien, vos?");
		miConversacion.agregarMensaje("Netanel","Vamos a Europa?");
		miConversacion.agregarMensaje("Eliel",";)");
		
		List conversacion = miConversacion.obtenerConversacion();
		
		assertEquals(conversacion.get(1),"Eliel: ;)");
		assertEquals(conversacion.get(4),"Netanel: Hola, como estas?");
	}
}
