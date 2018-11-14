package Visual;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
	
public abstract class MiListenerAbstracto implements MouseListener {
	private  Player player;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
            FileInputStream fis;
           
            URL url= this.getClass().getResource("button-3.mp3");
            fis = new FileInputStream(new File(url.toURI()));
            BufferedInputStream bis = new BufferedInputStream(fis);

            player = new Player(bis); 
            player.play();          
            
        } catch (JavaLayerException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException a) {
            a.printStackTrace();
        } catch (URISyntaxException o) {
			o.printStackTrace();
		}
		
		voyHaciaAllí();
	}
	public void detenerSonido(){
		if(!player.isComplete()){
			player.close();
		}
	}
	public abstract void voyHaciaAllí();
	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}