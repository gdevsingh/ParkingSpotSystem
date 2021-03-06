 /**
 * Vehicle for parking into a parking spot in a parking lot
 * 
 * @author Gurdev Singh
 * @version 1.0 25-08-2016
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

abstract class Vehicle
{
    // instance variables - replace the example below with your own
        
    private String owner;
    private LocalDateTime arrivalTime;
    protected double rateToBeCharged;
    
    /**
     * Constructor for objects of class Vehicle
     *@param regNum registration number of the Vehicle
     *@param ownerName name of the owner of the Vehicle
     */
    public Vehicle(String ownerName)
    {
        // initialise instance variables
       
        owner = ownerName;
        arrivalTime = LocalDateTime.now();
        rateToBeCharged = -1;
    }
    
    /**
     * Constructor for creating vehicle by reading vehicle data from a file
     *@param regNum registration number of the Vehicle
     *@param ownerName name of the owner of the Vehicle
     */
    public Vehicle(String ownerName,String arrTime, double chargedRate)
    {
        // initialise instance variables
        owner = ownerName;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        arrivalTime = LocalDateTime.parse(arrTime);
        
        rateToBeCharged = chargedRate;
    }

    
    /**
     * Gives the total amount of fee to be paid for the parking of the Vehicle in the parking lot
     * 
     * @return     total amount to be charged
     */
    public abstract double getFee();
    
    /**
     * Gives all the data about the vehicle
     * 
     * @returns comma separated string containing the vehicle data
     */
    public abstract String saveData();
    
    /**
     * Gives the rate to be charged for parking the Vehicle per hour
     * 
     * @return     rate to be charged
     */
    public double getChargedRate()
    {
        return rateToBeCharged;
    }
    
    
    
    /**
     * Gives the owner's name of the Vehicle object
     * 
     * @return     owner's name of the Vehicle object 
     */
    public String getOwner()
    {
        // put your code here
        return owner;
    }
    
    /**
     * Gives the time of arrival of the Vehicle in the parking lot
     * 
     * @return     arrival time of the Vehicle object 
     */
    public LocalDateTime getArrivalTime()
    {
        // put your code here
        return arrivalTime;
    }
    
    /**
     * Gives the total time the Vehicle spent in the parking lot(in minutes)
     * 
     * @return     minutes spent by the Vehicle in the parking lot
     */
    public long getTimeIn()
    {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-L-yyyy");
        return arrivalTime.until(LocalDateTime.now(),ChronoUnit.MINUTES);
    }
    
    
    
    /**
     * Sets the rate to be charged for the Vehicle
     * 
     *
     */
    public void setChargedRate(double rate)
    {
        rateToBeCharged = rate;
    }
    
    public void setArrivalTime()
    {
        
    }
    
    
    /**
     * Gives the details of the Vehicle object
     * 
     * @return     Vehicle details 
     */
    public String toString()
    {
     return "Owned by : "+owner+" Arrival Time : "+arrivalTime+"\n Rate Charged : "+rateToBeCharged+"\n Time In : "+getTimeIn()+"\n TotalCharge : "+getFee()+"\n***********";   
    }
}

