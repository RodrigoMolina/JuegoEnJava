package Visual;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import Codigo.*;
import mapa.*;

public class MiPanel extends JPanel {
	private Mapa referencia;
	private Map<BDTile, BufferedImage> imagenesURL;
	
	
	public MiPanel(Mapa arg){
		referencia=arg;
		imagenesURL = new HashMap<BDTile, BufferedImage>();
		try {
			imagenesURL.put(BDTile.ROCK, ImageIO.read(this.getClass().getResource("boulder.gif")));
			imagenesURL.put(BDTile.DIAMOND, ImageIO.read(this.getClass().getResource("diamond.gif")));
			imagenesURL.put(BDTile.BUTTERFLY, ImageIO.read(this.getClass().getResource("butterfly.gif")));
			imagenesURL.put(BDTile.AMOEBA, ImageIO.read(this.getClass().getResource("amoeba.gif")));
			imagenesURL.put(BDTile.DIRT, ImageIO.read(this.getClass().getResource("dirt.gif")));
			imagenesURL.put(BDTile.EMPTY, ImageIO.read(this.getClass().getResource("empty.jpg")));
			imagenesURL.put(BDTile.EXIT,ImageIO.read(this.getClass().getResource("exit.gif")));
			imagenesURL.put(BDTile.FIREFLY, ImageIO.read(this.getClass().getResource("firefly.gif")));
			imagenesURL.put(BDTile.WALL, ImageIO.read(this.getClass().getResource("wall.gif")));
			imagenesURL.put(BDTile.PLAYER, ImageIO.read(this.getClass().getResource("rockford.gif")));
			imagenesURL.put(BDTile.TITANIUM, ImageIO.read(this.getClass().getResource("steel.gif")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void paint(Graphics g){
		for(int a=0;a<40;a++)
			for(int b=0;b<22;b++){
				ItemDeMapa entidad=referencia.getEntidad(a, b);
				if(entidad.sosAmoeba()){
					g.drawImage(imagenesURL.get(BDTile.AMOEBA), 16*a, 16*b, this);
				}
				if(entidad.sosButterfly()){
					g.drawImage(imagenesURL.get(BDTile.BUTTERFLY), 16*a, 16*b, this);
				}
				
				if(entidad.sosDiamond()){
					g.drawImage(imagenesURL.get(BDTile.DIAMOND), 16*a, 16*b, this);
				}
				if(entidad.sosBasura()){
					g.drawImage(imagenesURL.get(BDTile.DIRT), 16*a, 16*b, this);
				}
				if(entidad.sosVacio()){
					g.drawImage(imagenesURL.get(BDTile.EMPTY), 16*a, 16*b, this);
				}
				if(entidad.sosPuerta()){
					g.drawImage(imagenesURL.get(BDTile.EXIT), 16*a, 16*b, this);
				}
				if(entidad.sosFirefly()){
					g.drawImage(imagenesURL.get(BDTile.FIREFLY), 16*a, 16*b, this);
				}
				if(entidad.sosRockFord()){
					g.drawImage(imagenesURL.get(BDTile.PLAYER), 16*a, 16*b, this);
				}
				if(entidad.sosRoca()){
					g.drawImage(imagenesURL.get(BDTile.ROCK), 16*a, 16*b, this);
				}			
				if(entidad.sosTitanium()){
					g.drawImage(imagenesURL.get(BDTile.TITANIUM), 16*a, 16*b, this);
				}
				if(entidad.sosPared()){
					g.drawImage(imagenesURL.get(BDTile.WALL), 16*a, 16*b, this);
				}					
				
				
			}
	}
}
