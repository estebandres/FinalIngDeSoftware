package FinalIngSoft;

public class VANESATestDrive {
	static DJView view;
	public static void main (String[] args) {
        BeatModelInterface model = VANESAModel.getInstance();
		ControllerInterface controller = new VANESAController(model,view);
    }
}
