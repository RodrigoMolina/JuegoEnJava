package Codigo;

public class Puerta extends ItemDeMapa {

	/**
	 * La clase puerta tendra un estado booleano que me indicara si se encuentra abierta o no, 
	 * que se setteara en la clase mapa dependiendo de la cantidad de diamantes que tenga Rockford
	 */
	public Boolean estado;

	public Boolean getEstado() {
		return estado;
	}


	public Puerta(Posicion arg) {
		super(arg);
		this.estado=false;
	}
	public Boolean sosPuerta(){
		return true;
	}
	public Boolean actualizar(Mapa terreno){
		Integer posx=terreno.getPosMuñeco().getX();
		Integer posy=terreno.getPosMuñeco().getY();
		
		if(((Rockford)terreno.getEntidad(posx, posy)).getCantDiamantes()==terreno.getDiamantesNecesarios()){
			estado=true;
		}	
		return false;
		
	}

	

}