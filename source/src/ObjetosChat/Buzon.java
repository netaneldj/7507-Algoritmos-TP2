package ObjetosChat;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Buzon {
	protected List<Mensaje> buzon = new ArrayList<Mensaje>();
	
	public void archivarMensaje(Mensaje mensaje){
		this.buzon.add(mensaje);
	}
	
	public int cantidadMensajesDe(String emisor){
		int cantidadDeEmisor = 0;
		for(int i=0; i< this.buzon.size();i++){
			if(buzon.get(i).verEmisor()==emisor){
				cantidadDeEmisor++;
			}
		}
		return cantidadDeEmisor;
	}
	
	public int cantidadMensajesA(String receptor){
		int cantidadAReceptor = 0;
		for(int i=0; i< this.buzon.size();i++){
			if(buzon.get(i).verReceptor()==receptor){
				cantidadAReceptor++;
			}
		}
		return cantidadAReceptor;		
	}
	
	public int cantiadTotalMensajes(){
		return this.buzon.size();
	}
	
	public void borrarMensajesDelContacto(String nombreContacto){
		Iterator<Mensaje> iteradorBuzon = buzon.iterator();
		while(iteradorBuzon.hasNext()){
			Mensaje actual = iteradorBuzon.next();
			if(actual.verEmisor() == nombreContacto || actual.verReceptor() == nombreContacto){
				iteradorBuzon.remove();
			}		
		}
	}
	
	public void borrarTodosLosMensajes(){
		Iterator<Mensaje> iteradorBuzon = buzon.iterator();
		while(iteradorBuzon.hasNext()){
			iteradorBuzon.next();
			iteradorBuzon.remove();
		}	
	}
	
	
}
