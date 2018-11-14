package Codigo;

public class Butterfly extends Bicho {
	
	@Override
	/*
	 * El metodo moverse() de Butterfly utiliza el metodo de la clase padre para chequear que se puede mover
	 * utilizando el enumerativo de direccion y haciendo una actualizacion de las refe3rencias de la matriz
	 */
	public void moverse(ItemDeMapa[][] terreno) { 
		if(puedoMover(terreno)){
//			Una vez que chequeo que en esa posicion yo me puedo mover, seteo las posiciones.
			Integer posX=getMiPosicion().getX();
			Integer posY=getMiPosicion().getY();
			switch(DireccionActual){
			case Arriba:
				Vacio temp=(Vacio)terreno[posX][posY-1];
				terreno[posX][posY-1]=terreno[posX][posY];
				terreno[posX][posY]=temp;
				getMiPosicion().setY(getMiPosicion().getY()-1);
				break;
			case Derecha:
				Vacio temp1=(Vacio)terreno[posX+1][posY];
				terreno[posX+1][posY]=terreno[posX][posY];
				terreno[posX][posY]=temp1;
				getMiPosicion().setX(getMiPosicion().getX()+1);
				break;
			case Abajo:
				Vacio temp2=(Vacio)terreno[posX][posY+1];
				terreno[posX][posY+1]=terreno[posX][posY];
				terreno[posX][posY]=temp2;
				getMiPosicion().setY(getMiPosicion().getY()+1);
				break;
			case Izquierda:
				Vacio temp3=(Vacio)terreno[posX-1][posY];
				terreno[posX-1][posY]=terreno[posX][posY];
				terreno[posX][posY]=temp3;
				getMiPosicion().setX(getMiPosicion().getX()-1);
				break;
			}
		}
		else{
			
//			En caso de que el objeto Butterfly no se pueda mover, cambio la direccion en sentido antihorario y paso el turno
			switch(DireccionActual){
			case Arriba:
				DireccionActual=Direccion.Izquierda;
				break;
			case Derecha:
				DireccionActual=Direccion.Arriba;
				break;
			case Abajo:
				DireccionActual=Direccion.Derecha;
				break;
			case Izquierda:
				DireccionActual=Direccion.Abajo;
				break;
			}
		}
	
	}
	
	public Boolean sosButterfly(){
		return true;
	}
	public Butterfly(Posicion arg){
		super(arg);
		DireccionActual=Direccion.Arriba;
		
	}

	/*
	 * Cuando Butterfly explota (porque tiene a Rockford como vecino a porque le cayo una roca) 
	 * chequeando en cada caso si Rockford debe setear sus vidas o no devolviendo un booleano indicando si el evento de que Rockford exploto ocurrio o no
	 */
	@Override
	public Boolean explotar(ItemDeMapa[][] terreno) {
		   Boolean muere=false;
			System.out.println("Explota la Mariposa de la posicion ["+(getMiPosicion().getX())+"]["+(getMiPosicion().getY())+"] y convierte en diamante lo que hay en las posiciones:");
			for(int a=(getMiPosicion()).getX()-1;a<(getMiPosicion()).getX()+2;a++){
				for(int b=(getMiPosicion()).getY()-1;b<(getMiPosicion()).getY()+2;b++){
					if((b<22)&&(b>=0)&&(a>=0)&&(a<40)&&(!(terreno[a][b].sosTitanium()))){
						System.out.println("["+a+"]["+b+"]");
						if(terreno[a][b].sosRockFord()){
							((Rockford)terreno[a][b]).setVidas(((Rockford)terreno[a][b]).getVidas()-1);
							System.out.println("Rockford muere por la explocion por lo que se le resta una vida");
							muere=true;
					  }
					terreno[a][b]=new Diamond(new Posicion(a,b));
					}
				}
			}
		return muere;
		}
		
	public Boolean actualizar(Mapa terreno){
		if(chequearAdyacentes(terreno.getEntidades())){
			explotar(terreno.getEntidades());
			return true;			
		}
		moverse(terreno.getEntidades());
		return false;
	}

}