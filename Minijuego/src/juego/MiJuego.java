package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MiJuego extends JFrame {

	JPanel panel;
	private JPanel contentPane;
	Link player;
	Broncas broncas;
	Topo topo;
	Fantasma fantasma;
	JLabel lblNewLabel;
	int life;
	vida vida;
	Timer reloj;
	int contTiempo=0;
	
	boolean collision() {
		if (player.getBounds().intersects(broncas.getBounds())){ 
			return true;
		}
		else
			return false;
	}
	
		
	/**
	 * Create the frame.
	 */
	public MiJuego(Clip sonido) {
		setTitle("Mini Juego");
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				System.out.println("x-->"+player.CoordX()+", y-->"+player.CoordY());
				System.out.println(panel.getHeight());
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (player.CoordX()>0) {
						player.setCoordX(player.CoordX()-10);
						player.setDireccion("src/juego/imagenes/izquierda.png");;
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (player.CoordX()<(panel.getWidth()-100)) {
						player.setCoordX(player.CoordX()+10);
						player.setDireccion("src/juego/imagenes/derecha.png");;
					}
					break;
				case KeyEvent.VK_UP:
					if (player.CoordY()>0) {
						player.setCoordY(player.CoordY()-10);
						player.setDireccion("src/juego/imagenes/Arriba.png");;
					}
					break;
				case KeyEvent.VK_DOWN:
					if (player.CoordY()<(panel.getWidth()-200)) {
						player.setCoordY(player.CoordY()+10);
						player.setDireccion("src/juego/imagenes/Abajo.png");;
					}
					break;
				}
				
			}
		});
		
				
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		player=new Link(panel, 400, 0, 0);
		
		broncas= new Broncas(panel, 80, 130);
		topo= new Topo(panel, 10, 100);
		fantasma= new Fantasma(panel, 10, 100);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MiJuego.class.getResource("/juego/imagenes/bb42865c33357ec153f2a400aa4f0cfa - copia.jpg")));
		lblNewLabel_3.setBounds(0, 0, 800, 800);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("Salud: "+player.getSalud());
		
		JLabel lblNewLabel_1 = new JLabel("Escudo: "+player.getEscudo());
		
		JLabel lblNewLabel_2 = new JLabel("Arma: "+player.getArma());
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addContainerGap(186, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		
		reloj = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(player.getSalud()<0) {
					sonido.stop();
					dispose();
				}
				
				contTiempo=  (contTiempo+reloj.getDelay())%5000;
				
				//Actualizamos las posiciones de los personajes
				broncas.getPanel().update(panel.getGraphics());
				player.getPanel().update(panel.getGraphics());
				fantasma.getPanel().update(panel.getGraphics());

				//Actualizamos al personaje player
				ImageIcon MiImagen=new ImageIcon(player.getDireccion());
				panel.getGraphics().drawImage(MiImagen.getImage(), player.CoordX(), player.CoordY(), panel);

				//Actualizamos al personaje Broncas
				broncas.movimientoBroncas();
				ImageIcon ImagenBroncas=new ImageIcon(broncas.getDireccion());
				panel.getGraphics().drawImage(ImagenBroncas.getImage(), broncas.CoordX(), broncas.CoordY(), panel);
				
				//Actualizamos a Topo
				topo.movimientoTopo();
				ImageIcon ImagenTopo = new ImageIcon(topo.getDireccion());
				panel.getGraphics().drawImage(ImagenTopo.getImage(), topo.CoordX(),topo.CoordY(), panel);
				
				//Actualizamos fantasma
				if (contTiempo==0) {
					fantasma.setVisible();
					Random r = new Random();
					int valorX = r.nextInt(650);
					int valorY = r.nextInt(460);
					fantasma.setCoordX(valorX);
					fantasma.setCoordY(valorY);
					//System.out.println("Cambio");
				}
				if (fantasma.getVisible()==1) {
					//Actualizamos a Topo
					fantasma.movimientoFantasma();
					ImageIcon ImagenFantasma = new ImageIcon(fantasma.getDireccion());
					panel.getGraphics().drawImage(ImagenFantasma.getImage(), fantasma.CoordX(),fantasma.CoordY(), panel);
				}

				//Linea para evitar parpadeos
				panel.getGraphics().drawImage(null, 10, 80, null);
				
				
				//Colisión con los personajes
				int hiddenBox=100;	//Variable creada para regular el tamaño de la caja oculta
				if ((player.CoordX() >= broncas.CoordX()-hiddenBox && player.CoordX() <= broncas.CoordX()+hiddenBox) 
						&& ((player.CoordY() >= broncas.CoordY()-hiddenBox && player.CoordY() <= broncas.CoordY()+hiddenBox))){
						
					System.out.println("¡Player está tocando a broncas!");
					
						
						if(player.getSalud() <= 0) {
							sonido.stop();
							dispose();
							fin frame  = new fin();
							frame.setVisible(true);
						}
				}
				if ((player.CoordX() >= topo.CoordX()-hiddenBox && player.CoordX() <= topo.CoordX()+hiddenBox) 
						&& ((player.CoordY() >= topo.CoordY()-hiddenBox && player.CoordY() <= topo.CoordY()+hiddenBox))){
						
					System.out.println("¡Player está tocando a topo!");
					
				
						
						if(player.getSalud() <= 0) {
							sonido.stop();
							dispose();
							Principal frame  = new Principal();
							frame.setVisible(true);
						}
				}
				if ((player.CoordX() >= fantasma.CoordX()-hiddenBox && player.CoordX() <= fantasma.CoordX()+hiddenBox) 
						&& ((player.CoordY() >= fantasma.CoordY()-hiddenBox && player.CoordY() <= fantasma.CoordY()+hiddenBox))){
						
					System.out.println("¡Player está tocando a fantasma!");
					
						if(player.getSalud() <= 0) {
							sonido.stop();
							dispose();
							Principal frame  = new Principal();
							frame.setVisible(true);
						}
				}

			}
		});
		reloj.start();
	}
	
	
		
}
