package FinalIngSoft;

import Controladores.ControllerInterface;
import Controladores.VANESAController;
import Modelos.BeatModelInterface;
import Modelos.VANESAModel;
import Vistas.DJView;

public class VANESAViewTest {
	static DJView view;
	public static void main (String[] args) {
        BeatModelInterface model = VANESAModel.getInstance();
		ControllerInterface controller = new VANESAController(model,view);
    }
}
