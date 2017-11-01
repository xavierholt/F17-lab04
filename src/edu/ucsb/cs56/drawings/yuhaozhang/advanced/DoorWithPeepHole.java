package edu.ucsb.cs56.drawings.yuhaozhang.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

/**
   A House
      
   @author Phill Conrad 
   @version for CS56, W16, UCSB
   
*/
public class DoorWithPeepHole extends Door implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public DoorWithPeepHole(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make three windows, spaced like this, where w=width/10.0;
	// | +--+ +--+ +--+ |
	// | |  | |  | |  | |
	// | +--+ +--+ +--+ |
	// |w 2w w 2w w w2 w|
	//
	// The top of window will be at y + 0.5*height and the
	// height of the window is 0.25height;
	
	double radius = 0.04 * height;  

	Ellipse2D.Double hole = 
	    new Ellipse2D.Double(x + 0.5*width - radius, y + 0.1*height + radius, 2*radius, 2*radius);
	
       
	
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")
	
        GeneralPath wholeDoor = this.get();
        wholeDoor.append(hole, false);   
    }    
}