package Codigo;


public class Juego {
	
	private static  Mapa  campo;
	private  Rockford miJugador;
	
	public Juego(Integer nivel){
		campo=new Mapa(nivel);
		miJugador=campo.getMu�eco();
	}
	public Mapa dameCampo(){
		return campo;
	}
	public Boolean llegue(){
		if(campo.getPosLlegada().equals(campo.getPosMu�eco())){
			return true;
		}
		else return false;
	}
	public Integer dameDiamantesNecesarios(){
		return campo.getDiamantesNecesarios();
	}

	public void avanzarNivel() {
		campo.reiniciarMapa(campo.getNivelActual()+1);
	}
	
	
	
	public Boolean siguienteTurno(){
		for(int a=0; a<campo.getLimiteX();a++){
			for(int b=0; b<campo.getLimiteY();b++){
				Boolean muere=campo.getEntidad(a, b).actualizar(campo);	
				if (muere){
					return true;
				}
			}
		}return false;
		
	}
	public void moverRockford(Direccion dir){
		try{
		((Rockford)campo.getEntidad(campo.getPosMu�eco().getX(), campo.getPosMu�eco().getY())).Mover(dir, campo);
		}catch (ClassCastException i){
			System.err.println("RockFord a muerto, espere un intante a que reviva: "+i.getMessage());
		}
	}
	public Integer dameVidas(){
		return miJugador.getVidas();
	}
	public Integer dameDiamantes(){
		return miJugador.getCantDiamantes();
	}
	
	public Mapa getCampo(){
		return campo;
	}
	
	public void reiniciar(){
		campo.reiniciarMapa(campo.getNivelActual());
	}

	public Rockford getMiJugador() {
		return miJugador;
	}

	
	

}