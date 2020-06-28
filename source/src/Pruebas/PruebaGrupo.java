package Pruebas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ObjetosChat.Grupo;
import ObjetosChat.Mensaje;

public class PruebaGrupo {
	
	@Test
	public void test01CantidadMiembros(){
		
		Grupo miGrupo = new Grupo("Los mejores","Netanel");
		assertEquals(miGrupo.cantidadMiembrosEnGrupo(),1);
		
		miGrupo.agregarMiembro("Ilanit");
		miGrupo.agregarMiembro("Eliel");
		assertEquals(miGrupo.cantidadMiembrosEnGrupo(),3);
	}
	
	@Test
	public void test02RecibirMensajeCantidad(){
		
		Grupo miGrupo = new Grupo("Los mejores","Netanel");
		assertEquals(miGrupo.cantidadMensajesRecibidos(),0);
		
		Mensaje mensaje1 = new Mensaje("Eliel","Los mejores","Holaaa ;)");
		miGrupo.recibirMensaje(mensaje1);
		
		Mensaje mensaje2 = new Mensaje("Ilait","Los mejores","Ilanit ha abandonado el grupo...");
		miGrupo.recibirMensaje(mensaje2);
		
		assertEquals(miGrupo.cantidadMensajesRecibidos(),2);
	}
	
	@Test
	public void test03EnviarMensajeCantidad(){
		
		Grupo miGrupo = new Grupo("Los mejores","Netanel");
		assertEquals(miGrupo.cantidadMensajesEnviados(),0);
		
		Mensaje mensaje1 = new Mensaje("Yo","Los mejores","Hola a todos!!!");
		miGrupo.enviarMensaje(mensaje1);
		assertEquals(miGrupo.cantidadMensajesEnviados(),1);
	}
	
	@Test
	public void test04ObtenerConversacion(){
		
		Grupo miGrupo = new Grupo("Los mejores","Netanel");
		
		Mensaje mensaje1 = new Mensaje("Netanel","Los mejores","Hola a todos!");
		miGrupo.enviarMensaje(mensaje1);
		Mensaje mensaje2= new Mensaje("Ilanit","Los mejores","Hola,como estan?");
		miGrupo.recibirMensaje(mensaje2);
		Mensaje mensaje3 = new Mensaje("Eliel","Los mejores","Holaaa ;)");
		miGrupo.recibirMensaje(mensaje3);
		
		List conversacion = miGrupo.obtenerConversacion();
		
		assertEquals(conversacion.get(1),"Eliel: Holaaa ;)");
		assertEquals(conversacion.get(2),"Ilanit: Hola,como estan?");
		assertEquals(conversacion.get(3),"Yo: Hola a todos!");
	}
	
	@Test
	public void test05BorrarMensajes(){
		
		Grupo miGrupo = new Grupo("Los mejores","Netanel");
		assertEquals(miGrupo.cantidadMensajesEnviados(),0);
		assertEquals(miGrupo.cantidadMensajesRecibidos(),0);
		
		Mensaje mensaje1 = new Mensaje("Netanel","Los mejores","Hola a todos!");
		miGrupo.enviarMensaje(mensaje1);
		Mensaje mensaje2= new Mensaje("Ilanit","Los mejores","Hola,como estan?");
		miGrupo.recibirMensaje(mensaje2);
		Mensaje mensaje3 = new Mensaje("Eliel","Los mejores","Holaaa ;)");
		miGrupo.recibirMensaje(mensaje3);
		assertEquals(miGrupo.cantidadMensajesEnviados(),1);
		assertEquals(miGrupo.cantidadMensajesRecibidos(),2);
		
		miGrupo.borrarMensajes();
		assertEquals(miGrupo.cantidadMensajesEnviados(),0);
		assertEquals(miGrupo.cantidadMensajesRecibidos(),0);
	}

}
