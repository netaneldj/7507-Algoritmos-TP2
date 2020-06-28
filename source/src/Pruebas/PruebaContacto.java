package Pruebas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ObjetosChat.Contacto;

public class PruebaContacto {
	
	 @Test
	 public void test01ContactoObtenerNombre(){
		 
		 String nombreContacto = new String("Netanel");
		 Contacto contacto = new Contacto(nombreContacto);
		 assertEquals(contacto.obtenerNombre(),nombreContacto);
	 }
	 
	 @Test
	 public void test02AgregarContactosCantidad(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 
		 assertEquals(Netanel.cantidadDeContactosEnAgenda(),0);
		 assertEquals(Ilanit.cantidadDeContactosEnAgenda(),0);
		 assertEquals(Eliel.cantidadDeContactosEnAgenda(),0);
		 assertEquals(Uriel.cantidadDeContactosEnAgenda(),0);
		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Netanel.agregarContactoAAgenda(Eliel);
		 Netanel.agregarContactoAAgenda(Uriel);
		 assertEquals(Netanel.cantidadDeContactosEnAgenda(),3);
		 
		 Ilanit.agregarContactoAAgenda(Netanel);
		 Ilanit.agregarContactoAAgenda(Uriel);
		 assertEquals(Ilanit.cantidadDeContactosEnAgenda(),2);
		 
		 Uriel.agregarContactoAAgenda(Netanel);
		 assertEquals(Uriel.cantidadDeContactosEnAgenda(),1);
		 
		 assertEquals(Eliel.cantidadDeContactosEnAgenda(),0);
	 }
	 
	 @Test
	 public void test03ExisteContacto(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 
		 assertFalse(Netanel.existeContactoEnAgenda("Eliel"));
		 assertFalse(Ilanit.existeContactoEnAgenda("Netanel"));
		 
		 Netanel.agregarContactoAAgenda(Eliel);
		 assertTrue(Netanel.existeContactoEnAgenda("Eliel"));
		 
		 Ilanit.agregarContactoAAgenda(Netanel);
		 assertTrue(Ilanit.existeContactoEnAgenda("Netanel"));
	 }
	 
	 @Test
	 public void test04RecibirMensajesCantidad(){
		
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Ilanit.agregarContactoAAgenda(Netanel);
		 Eliel.agregarContactoAAgenda(Netanel);
		 Uriel.agregarContactoAAgenda(Eliel);
		 
		 assertEquals(Netanel.cantidadDeMensajesRecibidos(),0);
		 assertEquals(Ilanit.cantidadDeMensajesRecibidos(),0);
		 assertEquals(Eliel.cantidadDeMensajesRecibidos(),0);
		 assertEquals(Uriel.cantidadDeMensajesRecibidos(),0);
		 
		 Netanel.recibirMensajeDe("Ilanit","Hola :)");
		 Ilanit.recibirMensajeDe("Netanel","Hello, is it me you looking for?");
		 Eliel.recibirMensajeDe("Netanel","Tell me how to win your heart because I have not got a clue");
		 Uriel.recibirMensajeDe("Eliel","You are all I ever wanted and my arms are open wide");
		 Netanel.recibirMensajeDe("Ilanit","Are you somewhere feeling lonely or someone loving you?");
		 
		 assertEquals(Netanel.cantidadDeMensajesRecibidos(),2);
		 assertEquals(Ilanit.cantidadDeMensajesRecibidos(),1);
		 assertEquals(Eliel.cantidadDeMensajesRecibidos(),1);
		 assertEquals(Uriel.cantidadDeMensajesRecibidos(),1);
	 }
	 
	 @Test
	 public void test05CantidadMensajesDe(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 Contacto Eitan = new Contacto("Eitan");
		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Netanel.agregarContactoAAgenda(Eliel);
		 Netanel.agregarContactoAAgenda(Uriel);
		 Netanel.agregarContactoAAgenda(Eitan);
		 
		 assertEquals(Netanel.cantidadMensajesDe("Ilanit"),0);
		 assertEquals(Netanel.cantidadMensajesDe("Eliel"),0);
		 assertEquals(Netanel.cantidadMensajesDe("Uriel"),0);
		 
		 Netanel.recibirMensajeDe("Ilanit","Hola :)");
		 Netanel.recibirMensajeDe("Eliel","Hello, is it me you looking for?");
		 Netanel.recibirMensajeDe("Uriel","Tell me how to win your heart because I have not got a clue");
		 Netanel.recibirMensajeDe("Eliel","You are all I ever wanted and my arms are open wide");
		 Netanel.recibirMensajeDe("Ilanit","Are you somewhere feeling lonely or someone loving you?");
		 
		 assertEquals(Netanel.cantidadMensajesDe("Ilanit"),2);
		 assertEquals(Netanel.cantidadMensajesDe("Eliel"),2);
		 assertEquals(Netanel.cantidadMensajesDe("Uriel"),1);
		 assertEquals(Netanel.cantidadMensajesDe("Eitan"),0);
	 }
	 
