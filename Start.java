/**
 * Responsible for starting the program by creating object of the UI class
 * 
 * @author Gurdev Singh 
 * @version 1.0 17-09-2016
 */
import java.util.ArrayList;
import java.io.IOException;
public class Start
{
   
    public static void main(String args[])throws Exception
    {
       //reading all spot data from file 
       VehiclePark vehiclePark = new VehiclePark();
       vehiclePark.readAllSpots();
       
       //executing the UI
       UI ui = new UI(vehiclePark);
       IOSupport.printIt("-----------Swinburne Car Parking System-----------------\n********************************************************"); 
       ui.run();
   
       //writing to the file after program ends
       vehiclePark.writeAllSpots();
        
    }
}
