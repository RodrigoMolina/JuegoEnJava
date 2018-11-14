package Codigo;



public class Rockford extends ItemDeMapa {
	public Rockford(Posicion arg) {
		super(arg);
		CantDiamantes=0;
		vidasRestantes=4;
		
	}
/* Rockford posee atributos basicos q lo definen (vidas, cantidad de diamantes que lleva acumulados) indispensables a la fuincionalidad del juego con sus respectivos getters y setters
 * los intentos de moverse(arriba, abajo, izquierda, derecha) que le hemos definido chequean las cuatro posibilidades de objetos que tendrá Rockford en su camino
 * y cada chequeo resuelve su caso particular. Es decir, cada mover en su respectivo sentido realiza los diferentes casteos y actualiza las diferentes referencias que hay en la matriz.
 */
  	public int CantDiamantes;

  	public Integer vidasRestantes;
  
  	public int getCantDiamantes() {
  		return CantDiamantes;
  	}
  	public Boolean sosRockFord(){
		return true;
	}

  	public void setCantDiamantes(int canDiamantes) {
	  CantDiamantes = canDiamantes;
  	}

	public Integer getVidas() {
		return vidasRestantes;
	}

	public void setVidas(Integer vidas) {
		this.vidasRestantes = vidas;
		System.out.println("Vidas = "+vidas+".");
	}
	public Boolean Mover(Direccion dire, Mapa terreno){
		switch (dire){
		case Arriba:
			return this.MoverArriba(terreno);
		case Abajo:
			return this.MoverAbajo(terreno);
		case Derecha:
			return this.MoverDerecha(terreno);
		case Izquierda:	
			return this.MoverIzquierda(terreno);
		default:
			return false;
		}
		
		
	}

