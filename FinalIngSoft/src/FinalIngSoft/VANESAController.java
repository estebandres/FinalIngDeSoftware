package FinalIngSoft;

public class VANESAController implements ControllerInterface {
	BeatModelInterface model;
	DJView view;
	

	public VANESAController(BeatModelInterface model) {
		this.model = model;
//		view = new DJView(this, new HeartAdapter(model));
		view = new DJView(this, model);
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
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
