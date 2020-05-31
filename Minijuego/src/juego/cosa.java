package juego;

import java.awt.Rectangle;
import javax.swing.JPanel;

public class cosa {
	protected int x;
	protected int y;
	private static final int alto = 60;
	private static final int ancho = 40;
	private static JPanel MiJP;
	
	cosa(JPanel MiJ) {
		this.x=(int)(Math.random() * 800);
		this.y=(int)(Math.random() * 700);
	}
	public int CoordX() {
		return this.x;
	}
	
	public int CoordY() {
		return this.y;
	}
	
	public void setCoordX(int x) {
		this.x=x;
	}
	
	public void setCoordY(int y) {
		this.y=y;
	}
	
	public static JPanel getPanel() {
		return MiJP;
	}
	public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, alto, ancho);
    }

}
