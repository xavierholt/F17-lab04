package edu.ucsb.cs56.drawings.mmaatubang.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   A Backpack
      
   @author Matt Maatubang
   @version for CS56, F17, UCSB
   
*/
public class Backpack extends Bag implements Shape
{
    /**
     * Constructor for objects of class Backpack
     */
    public Backpack(double x, double y, double width, double height)
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
	
	double w = 0.10 * width;
	double winTop = y;

	double winHt =  0.35 * height;
	
	Rectangle2D.Double win1 =
	    new Rectangle2D.Double(x + w, winTop, width* 0.8, winHt);
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

	double s = 0.16 * width;
	double sTop = y - 0.4 * height;

	Rectangle2D.Double side =
	    new Rectangle2D.Double(x + 0.42 * width, sTop, s, s);
	
        GeneralPath wholeHouse = this.get();
        wholeHouse.append(win1, false); 
	wholeHouse.append(side, false);
    }    
}
