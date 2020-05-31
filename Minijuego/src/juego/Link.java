package juego;

import javax.swing.JPanel;

public class Link extends Personaje{

	private int salud;
	private int escudo;
	private int arma;
	
	Link(JPanel MiJ, int s, int e, int a) {
		super(MiJ); 
		this.salud=s;
		this.escudo=e;
		this.arma=a;
		
	}
	
	public int getSalud() {
		return this.salud;
	}
	
	public int getEscudo() {
		return this.escudo;
	}
	
	public int getArma() {
		return this.arma;
	}
	
	public void setSalud(int s) {
		this.salud=s;
	}
	
	public void setEscudo(int e) {
		this.escudo=e;
	}
	
	public void setArma(int a) {
		this.arma=a;
	}
}
