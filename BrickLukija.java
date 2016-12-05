package musa;

import lejos.hardware.Button;
import lejos.utility.Delay;

public class BrickLukija extends Thread{
	
	private boolean lopeta;
	private boolean rekisteroity;
	private int nappainKoodi;
	
	public BrickLukija(){
		
		this.lopeta = false;
		this.rekisteroity = false;
		this.nappainKoodi = 0;
		
	}
	
	public void run(){
		while(!this.lopeta){
			this.nappainKoodi = Button.readButtons();
		}
	}
	
	public void lopeta(){
		this.lopeta = true;
	}
	
	public int annaKoodi(){
		if (this.rekisteroity == false && this.nappainKoodi != 0){
			this.rekisteroity = true;
			return this.nappainKoodi;
		}else{
			if (this.rekisteroity == true && this.nappainKoodi == 0){
				this.rekisteroity = false;
			}
			return 0;
		}
	}

}
