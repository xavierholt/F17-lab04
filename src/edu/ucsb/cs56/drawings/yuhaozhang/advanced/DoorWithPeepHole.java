package edu.ucsb.cs56.drawings.yuhaozhang.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

/**
   A House
      
   @author Yuhao Zhang 
   @version for CS56, F17, UCSB
   
*/
public class DoorWithPeepHole extends Door implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public DoorWithPeepHole(double x, double y, double width, double height)
    {

	super(x,y,width,height);
	

	GeneralPath gp = this.get();
		
	double radius = 0.04 * height;  

	Ellipse2D.Double hole = 
	    new Ellipse2D.Double(x + 0.5*width - radius, y + 0.1*height + radius, 2*radius, 2*radius);
	
       
	
	// add the peep hole to the door
	
        GeneralPath wholeDoor = this.get();
        wholeDoor.append(hole, false);   
    }    
}