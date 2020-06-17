package juego;

import javax.swing.JPanel;

public class Topo extends Personaje{

	private String Sentido;
	
	Topo (JPanel MiJ, int x, int y){
		super(MiJ);
		this.x=x;
		this.y=y;
		this.Sentido="NORTE"; 
	}
	public void movimientoTopo() {
		if (this.y<0) {
			this.Sentido="NORTE";
			this.y=this.y+10;
			this.setDireccion("src/juego/imagenes/topo.png");
		}
		
		else if (this.y>this.getPanel().getWidth()-100) {
			this.Sentido="SUR";
			this.y=this.y-10;
			this.setDireccion("src/juego/imagenes/topo.png");
		}
		
		else if (this.Sentido.contentEquals("NORTE")) {
			this.y=this.y+10;
			this.setDireccion("src/juego/imagenes/topo.png");
		}
		
		else if (this.Sentido.contentEquals("SUR")) {
			this.y=this.y-10;
			this.setDireccion("src/juego/imagenes/topo.png");
		}
	}
}
