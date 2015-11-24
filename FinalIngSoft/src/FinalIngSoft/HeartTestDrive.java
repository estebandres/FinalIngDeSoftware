package FinalIngSoft;

import Controladores.ControllerInterface;
import Controladores.HeartController;
import Modelos.HeartModel;
import Vistas.DJView;
  
public class HeartTestDrive {
	static DJView view;
    public static void main (String[] args) {    	
    	HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface model = new HeartController(heartModel,view);
    		
    }
}
