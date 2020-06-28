package ObjetosChat;

public class Mensaje {
	private String emisor;
	private String receptor;
	private String contenido;
	
	public Mensaje(String emisor,String receptor,String contenido){
		this.emisor = emisor;
		this.receptor = receptor;
		this.contenido = contenido;
	}
	public String verContenido(){
		return this.contenido;
	}
	
	public String verEmisor(){
		return this.emisor;
	}
	
	public String verReceptor(){
		return this.receptor;
	}

}
