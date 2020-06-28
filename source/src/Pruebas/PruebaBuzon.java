package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import ObjetosChat.Buzon;
import ObjetosChat.Mensaje;

public class PruebaBuzon {
	
	@Test
	public void test01ArchivarMensajesCantidadMensajes(){
		
		Buzon miBuzon = new Buzon();
		
		Mensaje mensaje1 = new Mensaje("Netanel","Eliel","Hola");
		Mensaje mensaje2 = new Mensaje("Eliel","Netanel","¿Como estas?");
		Mensaje mensaje3 = new Mensaje("Ilanit","Eliel",":(");
		
		assertEquals(miBuzon.cantiadTotalMensajes(),0);
		
		miBuzon.archivarMensaje(mensaje1);
		
		assertEquals(miBuzon.cantiadTotalMensajes(),1);
		
		miBuzon.archivarMensaje(mensaje2);
		miBuzon.archivarMensaje(mensaje3);
		
		assertEquals(miBuzon.cantiadTotalMensajes(),3);
	}
	
	@Test
	public void test02CantidadMensajesDe(){
		
		Buzon miBuzon = new Buzon();
		
		Mensaje mensaje1 = new Mensaje("Netanel","Eliel","Hola");
		Mensaje mensaje2 = new Mensaje("Eliel","Netanel","¿Como estas?");
		Mensaje mensaje3 = new Mensaje("Ilanit","Eliel",":(");
		Mensaje mensaje4 = new Mensaje("Netanel","Ilanit","Chau");
		Mensaje mensaje5 = new Mensaje("Eliel","Ilanit",";)");
		
		assertEquals(miBuzon.cantidadMensajesDe("Netanel"),0);
		assertEquals(miBuzon.cantidadMensajesDe("Ilanit"),0);
		assertEquals(miBuzon.cantidadMensajesDe("Eliel"),0);
		
		miBuzon.archivarMensaje(mensaje1);
		miBuzon.archivarMensaje(mensaje2);
		miBuzon.archivarMensaje(mensaje3);
		
		assertEquals(miBuzon.cantidadMensajesDe("Netanel"),1);
		assertEquals(miBuzon.cantidadMensajesDe("Ilanit"),1);
		assertEquals(miBuzon.cantidadMensajesDe("Eliel"),1);
		
		miBuzon.archivarMensaje(mensaje4);
		miBuzon.archivarMensaje(mensaje5);
		
		assertEquals(miBuzon.cantidadMensajesDe("Netanel"),2);
		assertEquals(miBuzon.cantidadMensajesDe("Ilanit"),1);
		assertEquals(miBuzon.cantidadMensajesDe("Eliel"),2);
		
	}
	
	@Test
	public void test03CantidadMensajesA(){
		
		Buzon miBuzon = new Buzon();
		
		Mensaje mensaje1 = new Mensaje("Netanel","Eliel","Hola");
		Mensaje mensaje2 = new Mensaje("Eliel","Netanel","¿Como estas?");
		Mensaje mensaje3 = new Mensaje("Ilanit","Eliel",":(");
		
		assertEquals(miBuzon.cantidadMensajesA("Netanel"),0);
		assertEquals(miBuzon.cantidadMensajesA("Ilanit"),0);
		assertEquals(miBuzon.cantidadMensajesA("Eliel"),0);
		
		miBuzon.archivarMensaje(mensaje1);
		
		assertEquals(miBuzon.cantidadMensajesA("Netanel"),0);
		assertEquals(miBuzon.cantidadMensajesA("Ilanit"),0);
		assertEquals(miBuzon.cantidadMensajesA("Eliel"),1);
		
		miBuzon.archivarMensaje(mensaje2);
		miBuzon.archivarMensaje(mensaje3);
		
		assertEquals(miBuzon.cantidadMensajesA("Netanel"),1);
		assertEquals(miBuzon.cantidadMensajesA("Ilanit"),0);
		assertEquals(miBuzon.cantidadMensajesA("Eliel"),2);
	}
	
	@Test
	public void test04BorrarMensajesDelContacto(){
		
		Buzon miBuzon = new Buzon();
		
		Mensaje mensaje1 = new Mensaje("Netanel","Eliel","Hola");
		Mensaje mensaje2 = new Mensaje("Eliel","Netanel","¿Como estas?");
		Mensaje mensaje3 = new Mensaje("Ilanit","Eliel",":(");
		
		miBuzon.archivarMensaje(mensaje1);
		miBuzon.archivarMensaje(mensaje2);
		miBuzon.archivarMensaje(mensaje3);
		
		assertEquals(miBuzon.cantiadTotalMensajes(),3);
		
		miBuzon.borrarMensajesDelContacto("Juan");
		
		assertEquals(miBuzon.cantiadTotalMensajes(),3);
		
		miBuzon.borrarMensajesDelContacto("Eliel");
		
		assertEquals(miBuzon.cantiadTotalMensajes(),0);


	}
	
	@Test
	public void test05BorrarTodosLosMensajes(){
		
		Buzon miBuzon = new Buzon();
		
		Mensaje mensaje1 = new Mensaje("Netanel","Eliel","Hola");
		Mensaje mensaje2 = new Mensaje("Eliel","Netanel","¿Como estas?");
		Mensaje mensaje3 = new Mensaje("Ilanit","Eliel",":(");
		
		miBuzon.archivarMensaje(mensaje1);
		miBuzon.archivarMensaje(mensaje2);
		miBuzon.archivarMensaje(mensaje3);
		
		assertEquals(miBuzon.cantiadTotalMensajes(),3);
		
		miBuzon.borrarTodosLosMensajes();
		
		assertEquals(miBuzon.cantiadTotalMensajes(),0);


	}
}
