package Visual;
import java.awt.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class VentanaDeReglas extends JDialog{
	
	private JButton b1;
	private JLabel l1;
	private Font f; 
	private TextArea texto;
	private BufferedReader br;
	
	public VentanaDeReglas(Inicio arg0, String arg1, Boolean arg2){
		super(arg0, arg1, arg2);
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(701, 700));
		l1=new JLabel(new ImageIcon(this.getClass().getResource("signo.GIF")));
		f=new Font("Bauhaus 93 Normal", Font.BOLD+ Font.ITALIC, 35);
		l1.setText("Reglas de juego");
		l1.setFont(f);
		l1.setForeground(Color.RED);
		this.add(l1, BorderLayout.NORTH);
		
		b1=new JButton("Volver");
		f=new Font("Bauhaus 93 Normal", Font.BOLD, 25);
		b1.setFont(f);
		b1.setForeground(Color.BLUE);
		b1.addMouseListener(new MiListenerVolver());
		this.add(b1, BorderLayout.SOUTH);
		
		try {
			
			URL arch= new URL(this.getClass().getResource("archivo.txt"), "archivo.txt");
			br = new BufferedReader(new FileReader(new File(arch.toURI())));
			String line = br.readLine();
			StringBuffer textoCompleto = new StringBuffer("");
			while (line != null) {
				textoCompleto.append(line);
				textoCompleto.append("\n");
				line = br.readLine();
			}
			texto=new TextArea(textoCompleto.toString(), 10, 50,TextArea.SCROLLBARS_BOTH);
			f=new Font("Arial",Font.PLAIN,15);
			texto.setFont(f);
			this.add(texto, BorderLayout.CENTER);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pack();this.setVisible(true);
	}
	
	
	public class MiListenerVolver extends MiListenerAbstracto {

		

		@Override
		public void voyHaciaAllí() {
			// TODO Auto-generated method stub
			VentanaDeReglas.this.dispose();
		}

	}
	
}