	 @Test
	 public void test06EnviarMensajeCantidad(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Ilanit.agregarContactoAAgenda(Netanel);
		 Eliel.agregarContactoAAgenda(Netanel);
		 Uriel.agregarContactoAAgenda(Eliel);
		 
		 assertEquals(Netanel.cantidadDeMensajesEnviados(),0);
		 assertEquals(Ilanit.cantidadDeMensajesEnviados(),0);
		 assertEquals(Eliel.cantidadDeMensajesEnviados(),0);
		 assertEquals(Uriel.cantidadDeMensajesEnviados(),0);
		 
		 Netanel.enviarMensajeA("Ilanit","Hola :)");
		 Ilanit.enviarMensajeA("Netanel","Hello, is it me you looking for?");
		 Eliel.enviarMensajeA("Netanel","Tell me how to win your heart because I have not got a clue");
		 Uriel.enviarMensajeA("Eliel","You are all I ever wanted and my arms are open wide");
		 Netanel.enviarMensajeA("Ilanit","Are you somewhere feeling lonely or someone loving you?");
		 
		 assertEquals(Netanel.cantidadDeMensajesEnviados(),2);
		 assertEquals(Ilanit.cantidadDeMensajesEnviados(),1);
		 assertEquals(Eliel.cantidadDeMensajesEnviados(),1);
		 assertEquals(Uriel.cantidadDeMensajesEnviados(),1);
	 }
	 
	 @Test
	 public void test07CantidadMensajesA(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 Contacto Eitan = new Contacto("Eitan");
		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Netanel.agregarContactoAAgenda(Eliel);
		 Netanel.agregarContactoAAgenda(Uriel);
		 Netanel.agregarContactoAAgenda(Eitan);
		 
		 assertEquals(Netanel.cantidadMensajesEnviadosA("Ilanit"),0);
		 assertEquals(Netanel.cantidadMensajesEnviadosA("Eliel"),0);
		 assertEquals(Netanel.cantidadMensajesEnviadosA("Uriel"),0);
		 
		 Netanel.enviarMensajeA("Ilanit","Hola :)");
		 Netanel.enviarMensajeA("Eliel","Hello, is it me you looking for?");
		 Netanel.enviarMensajeA("Uriel","Tell me how to win your heart because I have not got a clue");
		 Netanel.enviarMensajeA("Eliel","You are all I ever wanted and my arms are open wide");
		 Netanel.enviarMensajeA("Ilanit","Are you somewhere feeling lonely or someone loving you?");
		 
		 assertEquals(Netanel.cantidadMensajesEnviadosA("Ilanit"),2);
		 assertEquals(Netanel.cantidadMensajesEnviadosA("Eliel"),2);
		 assertEquals(Netanel.cantidadMensajesEnviadosA("Uriel"),1);
		 assertEquals(Netanel.cantidadMensajesEnviadosA("Eitan"),0);
	 }
	 
	 @Test
	 public void test08CantidadChatsIndividuales(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 
		 assertEquals(Netanel.cantidadDeChatsIndividuales(),0);
		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Netanel.agregarContactoAAgenda(Eliel);
		 Netanel.agregarContactoAAgenda(Uriel);
		 
		 Netanel.enviarMensajeA("Ilanit","Hola :)");
		 Netanel.recibirMensajeDe("Ilanit","Hello, is it me you looking for?");
		 Netanel.enviarMensajeA("Ilanit","Tell me how to win your heart because I have not got a clue");
		 Netanel.enviarMensajeA("Eliel","You are all I ever wanted and my arms are open wide");
		 Netanel.enviarMensajeA("Uriel","Are you somewhere feeling lonely or someone loving you?");
		 
		 assertEquals(Netanel.cantidadDeChatsIndividuales(),3); 
	 }
	 
