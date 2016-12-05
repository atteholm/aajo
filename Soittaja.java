package musa;

import lejos.hardware.Sound;

public class Soittaja {
	
	private int[] instrumentti = new int[5];
	private int aanenVoimakkuus;
	private final static int MAXVOL = 100;
	
	public Soittaja(int aanenVoimakkuus){
		
		if (aanenVoimakkuus < 0 || aanenVoimakkuus > MAXVOL){
			this.aanenVoimakkuus = 50;
		}else{
			this.aanenVoimakkuus = aanenVoimakkuus;
		}
				
	}
	
	
	public void asetaInstrumentti(int valinta){
		if (valinta == 0){
			asetaTaulukonArvot(4, 25, 500, 7000, 5);
		}else if (valinta == 1){
			asetaTaulukonArvot(10, 25, 2000, 1000, 25);
		}else if (valinta == 2){
			asetaTaulukonArvot(1, 8, 3000, 5000, 5);
		}
	}
	
	private void asetaTaulukonArvot(int i0, int i1, int i2, int i3, int i4){
		this.instrumentti[0] = i0;
		this.instrumentti[1] = i1;
		this.instrumentti[2] = i2;
		this.instrumentti[3] = i3;
		this.instrumentti[4] = i4;
	}
	
	public void muutaAanenVoimakkuutta (int muutos){
		
		if (this.aanenVoimakkuus + muutos < 0){
			this.aanenVoimakkuus = 0;
		}else if(this.aanenVoimakkuus + muutos > MAXVOL){
			this.aanenVoimakkuus = MAXVOL;
		}else{
			this.aanenVoimakkuus += muutos;
		}
		Sound.setVolume(aanenVoimakkuus);
	}
	
	public void soita(int taajuus, int kesto){
		Sound.playNote(instrumentti, taajuus, kesto);
	}
	
	public int annaAanenVoimakkuus(){
		return this.aanenVoimakkuus;
	}

}
