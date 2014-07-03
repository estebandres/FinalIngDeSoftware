package FinalIngSoft;

public class TestDrive {
	public static void main (String[] args) {
		BeatModelInterface modelB = new BeatModel();
		ControllerInterface controllerB = new BeatController(modelB);
		
		HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface modelH = new HeartController(heartModel);
		
        VANESAModel modelV = VANESAModel.getInstance();
		ControllerInterface controllerV = new VANESAController(modelV);
    }

}