	 @Test
	 public void test09ConversersacionCon(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Netanel.agregarContactoAAgenda(Eliel);
		 Netanel.agregarContactoAAgenda(Uriel);
		 
		 Netanel.enviarMensajeA("Ilanit","Hola :)");
		 Netanel.recibirMensajeDe("Ilanit","Hello, is it me you looking for?");
		 Netanel.enviarMensajeA("Ilanit","Tell me how to win your heart because I have not got a clue");
		 Netanel.enviarMensajeA("Eliel","You are all I ever wanted and my arms are open wide");
		 Netanel.enviarMensajeA("Uriel","Are you somewhere feeling lonely or someone loving you?");
		 
		 List conversacionConIlanit = Netanel.obtenerConversacionCon("Ilanit");
		 List conversacionConEliel = Netanel.obtenerConversacionCon("Eliel");
		 List conversacionConUriel = Netanel.obtenerConversacionCon("Uriel");
		 
		 assertEquals(conversacionConIlanit.get(1),"Yo: Tell me how to win your heart because I have not got a clue");
		 assertEquals(conversacionConEliel.get(1),"Yo: You are all I ever wanted and my arms are open wide");
		 assertEquals(conversacionConUriel.get(1),"Yo: Are you somewhere feeling lonely or someone loving you?");
		 
	 }
	 
	 @Test
	 public void test10CrearGrupoCantidad(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 assertEquals(Netanel.cantidadDeGrupos(),0);
		 
		 Netanel.crearGrupo("Los mejores");
		 Netanel.crearGrupo("Hello");
		 assertEquals(Netanel.cantidadDeGrupos(),2);
	 }
	 
	 @Test
	 public void test10AgregarContactoCantidadMiembros(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Netanel.agregarContactoAAgenda(Eliel);
		 Netanel.agregarContactoAAgenda(Uriel);
		 
		 Netanel.crearGrupo("Hello");
		 assertEquals(Netanel.cantidadMiembrosEnGrupo("Hello"),1);
		 Netanel.agregarContactoAGrupo(Ilanit.obtenerNombre(),"Hello");
		 Netanel.agregarContactoAGrupo(Eliel.obtenerNombre(),"Hello");
		 Netanel.agregarContactoAGrupo(Uriel.obtenerNombre(),"Hello");
		 assertEquals(Netanel.cantidadMiembrosEnGrupo("Hello"),4);
		 
		 Netanel.crearGrupo("Los mejores");
		 assertEquals(Netanel.cantidadMiembrosEnGrupo("Los mejores"),1);
	 }
	 
	 @Test
	 public void test11ExisteGrupo(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 assertFalse(Netanel.existeGrupo("Hello"));
		 
		 Netanel.crearGrupo("Hello");
		 assertTrue(Netanel.existeGrupo("Hello"));
		 assertFalse(Netanel.existeGrupo("Los mejores"));
	 }
	 
	 @Test
	 public void test12RecibirMensajeDeGrupoCantidad(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Netanel.agregarContactoAAgenda(Eliel);
		 Netanel.agregarContactoAAgenda(Uriel);
		 
		 Netanel.crearGrupo("Hello");
		 assertEquals(Netanel.cantidadMensajesRecibidosDelGrupo("Hello"),0);
		 
		 Netanel.recibirMensajeDeGrupo("Hello", Ilanit.obtenerNombre(),"Hello, is it me you looking for?");
		 Netanel.recibirMensajeDeGrupo("Hello",Eliel.obtenerNombre(),"Tell me how to win your heart for I have not got a clue");
		 Netanel.recibirMensajeDeGrupo("Hello",Uriel.obtenerNombre(),"Are your somewhere feeling lonely or someone loving you?");
		 assertEquals(Netanel.cantidadMensajesRecibidosDelGrupo("Hello"),3);
	 }
	 
	 @Test
	 public void test13EnviarMensajeAGrupoCantidad(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Netanel.agregarContactoAAgenda(Eliel);
		 Netanel.agregarContactoAAgenda(Uriel);
		 
		 Netanel.crearGrupo("Hello");
		 assertEquals(Netanel.cantidadMensajesEnviadosAlGrupo("Hello"),0);
		 
		 Netanel.enviarMensajeAGrupo("Hello","Hello, is it me you looking for?");
		 Netanel.enviarMensajeAGrupo("Hello","Tell me how to win your heart for I have not got a clue");
		 Netanel.enviarMensajeAGrupo("Hello","Are your somewhere feeling lonely or someone loving you?");
		 assertEquals(Netanel.cantidadMensajesEnviadosAlGrupo("Hello"),3);
	 }
	 