	public Boolean MoverDerecha(Mapa terreno) {
		int x=this.getMiPosicion().getX();
		int y=this.getMiPosicion().getY();
		if(x==39){
			return false;
		}else{
			if(terreno.getEntidad(x+1, y).sosVacio()){
				System.out.println("Rockford se mueve hacia la derecha desde la posicion ["+x+"]["+y+"] a ["+(x+1)+"]["+y+"] en vacio.");
				Vacio temp=(Vacio)terreno.getEntidad(x+1, y);
				terreno.setEntidad(x+1, y, this);
				terreno.setEntidad(x, y, temp);
				terreno.setPosMuñeco(x+1, y);
				return true;
			}else{
				if(terreno.getEntidad(x+1, y).sosDiamond()){
					System.out.println("Rockford se mueve hacia la derecha desde la posicion ["+x+"]["+y+"] a ["+(x+1)+"]["+y+"] y agarra un diamante.");
					this.CantDiamantes= this.CantDiamantes+1;
					System.out.println("Diamantes recolectados:"+this.CantDiamantes);
					terreno.setEntidad(x+1, y, this);
					terreno.setEntidad(x, y, new Vacio(new Posicion(x, y)));
					terreno.setPosMuñeco(x+1, y);
					return true;
				}else{
					if(terreno.getEntidad(x+1, y).sosBasura()){
						System.out.println("Rockford se mueve hacia la derecha desde la posicion ["+x+"]["+y+"] a ["+(x+1)+"]["+y+"] en basura.");
						terreno.setEntidad(x+1, y, this);
						terreno.setEntidad(x, y, new Vacio(new Posicion(x, y)));
						terreno.setPosMuñeco(x+1, y);
						return true;
					}else{
						if(terreno.getEntidad(x+1, y).sosRoca()){
							if(x+1==39){
								return false;
							}else{
								if(terreno.getEntidad(x+2, y) .sosVacio()){
									System.out.println("Rockford se mueve hacia la izquierda desde la posicion ["+x+"]["+y+"] a ["+(x+1)+"]["+y+"] y mueve con el una roca desde la posicion ["+(x+1)+"]["+y+"] a ["+(x+2)+"]["+y+"].");
									Vacio temp=(Vacio)terreno.getEntidad(x+2, y);
									terreno.setEntidad(x+2, y,terreno.getEntidad(x+1, y));
									terreno.setEntidad(x+1, y, this);
									terreno.setPosMuñeco(x+1, y);
									terreno.setEntidad(x, y, temp);
									return true;
								}
								else return false;
							}
					
					
						}
						else{
							if((terreno.getEntidad(x+1, y).sosPuerta()) && (((Puerta)terreno.getEntidad(terreno.getPosLlegada().getX(), terreno.getPosLlegada().getY())).getEstado())){
								terreno.setEntidad(x+1, y, this);
								terreno.setPosMuñeco(x+1, y);
								terreno.setEntidad(x, y, new Vacio(new Posicion(x, y)));
								
								return true;
							}
							else
								return false;
						}
					}
				}
		
			}
	}	
}
	public Boolean MoverIzquierda(Mapa terreno) {
		int x=this.getMiPosicion().getX();
		int y=this.getMiPosicion().getY();
		if(x==0){
			return false;
		}else{
			if(terreno.getEntidad(x-1, y) .sosVacio()){
				System.out.println("Rockford se mueve hacia la izquierda desde la posicion ["+x+"]["+y+"] a ["+(x-1)+"]["+y+"] en vacio.");
				Vacio temp=(Vacio)terreno.getEntidad(x-1, y);
				terreno.setEntidad(x-1, y, this);
				terreno.setEntidad(x, y, temp);
				terreno.setPosMuñeco(x-1, y);
				return true;
			}else{
				if(terreno.getEntidad(x-1, y) .sosDiamond()){
					System.out.println("Rockford se mueve hacia la izquierda desde la posicion ["+x+"]["+y+"] a ["+(x-1)+"]["+y+"] y agarra un diamante.");
					terreno.setEntidad(x-1, y, this);
					terreno.setEntidad(x, y, new Vacio(new Posicion(x, y)));
					terreno.setPosMuñeco(x-1, y);
					this.CantDiamantes= this.CantDiamantes+1;
					System.out.println("Diamantes recolectados:"+this.CantDiamantes);
					return true;
				}else{
					if(terreno.getEntidad(x-1, y).sosBasura()){
						System.out.println("Rockford se mueve hacia la izquierda desde la posicion ["+x+"]["+y+"] a ["+(x-1)+"]["+y+"] en basura.");
						terreno.setEntidad(x-1, y, this);
						terreno.setEntidad(x, y, new Vacio(new Posicion(x, y)));
						terreno.setPosMuñeco(x-1, y);
						return true;
					}else{
						if(terreno.getEntidad(x-1, y) .sosRoca()){
							if(x-1==0){
								return false;
							}else{
								if(terreno.getEntidad(x-2, y).sosVacio()){
									System.out.println("Rockford se mueve hacia la izquierda desde la posicion ["+x+"]["+y+"] a ["+(x-1)+"]["+y+"] y mueve con el una roca desde la posicion ["+(x-1)+"]["+y+"] a ["+(x-2)+"]["+y+"].");
									Vacio temp=(Vacio)terreno.getEntidad(x-2, y);
									terreno.setEntidad(x-2, y,terreno.getEntidad(x-1, y));
									terreno.setEntidad(x-1, y, this);
									terreno.setPosMuñeco(x-1, y);
									terreno.setEntidad(x, y, temp);
									return true;
								}
								else return false;
							}
					
					
						}
						else{
							if((terreno.getEntidad(x-1, y).sosPuerta()) && (((Puerta)terreno.getEntidad(terreno.getPosLlegada().getX(), terreno.getPosLlegada().getY())).getEstado())){
								terreno.setEntidad(x-1, y, this);
								terreno.setPosMuñeco(x-1, y);
								terreno.setEntidad(x, y, new Vacio(new Posicion(x, y)));
								return true;
							}
							else
								return false;
						}
					}
				}
		
			}
	}	
}

