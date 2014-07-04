package FinalIngSoft;

public class TestDrive {
	static DJView viewH;
	static DJView viewB;
	static DJView viewV;
	public static void main (String[] args) {
		
		BeatModelInterface modelB = new BeatModel();
		ControllerInterface controllerB = new BeatController(modelB,viewB);
		
		HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface modelH = new HeartController(heartModel,viewH);

        VANESAModel modelV = VANESAModel.getInstance();
		ControllerInterface controllerV = new VANESAController(modelV,viewV);
    }

}