	 @Test
	 public void test14ObtenerConversacionConGrupo(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Netanel.agregarContactoAAgenda(Eliel);
		 Netanel.agregarContactoAAgenda(Uriel);
		 
		 Netanel.crearGrupo("Hello");
		 
		 Netanel.enviarMensajeAGrupo("Hello","Hello, is it me you looking for?");
		 Netanel.recibirMensajeDeGrupo("Hello",Ilanit.obtenerNombre(),"Tell me how to win your heart for I have not got a clue");
		 Netanel.recibirMensajeDeGrupo("Hello",Eliel.obtenerNombre(),"Are your somewhere feeling lonely or someone loving you?");
		 Netanel.recibirMensajeDeGrupo("Hello",Uriel.obtenerNombre(),"I can see it in your eyes, I can see it in your smile");
		 Netanel.enviarMensajeAGrupo("Hello","You are all I ever wanted and my arms are opened wide");
		 
		 List conversacionHello = Netanel.obtenerConversacionConGrupo("Hello");
		 
		 assertEquals(conversacionHello.get(1),"Yo: You are all I ever wanted and my arms are opened wide");
		 assertEquals(conversacionHello.get(3),"Eliel: Are your somewhere feeling lonely or someone loving you?");
	 }
	 
	 @Test
	 public void test15CantidadChatsGrupales(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Netanel.agregarContactoAAgenda(Eliel);
		 Netanel.agregarContactoAAgenda(Uriel);
		 
		 assertEquals(Netanel.cantidadDeChatsGrupales(),0);

		 Netanel.crearGrupo("Hello");
		 Netanel.crearGrupo("How would your feel");
		 
		 Netanel.agregarContactoAGrupo(Ilanit.obtenerNombre(),"Hello");
		 Netanel.agregarContactoAGrupo(Eliel.obtenerNombre(),"Hello");
		 Netanel.agregarContactoAGrupo(Uriel.obtenerNombre(),"Hello");
		 
		 Netanel.agregarContactoAGrupo(Ilanit.obtenerNombre(),"How would your feel");
		 
		 assertEquals(Netanel.cantidadDeChatsGrupales(),2);
	 }
	 
	 @Test
	 public void test16BorrrarMensajesDelContacto(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Netanel.agregarContactoAAgenda(Eliel);
		 Netanel.agregarContactoAAgenda(Uriel);
		 
		 Netanel.enviarMensajeA(Eliel.obtenerNombre(),"Tell me how to win your heart for I have not got a clue!");
		 Netanel.recibirMensajeDe(Eliel.obtenerNombre(),"I sometimes see you pass outside my door...");
		 Netanel.recibirMensajeDe(Ilanit.obtenerNombre(),"Are you someone feeling lonely or someome loving you?");
		 Netanel.enviarMensajeA(Uriel.obtenerNombre(),"I wanna be drunk when i wake up!");
		 
		 assertEquals(Netanel.cantidadDeMensajesEnviados(),2);
		 assertEquals(Netanel.cantidadDeMensajesRecibidos(),2);
		 
		 Netanel.borrarMensajesDelContacto(Eliel.obtenerNombre());
		 
		 assertEquals(Netanel.cantidadDeMensajesEnviados(),1);
		 assertEquals(Netanel.cantidadDeMensajesRecibidos(),1);
	 }
	 
	 @Test
	 public void test17BorrarMensajesDelGrupo(){
		 
		 Contacto Netanel = new Contacto("Netanel");
		 Contacto Ilanit = new Contacto("Ilanit");
		 Contacto Eliel = new Contacto("Eliel");
		 Contacto Uriel = new Contacto("Uriel");
		 
		 Netanel.agregarContactoAAgenda(Ilanit);
		 Netanel.agregarContactoAAgenda(Eliel);
		 Netanel.agregarContactoAAgenda(Uriel);
		 
		 Netanel.crearGrupo("Hello");
		 
		 assertEquals(Netanel.cantidadMensajesEnviadosAlGrupo("Hello"),0);
		 assertEquals(Netanel.cantidadMensajesRecibidosDelGrupo("Hello"),0);
		 
		 Netanel.enviarMensajeAGrupo("Hello","Hello, is it me you looking for?");
		 Netanel.recibirMensajeDeGrupo("Hello",Ilanit.obtenerNombre(),"Tell me how to win your heart for I have not got a clue");
		 Netanel.recibirMensajeDeGrupo("Hello",Eliel.obtenerNombre(),"Are your somewhere feeling lonely or someone loving you?");
		 Netanel.recibirMensajeDeGrupo("Hello",Uriel.obtenerNombre(),"I can see it in your eyes, I can see it in your smile");
		 Netanel.enviarMensajeAGrupo("Hello","You are all I ever wanted and my arms are opened wide");
		 
		 assertEquals(Netanel.cantidadMensajesEnviadosAlGrupo("Hello"),2);
		 assertEquals(Netanel.cantidadMensajesRecibidosDelGrupo("Hello"),3);
		 
		 Netanel.borrarMensajesDelGrupo("Hello");
		 
		 assertEquals(Netanel.cantidadMensajesEnviadosAlGrupo("Hello"),0);
		 assertEquals(Netanel.cantidadMensajesRecibidosDelGrupo("Hello"),0);
	 }
}
