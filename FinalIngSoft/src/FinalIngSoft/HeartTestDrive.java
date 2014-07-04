package FinalIngSoft;
  
public class HeartTestDrive {
	static DJView view;
    public static void main (String[] args) {    	
    	HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface model = new HeartController(heartModel,view);
    		
    }
}
