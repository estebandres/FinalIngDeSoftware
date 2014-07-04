package FinalIngSoft;
  
public class DJTestDrive {
	static DJView view;
    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model,view);
    }
}
