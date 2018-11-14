package Codigo;

public class Rocks extends ObjetoqueSeMueve{

	public Rocks(Posicion arg) {
		super(arg);
		// TODO Auto-generated constructor stub
	}
/** Si bien la clase en si no tiene programacion que la identifique, ella determina las acciones que se pueden tomar en base a si es de tiopo Rocks (al igual que Diamonds, Dirt y TitaniumWall)
 * 	
 */

	@Override
	public Boolean actualizar(Mapa terreno) {
		if(chequearObjetos(terreno))
			return true;
		chaqueoMovimiento(terreno);
		mover(terreno);
		return false;
	}
	public Boolean sosRoca(){
		return true;
	}

}