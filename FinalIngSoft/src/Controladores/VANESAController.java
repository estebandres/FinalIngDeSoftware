package Controladores;

import Modelos.BeatModelInterface;
import Vistas.DJView;
import Vistas.VANESAView;

public class VANESAController implements ControllerInterface {
	BeatModelInterface model;
	DJView view;
	VANESAView vanesaView;
	

	public VANESAController(BeatModelInterface model,DJView v) {
		this.model = model;
		vanesaView = new VANESAView(model);
		if(v!=null){
			view = v;}
		else{
		view = new DJView(this, model);
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
		}
	}
  
	public void start() {
//		model.on();
//		view.disableStartMenuItem();
//		view.enableStopMenuItem();
	}
  
	public void stop() {
//		model.off();
//		view.disableStopMenuItem();
//		view.enableStartMenuItem();
	}
    
	public void increaseBPM() {}
    
	public void decreaseBPM() {}

	@Override
	public void setBPM(int bpm) {
		// TODO Auto-generated method stub
		
	}
}
