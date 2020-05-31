package juego;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Personaje {
	
	protected int x;
	protected int y;
	private String Direccion;
	private static final int alto = 60;
	private static final int ancho = 40;
	private JPanel MiJP;
	
	Personaje(JPanel MiJ) {
		this.x=0;
		this.y=0;
		this.MiJP=MiJ;
	}
	
	public void DibujarPersonaje(Graphics g, int x, int y, String Direccion) {
		this.x=x;
		this.y=y;
		this.MiJP.update(g);
		ImageIcon MiImagen=new ImageIcon(Direccion);
		g.drawImage(MiImagen.getImage(), x, y, MiJP);
		
	}
	public int CoordX() {
		return this.x;
	}
	
	public int CoordY() {
		return this.y;
	}
	
	public String getDireccion() {
		return this.Direccion;
	}
	
	public void setDireccion(String Direccion) {
		this.Direccion=Direccion;
	}
	
	public void setCoordX(int x) {
		this.x=x;
	}
	
	public void setCoordY(int y) {
		this.y=y;
	}
	
	public JPanel getPanel() {
		return this.MiJP;
	}
	public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, alto, ancho);
    }
	
	}

