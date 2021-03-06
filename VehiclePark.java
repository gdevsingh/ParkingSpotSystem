/**
 * Parking Lot containing parking spots 
 * 
 * @author Gurdev Singh 
 * @version 1.0 25-08-2016
 */

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.io.IOException;

public class VehiclePark
{
    // collection of existing parking spots
    private ArrayList<Spot> spots;
    
    
    /**
     * defines the spot collection object
     */
    public VehiclePark()
    {
        
        spots = new ArrayList<Spot>();
    }

    /**
     * Adds parking spot to the collection 
     * 
     * @param  aSpot   parking spot object
     * 
     */
    public void addParkingSpot(Spot aSpot)
    {
        // put your code here
        spots.add(aSpot);
    }
    
    /**
     * Removes parking spot from the collection 
     * 
     * @param  id   id of the parkin spot to be removed
     * @returns true if vehicle is removed from the collection
     */
    public boolean removeParkingSpot(String id)
    {
        for(Spot aSpot : spots)
        {
            if(aSpot.getSpotId().equalsIgnoreCase(id) && aSpot.getIsOccupied()==false)
            {
                spots.remove(aSpot);
                return true;
            }
            
        }
        return false;
    }
    
    /**
     * Gives all the un-occupied parking spots 
     * 
     * @returns collection of un-occupied spots
     * 
     */
    public ArrayList<Spot> getAvailableSpots()
    {
        ArrayList<Spot> sendSpots = new ArrayList<Spot>();
        for(Spot aSpot : spots)
        {
            if(!aSpot.getIsOccupied())
                {sendSpots.add(aSpot);}
        }
        return sendSpots;
    }
    
    /**
     * Gives the spot where the vehicle with specified registration number is parked 
     * 
     * @param  regNum registration number of the vehicle
     * @returns spot containing the vehicle with registration number specified
     */
    public ArrayList<Spot> findVehicle(String ownerName)
    {
        ArrayList<Spot> foundSpots = new ArrayList<Spot>();
        for(Spot aSpot : spots)
        {
            if(aSpot.getVehicle()!=null )
            {  
                if(aSpot.getVehicle().getOwner().equals(ownerName) && aSpot.getIsOccupied())
                {
                    foundSpots.add(aSpot);
                    
                }    
            }
        }   
            return foundSpots;
    
    }
    
    /**
     * Finds the spot with the specified spotId
     * 
     * @param  Id the Id of the spot specified
     * @returns the spot having the spot id specified
     */
    public Spot findSpot(String Id)
    {
        Spot foundSpot = new Spot("-1",-1);
        for(Spot aSpot : spots)
        {
            if(aSpot.getSpotId().equals(Id))
            {
                foundSpot = aSpot;
                break;
            }    
        }
        return foundSpot;
    }
    
    /**
     * Gets the occupied spots
     * 
     * @returns occupied spots
     * 
     */
    public ArrayList<Spot> getOccupiedSpots()
    {
        ArrayList<Spot> occupiedSpots = new ArrayList<Spot>();
        for(Spot aSpot : spots)
        {
            if(aSpot.getIsOccupied())
                {occupiedSpots.add(aSpot);}
        }
        return occupiedSpots;
    }
    
    /**
     * Gets all the spots in the Parking lot 
     * 
     * @returns collection object containing all the parking spots
     * 
     */
    public ArrayList<Spot> getAllSpots()
    {
        return spots;
    }
    
    /**
     * Saves spot data to specified file
     * 
     * @returns collection object containing all the parking spots
     * @throws IOException
     */
    public void writeAllSpots()throws IOException
    {
        ArrayList<String> dataToWrite = new ArrayList<String>();
        for(Spot aSpot : spots)
        {
            aSpot.saveSpot(dataToWrite);
            IOSupport.saveArrData("parking.txt",dataToWrite);
            
            dataToWrite.clear();
        }
    }
    
    /**
     * Reads spot data from the specified file
     * 
     * @returns collection object containing all the parking spots
     * @throws IOException and FileNotFoundException
     */
    public void readAllSpots()throws Exception,IOException
    {
       ArrayList<String> allSpots = IOSupport.readData("parking.txt");
        for(String temp : allSpots)
        {
            spots.add(new Spot(temp));
        }
    }
    
    /**
     * Gets details of all the parking spots in the collection object 
     * 
     * @returns collection object details
     * 
     */
    /*
    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String collectionDetails = (String.format("%-20s%-20s%-20s%-20s%-20s%-20s","Spot Id","Arrival Time","Arrival Date","Time In","Registration#", "Fee/Hr"));
        for(Spot aSpot : spots)
        {
            if(aSpot.getVehicle()!=null && aSpot.getIsOccupied() && aSpot.getVehicle() instanceof Car)
                collectionDetails += (String.format("%-20s%-20s%-20s%-20s%-20s%-20s",aSpot.getSpotId(),aSpot.getArrivalTime().format(formatter),aSpot.getArrivalTime().getMonth().toString().substring(0, 1).toUpperCase() + aSpot.getArrivalTime().getMonth().toString().substring(1).toLowerCase()+" "+aSpot.getArrivalTime().getDayOfMonth()+", "+aSpot.getArrivalTime().getYear(),aSpot.getVehicle().getTimeIn()+" min.",((Car)aSpot.getVehicle()).getRegistrationNumber(),"$"+aSpot.getParkingCharges()));
            else if(aSpot.getVehicle()!=null && aSpot.getIsOccupied() && aSpot.getVehicle() instanceof Bicycle)
                collectionDetails += (String.format("%-20s%-20s%-20s%-20s%-20s%-20s",aSpot.getSpotId(),aSpot.getArrivalTime().format(formatter),aSpot.getArrivalTime().getMonth().toString().substring(0, 1).toUpperCase() + aSpot.getArrivalTime().getMonth().toString().substring(1).toLowerCase()+" "+aSpot.getArrivalTime().getDayOfMonth()+", "+aSpot.getArrivalTime().getYear(),aSpot.getVehicle().getTimeIn()+" min.","-Bicycle-","$"+aSpot.getParkingCharges()));
            else
               collectionDetails += IOSupport.printIt(String.format("%-20s%-20s%-20s%-20s%-20s%-20s",aSpot.getSpotId(),"--","--","--","--","$"+aSpot.getParkingCharges()));
        }
        return collectionDetails;
    }
    */
    
    
}

