package musa;

import lejos.hardware.sensor.EV3IRSensor;

public class IRLukija extends Thread {
	private EV3IRSensor irsensori;
	private int komento;
	private boolean lopeta;
	
	public IRLukija(EV3IRSensor sensori){
		this.irsensori = sensori;
		this.lopeta = false;
	}
	// run-metodia suorittaessa tulee satunnaisia outofbounds-exceptioneita
	// tällöin komennoksi tulkitaan 0, jolloin mitään ei suoriteta
	public void run(){
		while (!this.lopeta){
			try{
				this.komento = this.irsensori.getRemoteCommand(0);
			}catch(Exception e){
				this.komento = 0;
			}
			
		}
	}
	
	public int annaKomento(){
		return this.komento;
	}
	
	public void lopeta(){
		this.lopeta = true;
	}

}