	public Boolean MoverArriba(Mapa terreno) {
		int x=this.getMiPosicion().getX();
		int y=this.getMiPosicion().getY();
		if(y==0){
			return false;
		}else{
			if(terreno.getEntidad(x, y-1) .sosVacio()){
				System.out.println("Rockford se mueve hacia arriba desde la posicion ["+x+"]["+y+"] a ["+x+"]["+(y-1)+"] en vacio.");
				Vacio temp=(Vacio)terreno.getEntidad(x, y-1);
				terreno.setEntidad(x, y-1, this);
				terreno.setEntidad(x, y, temp);
				terreno.setPosMuñeco(x, y-1);
				return true;
			}else{
				if(terreno.getEntidad(x, y-1).sosDiamond()){
					if(((Diamond)terreno.getEntidad(x, y-1)).getModo()){
					   System.out.println("Rockford se mueve hacia arriba desde la posicion ["+x+"]["+y+"] a ["+x+"]["+(y-1)+"] y agarra un diamante.");
					   terreno.setEntidad(x, y-1, this);
					   terreno.setEntidad(x, y, new Vacio(new Posicion(x, y)));
					   terreno.setPosMuñeco(x, y-1);
					   setCantDiamantes(getCantDiamantes()+1);
					   System.out.println("Diamantes recolectados:"+this.CantDiamantes);
					   return true;
					}
					else return false;
				}else{
					if(terreno.getEntidad(x, y-1).sosBasura()){
						System.out.println("Rockford se mueve hacia arriba desde la posicion ["+x+"]["+y+"] a ["+x+"]["+(y-1)+"] en basura.");
						terreno.setEntidad(x, y-1, this);
						terreno.setEntidad(x, y, new Vacio(new Posicion(x, y)));
						terreno.setPosMuñeco(x, y-1);
						return true;
					}else{
						if((terreno.getEntidad(x, y-1).sosPuerta()) && (((Puerta)terreno.getEntidad(terreno.getPosLlegada().getX(), terreno.getPosLlegada().getY())).getEstado())){
								terreno.setEntidad(x, y-1, this);
								terreno.setPosMuñeco(x, y-1);
								terreno.setEntidad(x, y, new Vacio(new Posicion(x, y)));
								
								return true;
							}
							else
								return false;
						
							
						}
					}
				}
		
			}
	}	


	public Boolean MoverAbajo(Mapa terreno) {
		int x=this.getMiPosicion().getX();
		int y=this.getMiPosicion().getY();
		if(y==21){
			return false;
		}else{
			if(terreno.getEntidad(x, y+1) .sosVacio()){
				System.out.println("Rockford se mueve hacia abajo desde la posicion ["+x+"]["+y+"] a ["+x+"]["+(y+1)+"] en vacio.");
				Vacio temp=(Vacio)terreno.getEntidad(x, y+1);
				terreno.setEntidad(x, y+1, this);
				terreno.setEntidad(x, y, temp);
				terreno.setPosMuñeco(x, y+1);
				return true;
			}else{
				if(terreno.getEntidad(x, y+1).sosDiamond()){
					System.out.println("Rockford se mueve hacia abajo desde la posicion ["+x+"]["+y+"] a ["+x+"]["+(y+1)+"] y agarra un diamante.");
					terreno.setEntidad(x, y+1, this);
					terreno.setEntidad(x, y, new Vacio(new Posicion(x, y)));
					terreno.setPosMuñeco(x, y+1);
					this.CantDiamantes= this.CantDiamantes+1;
					System.out.println("Diamantes recolectados:"+this.CantDiamantes);
					return true;
				}else{
					if(terreno.getEntidad(x, y+1).sosBasura()){
						System.out.println("Rockford se mueve hacia abajo desde la posicion ["+x+"]["+y+"] a ["+x+"]["+(y+1)+"] en basura.");
						terreno.setEntidad(x, y+1, this);
						terreno.setEntidad(x, y, new Vacio(new Posicion(x, y)));
						terreno.setPosMuñeco(x, y+1);
						return true;
					}else{
						if((terreno.getEntidad(x, y+1).sosPuerta()) && (((Puerta)terreno.getEntidad(terreno.getPosLlegada().getX(), terreno.getPosLlegada().getY())).getEstado())){
								terreno.setEntidad(x, y+1, this);
								terreno.setPosMuñeco(x, y+1);
								terreno.setEntidad(x, y, new Vacio(new Posicion(x, y)));
							
								return true;
							}
							else
								return false;
						
							
						}
					}
				}
		
			}
	}	

	
/*
 *	El metodo explotar es invocado por Rocks cuando ellas se encuentren arriba de Rockford y esten en estado cayendo
 *	con lo cual a Rockford se le settea la vida y se crea un area de vacios. Elmetodo de Rocks que alla invocado el exlotar 
 *	deberá devolver un Boolean a la clase mapa para reiniciar la matris con las posiciones de BDLevelLoader.
 */
	public Boolean explotar(ItemDeMapa[][] terreno) {
		this.setVidas(this.getVidas()-1);
		System.out.println("Rockford explota porque le cayo una roca por lo que se le saca una vida, y las siguientes posiciones se convierten en vacio:");
		for(int a=(getMiPosicion()).getX()-1;a<(getMiPosicion()).getX()+2;a++){
			for(int b=(getMiPosicion()).getY()-1;b<(getMiPosicion()).getY()+2;b++){
				
					terreno[a][b]=new Vacio(new Posicion(a,b));
				
				  
			}
		}
		return true;
	}
	
	public Boolean actualizar(Mapa terreno){
		return false;
	
	}
	
 
}