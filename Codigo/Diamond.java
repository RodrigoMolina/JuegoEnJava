package Codigo;

/** 
 * La clase diamante basicamente se comporta como un objeto q se mueve y no incorpora nada mas a su programacion.
 * De nuevo solo sirve (al igual que basura y muro de titanio) para ser identificada por rockford (casteo) como tal y asi tomar las decisiones debidas
 */
public class Diamond extends ObjetoqueSeMueve{

	public Diamond(Posicion arg) {
		super(arg);
		
	}
	
	public Boolean sosDiamond(){
		return true;
	}
	
	public Boolean actualizar(Mapa terreno) {
		if(chequearObjetos(terreno))
			return true;
		chaqueoMovimiento(terreno);
		mover(terreno);
		return false;
	}


}