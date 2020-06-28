package ObjetosChat;

public class ChatGrupal{
	
	private Conversacion conversacion;
	
	public ChatGrupal(String nombreGrupo){
		conversacion = new Conversacion(nombreGrupo);
	}
	
	public void agregarMensaje(String emisor,String contenido){
		this.conversacion.agregarMensaje(emisor, contenido);
	}
	
	public ListaDesdeUno obtenerConversacion(){
		return this.conversacion.obtenerConversacion();
	}

}
