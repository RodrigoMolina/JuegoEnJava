package Codigo;




public class MagicWall extends ItemDeMapa {
		
  private Integer tiempo;
  private static Boolean estado;

/**
 * MagicWall es una clase que durante un periodo de tiempo transformara todos los diamantes a rocas y las rocas a diamantes 
 * una vez este activa. Para activar los muros magicos (donde el estado de los muros es una variable de clase porque se avilitan todos los muros)
 * y para que sigan pasando atraves de este muro, los objetos que se mueven deben estar en estado estacionario= false. Es decir que vengan en movimiento
 * @param terreno
 * @param misDiamantes
 * @param misRocas
 */
  	public void Invertir(Mapa terreno) {
  		Integer posX=getMiPosicion().getX();
		Integer posY=getMiPosicion().getY();
  		if(estado){
  			if(terreno.getEntidad(posX, posY-1).sosDiamond()){
  				Vacio temp=(Vacio)terreno.getEntidad(posX, posY+1);
  				terreno.setEntidad(posX, posY+1, new Rocks(new Posicion(posX, posY+1)));
  				terreno.setEntidad(posX, posY-1, temp);
  			}else{
  				if(terreno.getEntidad(posX, posY-1).sosRockFord()){
  	  				terreno.setEntidad(posX, posY+1, new Diamond(new Posicion(posX, posY+1)));
  	  				terreno.setEntidad(posX, posY-1, new Vacio(new Posicion(posX, posY-1)));
  			}
  			}
  			
  		}

  	}
  	public Boolean sosMagicWall(){
		return true;
	}
  	public MagicWall(Integer tiempo, Posicion arg) {
  		super(arg);
  		this.tiempo=tiempo;
	  	estado=false;
  	}

  	

	public Boolean getEstado() {
		return estado;
	}
	
	public void setTiempo(Integer tiempo){
		this.tiempo=tiempo;
	}
	
	public Boolean actualizar(Mapa terreno){
		if(tiempo != 0){
			if(estado){
			    this.setTiempo(this.getTiempo()-1);
			}
		}else
			estado=false;
		return false;
	}
	
	public Integer getTiempo(){
		return this.tiempo;
	}
	public void setEstado(Boolean esta){
		MagicWall.estado=esta;
	}
}