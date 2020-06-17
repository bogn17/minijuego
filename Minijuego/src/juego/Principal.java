package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJugar = new JButton("");
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Clip sonido=AudioSystem.getClip();
					sonido.open(AudioSystem.getAudioInputStream(new File("src/juego/imagenes/ringtones-tema-zelda.wav")));
					sonido.start();
					
					MiJuego frame = new MiJuego(sonido);
					frame.setVisible(true);
					dispose();								
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnJugar.setIcon(new ImageIcon(Principal.class.getResource("/juego/imagenes/BOTONYA.png")));
		btnJugar.setOpaque(false);;
        btnJugar.setContentAreaFilled(false);
        btnJugar.setBorderPainted(false);
		btnJugar.setBounds(288, 200, 109, 37);
		contentPane.add(btnJugar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Principal.class.getResource("/juego/imagenes/LddBueno.png")));
		lblNewLabel_2.setBounds(574, 11, 82, 92);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/juego/imagenes/ZeldaLogo.png")));
		lblNewLabel_1.setBounds(233, 105, 210, 99);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -18, 698, 403);
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/juego/imagenes/joder.jpg")));
		contentPane.add(lblNewLabel);
		
	
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
