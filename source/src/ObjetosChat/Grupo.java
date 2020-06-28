package ObjetosChat;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
	private String nombreGrupo;
	private List<String> miembros = new ArrayList<String>();
	private ChatGrupal conversacion;
	private Buzon buzonEntrada = new Buzon();
	private Buzon buzonSalida = new Buzon();
	
	public Grupo(String nombreGrupo,String administrador){
		this.nombreGrupo = nombreGrupo;
		miembros.add(administrador);
		this.conversacion = new ChatGrupal(nombreGrupo);
	}
	
	public void agregarMiembro(String miembro){
		this.miembros.add(miembro);
	}
	
	public int cantidadMiembrosEnGrupo(){
		return this.miembros.size();
	}
	
	public void recibirMensaje(Mensaje mensaje){
		buzonEntrada.archivarMensaje(mensaje);
		this.conversacion.agregarMensaje(mensaje.verEmisor(),mensaje.verContenido());
	}
	
	public void enviarMensaje(Mensaje mensaje){
		buzonSalida.archivarMensaje(mensaje);
		this.conversacion.agregarMensaje("Yo",mensaje.verContenido());
	}
	
	public int  cantidadMensajesRecibidos(){
		return this.buzonEntrada.cantiadTotalMensajes();
	}
	
	public int  cantidadMensajesEnviados(){
		return this.buzonSalida.cantiadTotalMensajes();
	}
	
	public List obtenerConversacion(){
		return this.conversacion.obtenerConversacion();
	}
	
	public void borrarMensajes(){
		this.buzonEntrada.borrarTodosLosMensajes();
		this.buzonSalida.borrarTodosLosMensajes();
	}
	
}
