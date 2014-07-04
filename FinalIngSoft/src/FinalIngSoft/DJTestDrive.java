package FinalIngSoft;

import Controladores.BeatController;
import Controladores.ControllerInterface;
import Modelos.BeatModel;
import Modelos.BeatModelInterface;
import Vistas.DJView;
  
public class DJTestDrive {
	static DJView view;
    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model,view);
    }
}
