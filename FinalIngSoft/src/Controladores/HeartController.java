package Controladores;

import Modelos.HeartAdapter;
import Modelos.HeartModel;
import Modelos.HeartModelInterface;
import Vistas.DJView;
  
public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
  
	public HeartController(HeartModelInterface model,DJView v) {
		this.model = model;
		if(v!=null){
			view = v;}
		else{
		view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
		}
	}
  
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {
		HeartModel heartModel = HeartModel.getInstance();
	}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
}