package Visual;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class soundThreadsinicio extends Thread {
	 
	public void run(){
			try {
            FileInputStream fis;
            Player player;
            URL url= this.getClass().getResource("Inicio.mp3");
            fis = new FileInputStream(new File(url.toURI()));
            BufferedInputStream bis = new BufferedInputStream(fis);

            player = new Player(bis); // Llamada a constructor de la clase Player
            player.play();          // Llamada al método play
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
