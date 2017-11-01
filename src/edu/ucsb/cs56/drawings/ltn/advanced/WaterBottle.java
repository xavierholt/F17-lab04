package edu.ucsb.cs56.drawings.ltn.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a water bottle that implements 
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Lindsey Nguyen
   @version for CS56, F17, UCSB
   
*/
public class WaterBottle extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of water bottle
       @param y y coord of lower left corner of water bottle
       @param width width of the water bottle
       @param height of the water bottle
    */
    public WaterBottle(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        Rectangle2D.Double bottle  = 
            new Rectangle2D.Double(x, y, width, height);

	double height_cap = (width/3.0);
	double width_cap = (width/2.0);
	double x_cap = x + (width/2) - (width_cap/2);
	double y_cap = y - height_cap;
	
        Rectangle2D.Double cap  =
	    new Rectangle2D.Double (x_cap, y_cap, width_cap, height_cap);
	
        // put the cap and bottle together
	
        GeneralPath wholeBottle = this.get();
	wholeBottle.append(bottle, false);
	wholeBottle.append(cap, false); 
    }
}
