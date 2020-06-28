package Pruebas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ObjetosChat.ChatGrupal;

public class PruebaChatGrupal {
	
	@Test
	public void test01AgregarMensajeObtenerConversacion(){
		
		ChatGrupal miChat = new ChatGrupal("Los mejores");
		
		miChat.agregarMensaje("Netanel","Hola, como estan?");
		miChat.agregarMensaje("Ilanit","Bien");
		miChat.agregarMensaje("Eliel","Muuy bieen ;)");
		
		List conversacionGrupal = miChat.obtenerConversacion();
		
		assertEquals(conversacionGrupal.get(1),"Eliel: Muuy bieen ;)");
		assertEquals(conversacionGrupal.get(3),"Netanel: Hola, como estan?");
		
	}
}
