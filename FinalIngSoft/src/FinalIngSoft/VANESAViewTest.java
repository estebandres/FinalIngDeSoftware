package FinalIngSoft;

public class VANESAViewTest {
	public static void main (String[] args) {
        BeatModelInterface model = VANESAModel.getInstance();
		ControllerInterface controller = new VANESAController(model);
    }
}
