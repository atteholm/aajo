package musa;

import lejos.hardware.lcd.LCD;

public class Tekstivalikko {
	
	private String otsikko;
	private String[] otsakkeet;
	private boolean[] kaanteinen;
	private int kohta;
	
	public Tekstivalikko(String otsikko, String[] otsakkeet){
		this.kohta = 0;
		this.otsikko = otsikko;
		this.otsakkeet = otsakkeet;
		this.kaanteinen = new boolean[otsakkeet.length];
		this.kaanteinen[0] = true;
		for (int i = 1; i < kaanteinen.length; i++){
			this.kaanteinen[i] = false;
		} 
	}
	
	public void alas(){
		if (this.kohta< otsakkeet.length-1){
			this.kohta++;
		}else{
			this.kohta = 0;
		}
		for (int i = 0; i < kaanteinen.length; i++){
			kaanteinen[i] = false;
		}
		kaanteinen[this.kohta] = true;
		
	}
	
	public void ylos(){
		if (this.kohta>0){
			this.kohta--;
		}else{
			this.kohta = kaanteinen.length-1;
		}
		for (int i = 0; i < kaanteinen.length; i++){
			kaanteinen[i] = false;
		}
		kaanteinen[kohta] = true;
	}
	
	public void esitaValikko(){
		LCD.clear();
		LCD.drawString(otsikko, 0, 0);
		for (int i = 0; i < otsakkeet.length;i++){
			LCD.drawString(otsakkeet[i], 0, i+1,kaanteinen[i]);
		}
	}
	
	public void tyhjennaNaytto(){
		LCD.clear();
	}
	
	public int annaKohta(){
		return this.kohta;
	}

}
	
