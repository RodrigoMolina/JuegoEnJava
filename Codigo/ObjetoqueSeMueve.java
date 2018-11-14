
package Codigo;

public abstract class ObjetoqueSeMueve extends ItemDeMapa{

  public Boolean estoyEstacionario;
  
  public abstract Boolean actualizar(Mapa terreno);
  
//  estoyEstacionario es un atributo de la clase que me indica 
//si el objeto se encuentra en movimiento o no. Con sus respectivos Getters y setters

  public Boolean getModo() {
	  return estoyEstacionario;
  }

  public void setModo(Boolean arg) {
	  estoyEstacionario=arg;
  }
 /** 
 * El metodo chequeoMovimiento() actualiza el atributo estoyEstacionario dependiendo de los objetos que se encuentren debajo de los objetos que se mueven
 * sean Rocks o Diamonds
 */
  public void chaqueoMovimiento(Mapa terreno){
	  Integer posicionX=getMiPosicion().getX();
	  Integer posicionY=getMiPosicion().getY();
	

	 if((terreno.getEntidad(posicionX, posicionY+1).sosVacio())||( terreno.getEntidad(posicionX, posicionY+1).sosRoca())||( terreno.getEntidad(posicionX, posicionY+1).sosDiamond())||( terreno.getEntidad(posicionX, posicionY+1).sosPared())){
		 if( terreno.getEntidad(posicionX, posicionY+1).sosVacio()){
			 estoyEstacionario=false;
		 }else{
			 if(((terreno.getEntidad(posicionX-1, posicionY+1).sosVacio())&&(terreno.getEntidad(posicionX-1, posicionY).sosVacio()))||((terreno.getEntidad(posicionX+1, posicionY+1).sosVacio())&&(terreno.getEntidad(posicionX+1, posicionY).sosVacio()))){
				 estoyEstacionario=false;
			 }
			 else estoyEstacionario=true;
			 
		 }
	 }else estoyEstacionario=true;
	  
// entonces, lo que chequeo movimiento hace es actualizar el atributo estadoEstacionario de la clase
  }

  /**
   * 
   * @param terreno
   * En base a ChequeoMovimiento() le indico a el objetoQueSeMueve q se mueva, ocupando un turno para pasar de un casillero de la matriz a otro
   * En caso de que el objeto deba deslizarse, se movera a la izquierda o a la derecha y debera esperar al siguiente turno para poder "caer"
   */
  public void mover(Mapa terreno) {
		chaqueoMovimiento(terreno);
		int posicionX=getMiPosicion().getX();
		int posicionY=getMiPosicion().getY();
		if(!this.getModo()){
			if(terreno.getEntidad(posicionX, posicionY+1).sosVacio()){
				Vacio temp=(Vacio)terreno.getEntidad(posicionX, posicionY+1);
				terreno.setEntidad(posicionX, posicionY+1, terreno.getEntidad(posicionX, posicionY));
				terreno.setEntidad(posicionX, posicionY, temp);
			}else{
				if((terreno.getEntidad(posicionX-1, posicionY) .sosVacio())&&(terreno.getEntidad(posicionX-1, posicionY+1).sosVacio())){
				Vacio temp=(Vacio)terreno.getEntidad(posicionX-1, posicionY);
				terreno.setEntidad(posicionX-1, posicionY, terreno.getEntidad(posicionX, posicionY));
				terreno.setEntidad(posicionX, posicionY, temp);
			}else{
				if((terreno.getEntidad(posicionX+1, posicionY).sosVacio())&&(terreno.getEntidad(posicionX+1, posicionY+1).sosVacio())){
					Vacio temp=(Vacio)terreno.getEntidad(posicionX+1, posicionY);
					terreno.setEntidad(posicionX+1, posicionY, terreno.getEntidad(posicionX, posicionY));
					terreno.setEntidad(posicionX, posicionY, temp);
			}
			}
			
			
		}
  }
  }
  
  /**
   * 
   * @param terreno
   * @param muñeco
   * @return boolean
   * 
   * El metodo ChequearObjetos() observa su modo (si esta estacionario o no) y en base a lo q tenga abajo chequea si cae arriba de Rockford o haceexplotar algun bicho
   * y en base a esto, el booleano que retorna es indicativo de si Rockford se le ha restado una vida y en tal caso este metodo me sirve
   * para indicarle al objeto de la clse Mapa que debe reiniciar la matriz con el objeto Rockforden su posicion debida y su cantidad de vidas restadas en 1.
   */
	 public boolean chequearObjetos(Mapa terreno){
			Integer posicionX=getMiPosicion().getX();
			Integer posicionY=getMiPosicion().getY();
		  if(!getModo()){
			  if(terreno.getEntidad(posicionX, posicionY+1).sosButterfly()){
				  return ((Butterfly)terreno.getEntidad(posicionX, posicionY+1)).explotar(terreno.getEntidades());
				
			  }
			  if(terreno.getEntidad(posicionX, posicionY+1) .sosFirefly()){
				  return ((Firefly)terreno.getEntidad(posicionX, posicionY+1)).explotar(terreno.getEntidades());
				 
			  }
			  if(terreno.getEntidad(posicionX, posicionY+1).sosRockFord()){	  
				  return ((Rockford)terreno.getEntidad(posicionX, posicionY+1)).explotar(terreno.getEntidades());
			  }
			  if(terreno.getEntidad(posicionX, posicionY+1).sosMagicWall()){
				  if(((MagicWall)terreno.getEntidad(posicionX, posicionY+1)).getTiempo()!=0){
					  if(!((MagicWall)terreno.getEntidad(posicionX, posicionY+1)).getEstado())
						  ((MagicWall)terreno.getEntidad(posicionX, posicionY+1)).setEstado(true);
				      ((MagicWall)terreno.getEntidad(posicionX, posicionY+1)).Invertir(terreno);
				  }
				 return false;
			  }
			  return false;
		  }else
			  return false;
	  }

  public ObjetoqueSeMueve(Posicion arg) {
	  super(arg);
	  estoyEstacionario=true;
  }

}