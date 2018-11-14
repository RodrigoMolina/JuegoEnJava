package Codigo;
import mapa.*;

public class Mapa {
	
  public ItemDeMapa[][] Entidades;
  
  private Rockford player;
  private Puerta llegada;
  public int nivelActual;
  
  
  public Integer diamantesNecesarios;

  private int limiteX=40;

  private int limiteY=22;
  
  private BDLevelReader inicializador;
 
  public Mapa(int nivel) {
	 Entidades= new ItemDeMapa[limiteX][limiteY];
     inicializador= new BDLevelReader();
     nivelActual=nivel;
     
	  try {
		  inicializador.readLevels("levels.xml");
			 inicializador.setCurrentLevel(nivel);
		 	 diamantesNecesarios=inicializador.getDiamondsNeeded();
		    for(int a =0;a<limiteX;a++){
		       for(int b=0;b<limiteY;b++){ 
			      switch(inicializador.getTile(a, b)){
			  case AMOEBA:
				  Entidades[a][b]=new Amoeba(new Posicion(a,b));
				  break;
			  case BUTTERFLY:
				  Entidades[a][b]=new Butterfly(new Posicion(a,b));
				  break;
			  case DIAMOND:
				  Entidades[a][b]=new Diamond(new Posicion(a,b));
				  break;
			  case DIRT:
				  Entidades[a][b]=new Dirt(new Posicion(a,b));
				  break;
			  case EMPTY:
				  Entidades[a][b]=new Vacio(new Posicion(a,b));
				  break;
			  case EXIT:
				  Entidades[a][b]=llegada=new Puerta(new Posicion(a,b));
				  break;
			  case FIREFLY:
				  Entidades[a][b]=new Firefly(new Posicion(a,b));
				  break;
			  case PLAYER:
				  Entidades[a][b]=player=new Rockford(new Posicion(a,b));
				  player.setMiPosicion(new Posicion(a,b));
				  break;
			  case ROCK:
				  Entidades[a][b]=new Rocks(new Posicion(a,b));
				  break;
			  case TITANIUM:
				  Entidades[a][b]=new TitaniumWall(new Posicion(a,b));
				  break;
			  case WALL:
				  Entidades[a][b]=new Wall(new Posicion(a,b));
				  break;
			default:
				break;
			  }
		  }
	  }
	  }catch (NullPointerException a){
		  System.err.println("Falta completar los campo de datos. ¡¡¡POR FAVOR, INGRESE SU NOMBRE Y ELIJA UN NIVEL!!!: "+a.getMessage());
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
  }
  
  public void reiniciarMapa(Integer nivelPass){
	  	nivelActual=nivelPass;
		  try {
			  inicializador.readLevels("levels.xml");
			inicializador.setCurrentLevel(nivelPass);
			 diamantesNecesarios=inicializador.getDiamondsNeeded();
			    for(int a =0;a<limiteX;a++){
			       for(int b=0;b<limiteY;b++){ 
			    	   switch(inicializador.getTile(a, b)){
			    	   	case AMOEBA:
			    	   		Entidades[a][b]=new Amoeba(new Posicion(a,b));
			    	   		break;
				  case BUTTERFLY:
					  Entidades[a][b]=new Butterfly(new Posicion(a,b));
					  break;
				  case DIAMOND:
					  Entidades[a][b]=new Diamond(new Posicion(a,b));
					  break;
				  case DIRT:
					  Entidades[a][b]=new Dirt(new Posicion(a,b));
					  break;
				  case EMPTY:
					  Entidades[a][b]=new Vacio(new Posicion(a,b));
					  break;
				  case EXIT:
					  Entidades[a][b]=llegada=new Puerta(new Posicion(a,b));
					  break;
				  case FIREFLY:
					  Entidades[a][b]=new Firefly(new Posicion(a,b));
					  break;
				  case PLAYER:
					  player.setMiPosicion(new Posicion(a,b));
					  player.setCantDiamantes(0);

					  Entidades[a][b]=player;
					 
					  break;
				  case ROCK:
					  Entidades[a][b]=new Rocks(new Posicion(a,b));
					  break;
				  case TITANIUM:
					  Entidades[a][b]=new TitaniumWall(new Posicion(a,b));
					  break;
				  case WALL:
					  Entidades[a][b]=new Wall(new Posicion(a,b));
					  break;
				default:
					break;
				  }
			  }
		  }
		} catch (Exception e) {
			e.printStackTrace();
		}
  }
 
  
  
  public int getLimiteX() {
	return limiteX;
}


public int getLimiteY() {
	return limiteY;
}

public Posicion getPosMuñeco(){
	return player.getMiPosicion();
}

public void setPosMuñeco(int x, int y){
	player.getMiPosicion().setX(x);
	player.getMiPosicion().setY(y);
}

public Posicion getPosLlegada(){
	return llegada.getMiPosicion();
}

public void setPosLlegada(Posicion Pos){
	llegada.setMiPosicion(Pos);
}
public Integer getDiamantesNecesarios(){
	return diamantesNecesarios;
}

public ItemDeMapa getEntidad(int a, int b){
	if(limiteX>a){
		if(limiteY>b){
	        return Entidades[a][b];
	       
		}
	}
	System.out.println("Alguna de las dos coordenadas recividas como parametro estan fuera del limite, por lo que devuelve un ItemDeMapa de tipo Vacio");
	return new Vacio(new Posicion(a,b));
}
public ItemDeMapa[][] getEntidades(){
	return Entidades;
}
public void setEntidad(int a, int b, ItemDeMapa entidad){
	entidad.getMiPosicion().setX(a);
	entidad.getMiPosicion().setY(b);
	this.Entidades[a][b]=entidad;
}

public Integer getNivelActual(){
	return nivelActual;
}
public void setNivelActual(Integer arg){
	nivelActual=arg;
}

public Rockford getMuñeco(){
	return player;
}
public Puerta getLlegada(){
	return llegada;
}

}