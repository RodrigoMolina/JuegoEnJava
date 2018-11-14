package Codigo;
import java.util.Random;
/*
 */
public class Amoeba extends ItemDeMapa {


 	public Amoeba(Posicion arg) {
		super(arg);
	}
 	public Boolean sosAmoeba(){
		return true;
	}
	private Boolean decidirExpandir() {
 		Random rnd= new Random();
 		Double valor=rnd.nextDouble();
 		if(valor<0.25){
 			return true;
 		}
 		else{
 			return false;
 		}
 	}

/* El metodo expandir() de Amoeba se ejecutará en cada turno que pase, dentro 
 * de este objeto luego se desidirá si la amoeba se expande o no.
 *
 */
  public void expandir(ItemDeMapa[][] terreno) {
/*La instancia de Mapa nos manda su atributo de tipo matriz de objectos y nosotros 
 * corroboramos que no se violen los limites y chequeando que en la posicion donde 
 * quiero reproducir una amoeba haya un objeto Vacío, determino la reproduccion de la ameba o no
 */
		  
		  Integer posicionX=(this.getMiPosicion()).getX();
		  Integer posicionY=(this.getMiPosicion()).getY();
		  
		  switch (direccionRandom()) {
		  
		  case Izquierda:
			  if(posicionX!=0){
				  if ((terreno[posicionX-1][posicionY]).sosVacio()){
					  terreno[posicionX-1][posicionY]= new Amoeba(new Posicion(posicionX-1,posicionY));
				  }
			  }
			  break;
		  case Arriba:
			  if(posicionY!=0){
				  if (terreno[posicionX][posicionY-1].sosVacio()){
					  terreno[posicionX][posicionY-1]= new Amoeba(new Posicion(posicionX,posicionY-1 ));
				  }
			  }
			  break;
		  case Derecha:
			  if(posicionX!=39){
				  if (terreno[posicionX+1][posicionY].sosVacio()){
					  terreno[posicionX+1][posicionY]= new Amoeba(new Posicion(posicionX+1,posicionY ));
				  }
			  }
			  break;
		  case Abajo:
			  if(posicionY!=21){
				  if (terreno[posicionX][posicionY+1].sosVacio()){
					  terreno[posicionX][posicionY+1]= new Amoeba(new Posicion (posicionX,posicionY+1));
				  }
			  }
			  break;
	  }
  }

  private Direccion direccionRandom() {
	  Random rnd= new Random();
	  Double valor=rnd.nextDouble();
	  if(valor<0.25){
			return Direccion.Izquierda;
		}
		else{
			if(valor<0.5){
				return Direccion.Arriba;
			}else{
				if(valor<0.75){
					return Direccion.Derecha;
				}
				else{
					return Direccion.Abajo;
				}
			}
		}
  }


public Boolean actualizar(Mapa terreno) {
	if(this.decidirExpandir())
		expandir(terreno.getEntidades());
	return false;
	
}

}