package ObjetosChat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Excepciones.NoEsContacto;
import Excepciones.NoExisteContacto;
import Excepciones.NoExisteConversacion;
import Excepciones.NoExisteGrupo;

public class Contacto {
	private String nombreContacto = new String();
	private Buzon buzonEntrada = new Buzon();
	private Buzon buzonSalida = new Buzon();
	private Agenda miAgenda = new Agenda();
	private Map<String,Conversacion> misConversaciones = new HashMap<String,Conversacion>();
	private Map <String, Grupo> misGrupos = new HashMap <String,Grupo>();
	
	public Contacto(String nombre){
		this.nombreContacto = nombre;
	}
	public String obtenerNombre(){
		return this.nombreContacto;
	}
	
	public int cantidadDeContactosEnAgenda(){
		return miAgenda.cantidadDeContactos();
	}
	
	public void agregarContactoAAgenda(Contacto contacto){
		this.miAgenda.agregarContacto(contacto);
	}
	
	public Boolean existeContactoEnAgenda(String nombre){
		return miAgenda.existeContacto(nombre);
	}
	
	public int cantidadDeChatsGrupales(){
		return this.misGrupos.size();
	}
	
	public int cantidadDeGrupos(){
		return this.misGrupos.size();
	}
	
	public int cantidadDeChatsIndividuales(){
		return this.misConversaciones.size();
	}
	
	public int cantidadDeMensajesEnviados(){
		return buzonSalida.cantiadTotalMensajes();
	}
	
	public int cantidadDeMensajesRecibidos(){
		return buzonEntrada.cantiadTotalMensajes();
	}
	
	public void recibirMensajeDe(String emisor,String contenido){
		if(this.miAgenda.existeContacto(emisor)==false){
			throw new NoEsContacto();
		}
		Mensaje mensaje =  new Mensaje(emisor, this.nombreContacto, contenido);
		buzonEntrada.archivarMensaje(mensaje);
		if(misConversaciones.get(emisor)==null){
			Conversacion miConversacion = new Conversacion(emisor);
			this.misConversaciones.put(emisor,miConversacion);
		}
		this.misConversaciones.get(emisor).agregarMensaje(emisor,contenido);
	}
	
	public int cantidadMensajesDe(String emisor){
		if(this.miAgenda.existeContacto(emisor)==false){
			throw new NoEsContacto();
		}
		return buzonEntrada.cantidadMensajesDe(emisor);
	}
	
	public void enviarMensajeA(String receptor,String contenido){
		if(this.miAgenda.existeContacto(receptor)==false){
			throw new NoEsContacto();
		}
		Mensaje mensaje =  new Mensaje(this.nombreContacto,receptor, contenido);
		buzonSalida.archivarMensaje(mensaje);
		if(misConversaciones.get(receptor)==null){
			Conversacion miConversacion = new Conversacion(receptor);
			this.misConversaciones.put(receptor,miConversacion);
		}
		this.misConversaciones.get(receptor).agregarMensaje("Yo",contenido);
	}
	
	public int cantidadMensajesEnviadosA(String receptor){
		if(this.miAgenda.existeContacto(receptor)==false){
			throw new NoEsContacto();
		}
		return buzonSalida.cantidadMensajesA(receptor);
	}
	
	public List obtenerConversacionCon(String nombre){
		if(this.miAgenda.existeContacto(nombre)==false){
			throw new NoEsContacto();
		}
		if(this.misConversaciones.get(nombre)==null){
			throw new NoExisteConversacion();
		}
		return misConversaciones.get(nombre).obtenerConversacion();
	}
	
	public void crearGrupo(String nombreGrupo){
		Grupo miGrupo = new Grupo(nombreGrupo, this.nombreContacto);
		this.misGrupos.put(nombreGrupo, miGrupo);
	}
	
	public void agregarContactoAGrupo(String miembro,String nombreGrupo){
		if(this.misGrupos.get(nombreGrupo)==null){
			throw new NoExisteGrupo();
		}
		if(this.miAgenda.existeContacto(miembro)==false){
			throw new NoEsContacto();
		}
		this.misGrupos.get(nombreGrupo).agregarMiembro(miembro);
	}
	
	public int cantidadMiembrosEnGrupo(String nombreGrupo){
		if(this.misGrupos.get(nombreGrupo)==null){
			throw new NoExisteGrupo();
		}
		return this.misGrupos.get(nombreGrupo).cantidadMiembrosEnGrupo();
	}
	
	public Boolean existeGrupo(String nombreGrupo){
		return this.misGrupos.get(nombreGrupo)!=null;
	}
	
	public void recibirMensajeDeGrupo(String nombreGrupo,String emisor,String contenido){
		if(this.misGrupos.get(nombreGrupo)==null){
			throw new NoExisteGrupo();
		}
		Mensaje mensaje =  new Mensaje(emisor,nombreGrupo, contenido);
		buzonEntrada.archivarMensaje(mensaje);
		this.misGrupos.get(nombreGrupo).recibirMensaje(mensaje);
	}
	
	public void enviarMensajeAGrupo(String nombreGrupo,String contenido){
		if(this.misGrupos.get(nombreGrupo)==null){
			throw new NoExisteGrupo();
		}
		Mensaje mensaje =  new Mensaje(this.nombreContacto,nombreGrupo, contenido);
		buzonSalida.archivarMensaje(mensaje);
		this.misGrupos.get(nombreGrupo).enviarMensaje(mensaje);
	}
	
	public int cantidadMensajesRecibidosDelGrupo(String nombreGrupo){
		if(this.misGrupos.get(nombreGrupo)==null){
			throw new NoExisteGrupo();
		}
		return this.misGrupos.get(nombreGrupo).cantidadMensajesRecibidos();
	}
	
	public int cantidadMensajesEnviadosAlGrupo(String nombreGrupo){
		if(this.misGrupos.get(nombreGrupo)==null){
			throw new NoExisteGrupo();
		}
		return this.misGrupos.get(nombreGrupo).cantidadMensajesEnviados();
	}
	
	public List obtenerConversacionConGrupo(String nombreGrupo){
		if(this.misGrupos.get(nombreGrupo)==null){
			throw new NoExisteGrupo();
		}
		return this.misGrupos.get(nombreGrupo).obtenerConversacion();
	}
	
	public void borrarMensajesDelContacto(String nombreContacto){
		if(this.miAgenda.existeContacto(nombreContacto)==false){
			throw new NoExisteContacto();
		}
		this.buzonEntrada.borrarMensajesDelContacto(nombreContacto);
		this.buzonSalida.borrarMensajesDelContacto(nombreContacto);
	}
	
	public void borrarMensajesDelGrupo(String nombreGrupo){
		if(this.misGrupos.get(nombreGrupo)==null){
			throw new NoExisteGrupo();
		}
		this.misGrupos.get(nombreGrupo).borrarMensajes();
		this.buzonEntrada.borrarMensajesDelContacto(nombreGrupo);
		this.buzonSalida.borrarMensajesDelContacto(nombreGrupo);
	}
	
}
