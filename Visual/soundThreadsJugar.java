package Visual;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class soundThreadsJugar extends Thread {
	public void run(){
		try {
        FileInputStream fis;
        Player player;
        URL url= this.getClass().getResource("sonido.mp3");
        fis = new FileInputStream(new File(url.toURI()));
        BufferedInputStream bis = new BufferedInputStream(fis);

        player = new Player(bis); // Llamada a constructor de la clase Player
        player.play();          // Llamada al método play
    } catch (JavaLayerException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (URISyntaxException e) {
		e.printStackTrace();
	}
}
}
