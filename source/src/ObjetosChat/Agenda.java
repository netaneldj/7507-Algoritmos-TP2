package ObjetosChat;

import java.util.HashMap;
import java.util.Map;

public class Agenda {
	
	private Map <String, Contacto> miAgenda = new HashMap <String,Contacto>();
	
	public void agregarContacto(Contacto contacto){
		this.miAgenda.put(contacto.obtenerNombre(),contacto);
	}
	
	public int cantidadDeContactos(){
		return miAgenda.size();
	}
	
	public Boolean existeContacto(String nombre){
		return this.miAgenda.get(nombre)!=null;
	} 

}
