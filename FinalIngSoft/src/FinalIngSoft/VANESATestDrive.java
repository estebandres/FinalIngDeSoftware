package FinalIngSoft;

public class VANESATestDrive {
	public static void main (String[] args) {
        BeatModelInterface model = VANESAModel.getInstance();
		ControllerInterface controller = new VANESAController(model);
    }
}
