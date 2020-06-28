package ObjetosChat;

public class Conversacion {
	private ListaDesdeUno historial = new ListaDesdeUno();
	private String persona;
	
	public Conversacion(String persona){
		this.persona = persona;
	}
	
	public void agregarMensaje(String emisor,String contenido){
		this.historial.add(0,emisor+": "+contenido);
	}
	
	public String conversoCon(){
		return this.persona;
	}
	
	public ListaDesdeUno obtenerConversacion(){
		return this.historial;
	}
}
