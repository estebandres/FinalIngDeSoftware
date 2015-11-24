package Modelos;

import javax.sound.sampled.AudioFormat;

import Vistas.BPMObserver;
import Vistas.BeatObserver;

public interface VANESAModelInterface {
	void initialize();  
	void on();  
	void off();  
    void setHz(int Hz);  
	int  getHz();  
	int calculateRMSLevel(byte[] audioData);
	AudioFormat getAudioFormat();
//	void signalProcessing();
	void registerObserver(BeatObserver o);  
	void removeObserver(BeatObserver o);  
	void registerObserver(BPMObserver o);  
	void removeObserver(BPMObserver o);
}
