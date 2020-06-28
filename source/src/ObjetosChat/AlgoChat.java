package ObjetosChat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgoChat {
	
	private Contacto miUsuario;
	
	public AlgoChat(String nombreUsuario){
		this.miUsuario = new Contacto(nombreUsuario); 
	}
	
	public int cantidadDeChatsIndividuales(){
		return miUsuario.cantidadDeChatsIndividuales();
	}
	
	public int cantidadDeContactos(){
		return this.miUsuario.cantidadDeContactosEnAgenda();
	}
	
	public int cantidadDeChatsGrupales(){
		return miUsuario.cantidadDeChatsGrupales();
	}
	
	public int cantidadDeGrupos(){
		return miUsuario.cantidadDeGrupos();
	}
	
	public int cantidadDeMensajesEnviados(){
		return miUsuario.cantidadDeMensajesEnviados();
	}
	
	public String nombreUsuario(){
		return miUsuario.obtenerNombre();
	}
	
	public void agregarContacto(String nombre){
		Contacto contacto = new Contacto(nombre);
		this.miUsuario.agregarContactoAAgenda(contacto);
	}
	
	public Boolean existeContacto(String nombre){
		return miUsuario.existeContactoEnAgenda(nombre);
	}
	
	public void recibirMensajeDe(String emisor,String contenido){
		miUsuario.recibirMensajeDe(emisor,contenido);
	}
	
	public int cantidadTotalMensajesRecibidos(){
		return miUsuario.cantidadDeMensajesRecibidos();
	}
	
	public int cantidadMensajesDe(String emisor){
		return miUsuario.cantidadMensajesDe(emisor);
	}
	
	public void enviarMensajeA(String receptor,String contenido){
		miUsuario.enviarMensajeA(receptor,contenido);
	}
	
	public int cantidadTotalMensajesEnviados(){
		return miUsuario.cantidadDeMensajesEnviados();
	}
	
	public int cantidadMensajesEnviadosA(String receptor){
		return miUsuario.cantidadMensajesEnviadosA(receptor);
	}
	
	public List obtenerConversacionCon(String nombre){
		return miUsuario.obtenerConversacionCon(nombre);
	}
	
	public void crearGrupo(String nombreGrupo){
		miUsuario.crearGrupo(nombreGrupo);
	}
	
	public void agregarContactoAGrupo(String miembro,String nombreGrupo){
		miUsuario.agregarContactoAGrupo(miembro, nombreGrupo);
	}
	
	public int cantidadMiembrosEnGrupo(String nombreGrupo){
		return miUsuario.cantidadMiembrosEnGrupo(nombreGrupo);
	}
	
	public Boolean existeGrupo(String nombreGrupo){
		return this.miUsuario.existeGrupo(nombreGrupo);
	}
	
	public void recibirMensajeDeGrupo(String nombreGrupo,String emisor,String contenido){
		this.miUsuario.recibirMensajeDeGrupo(nombreGrupo, emisor, contenido);
	}
	
	public void enviarMensajeAGrupo(String nombreGrupo,String contenido){
		miUsuario.enviarMensajeAGrupo(nombreGrupo, contenido);
	}
	
	public int cantidadMensajesRecibidosDelGrupo(String nombreGrupo){
		return this.miUsuario.cantidadMensajesRecibidosDelGrupo(nombreGrupo);
	}
	
	public int cantidadMensajesEnviadosAlGrupo(String nombreGrupo){
		return this.miUsuario.cantidadMensajesEnviadosAlGrupo(nombreGrupo);
	}
	
	public List obtenerConversacionConGrupo(String nombreGrupo){
		return this.miUsuario.obtenerConversacionConGrupo(nombreGrupo);
	}
	
	public void borrarMensajesDelContacto(String nombreContacto){
		this.miUsuario.borrarMensajesDelContacto(nombreContacto);
	}
	
	public void borrarMensajesDelGrupo(String nombreGrupo){
		this.miUsuario.borrarMensajesDelGrupo(nombreGrupo);
	}
	
}
