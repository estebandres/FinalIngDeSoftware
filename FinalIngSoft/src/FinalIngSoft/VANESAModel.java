package FinalIngSoft;

import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;


public class VANESAModel implements BeatModelInterface, Runnable {
	
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	int Hz = 0;
	int sum = 0;
	int count = 0;
	private static VANESAModel uniqueInstance = new VANESAModel();
	
	private VANESAModel(){
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public static VANESAModel getInstance(){
		return uniqueInstance;
	}
	
//	------------------------- Procesamiento de Audio -----------------------------------
	public int calculateRMSLevel(byte[] audioData)
	{ // audioData might be buffered data read from a data line
	    long lSum = 0;
	    for(int i=0; i<audioData.length; i++)
	        lSum = lSum + audioData[i];

	    double dAvg = lSum / audioData.length;

	    double sumMeanSquare = 0d;
	    for(int j=0; j<audioData.length; j++)
	        sumMeanSquare = sumMeanSquare + Math.pow(audioData[j] - dAvg, 2d);

	    double averageMeanSquare = sumMeanSquare / audioData.length;
	    return (int)(Math.pow(averageMeanSquare,0.5d) + 0.5);
	}

	public AudioFormat getAudioFormat(){
	    float sampleRate = 8000.0F;
	    //8000,11025,16000,22050,44100
	    int sampleSizeInBits = 16;
	    //8,16
	    int channels = 1;
	    //1,2
	    boolean signed = true;
	    //true,false
	    boolean bigEndian = false;
	    //true,false
	    return new AudioFormat(sampleRate,sampleSizeInBits,channels,signed,bigEndian);
	  }//end getAudioFormat
	
	public void run(){
		 // Open a TargetDataLine for getting microphone input & sound level
	    TargetDataLine line = null;
	    AudioFormat format = getAudioFormat();
	    DataLine.Info info = new DataLine.Info(TargetDataLine.class, format); //     format is an AudioFormat object
	    if (!AudioSystem.isLineSupported(info)) {
	        System.out.println("The line is not supported.");
	    }
	    // Obtain and open the line.
	    try {
	        line = (TargetDataLine) AudioSystem.getLine(info);
	        line.open(format);
	        line.start();
	    } catch (LineUnavailableException ex) {
	        System.out.println("The TargetDataLine is Unavailable.");
	    }
//	    System.out.println(format.getSampleRate());
	    //Timer t = new Timer(); // I used a timer here, code is below
	    while(true){
	    byte[] bytes = new byte[line.getBufferSize() / 5];
	    
	    line.read(bytes, 0, bytes.length);
	    int lectura=(calculateRMSLevel(bytes)-40)*2;
	    System.out.println("RMS Level: " + lectura);	
	    setBPM(lectura);
	    try {
			Thread.sleep(10000/lectura);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    notifyBeatObservers();
	    }
	}
//	------------------------- Fin Procesamiento de Audio -----------------------------------
	
	public void initialize() {
		//Inicializa modulo microfono
        //setUpMidi();
	}
 
    public void on() {
        //sequencer.start();
    	setBPM(0);
    }
 
    public void off() {
		//sequencer.stop();
    	setBPM(0);
    }
 
    public void setBPM(int Hz) {
		this.Hz = Hz;
		//sequencer.setTempoInHz(getBPM());
		notifyBPMObservers();
    }
  
	public int getBPM() {
		return Hz;
	}
     
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}
  
	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}
  
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}
  
	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
		}
	}
	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}
	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}

	
}
