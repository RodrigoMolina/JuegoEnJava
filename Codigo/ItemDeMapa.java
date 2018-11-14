package Codigo;
public abstract class ItemDeMapa {

	/**
	 * ItemDeMapa es la clase padre de todos los objetos del juego y que es ella la que tiene el atributo general posicion
	 * Donde los atributos X e Y de la clase Posicion tienen un correlato con las posiciones de la matriz
	 */
    public Posicion  miPosicion;

	public ItemDeMapa(Posicion arg) {
		miPosicion=arg;
	}

	public Posicion getMiPosicion() {
		return miPosicion;
	}

	public void setMiPosicion(Posicion miPosicion) {
		this.miPosicion = miPosicion;
	}
	 // Las diferentes implementaciones devuelven true si rockford muere y hay q reiniciar el mapa, 
	// y false en caso contrario.
	public abstract Boolean actualizar(Mapa terreno);
	public Boolean sosAmoeba(){
		return false;
	}
	public Boolean sosBicho(){
		return false;
	}
	public Boolean sosButterfly(){
		return false;
	}
	public Boolean sosDiamond(){
		return false;
	}
	public Boolean sosBasura(){
		return false;
	}
	public Boolean sosFirefly(){
		return false;
	}
	public Boolean sosMagicWall(){
		return false;
	}
	public Boolean sosPuerta(){
		return false;
	}
	public Boolean sosRockFord(){
		return false;
	}
	public Boolean sosRoca(){
		return false;
	}
	public Boolean sosVacio(){
		return false;
	}
	public Boolean sosTitanium(){
		return false;
	}
	public Boolean sosPared(){
		return false;
	}
}