package Codigo;

public abstract class Bicho extends ItemDeMapa{

	public Direccion  DireccionActual;

	public Bicho(Posicion arg) {
		super(arg);
		DireccionActual=Direccion.Arriba;
	}
	public Boolean sosBicho(){
		return true;
	}
	public abstract Boolean explotar(ItemDeMapa[][] terreno);
	
	public abstract Boolean actualizar(Mapa terreno);

  	public abstract void moverse(ItemDeMapa[][] terreno); 
  	/* Tanto explotar() como moverse() seran abstractos debido a que Butterfly y Firefly se 
  	 * mueven y explotan , pero cada una hace algo diferente en esa accion y con ello la necesidad de mandarlas a clases diferentes. 
  	 */

  	public Boolean chequearAdyacentes(ItemDeMapa[][] terreno) {
  		
  /*Con chequearAdyacentes() chequeo que el objeto de tipo Rokford se encuentre arriba, abajo, derecha o izquierda 
   * del bicho y asi indicarle a este bicho que explote.
   * Siendo Bicho la superclase de Firefly y Butterfly.
   */
  		int posicionX=(getMiPosicion()).getX();
	    int posicionY=(getMiPosicion()).getY();
		
		// chequeo todos los adyacentes
		if (posicionX!=0){	
			if (terreno[posicionX-1][posicionY].sosRockFord()){
				return true;
			}
		}
		if (posicionX!=39){	
			if (terreno[posicionX+1][posicionY] .sosRockFord()){
				return true;
			}
		}
		if (posicionY!=0){	
			if (terreno[posicionX][posicionY-1] .sosRockFord()){
				return true;
			}
		}
		if (posicionY!=21){	
			if (terreno[posicionX][posicionY+1] .sosRockFord()){
				return true;
				
			}
		}
		return false;
  		
  	}
public Boolean puedoMover(ItemDeMapa[][] terreno){
/* Chequeo los limites y que la posicion a donde quiero moverme sea de tipo vacio. Si no no me podre mover (en el caso de los bichos).
 * 
 */
//		Metodo de la clase 
		Integer posicionX=(getMiPosicion()).getX();
		Integer posicionY=(getMiPosicion()).getY();
		
		switch (DireccionActual){
			case Arriba:
				if(posicionY==0){
					return false;
				}
				else{
					if(terreno[posicionX][posicionY-1].sosVacio()) 
						return true;
					else return false;
				}
				
			case Derecha:
				if(posicionX==39){
					return false;
				}
				else{
					if(terreno[posicionX+1][posicionY].sosVacio()) 
						return true;
					else return false;
				}
				
			case Abajo:
				if(posicionY==21){
					return false;
				}
				else{
					if(terreno[posicionX][posicionY+1].sosVacio()) 
						return true;
					else return false;
				}
			case Izquierda:
				if(posicionX==0){
					return false;
				}
				else{
					if(terreno[posicionX-1][posicionY].sosVacio()) 
						return true;
					else return false;
				}
			
		}
		return null;

}
}