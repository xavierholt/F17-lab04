package edu.ucsb.cs56.drawings.ltn.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   A Water Bottle
      
   @author Lindsey Nguyen 
   @version for CS56, F17, UCSB
   
*/
public class WaterBottleWithStraw extends WaterBottle implements Shape
{
    /**
     * Constructor for objects of class WaterBottleWithStraw
     */
    public WaterBottleWithStraw(double x, double y, double width, double height)
    {
	// construct the basic water bottle shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	//Make a straw (vertical part, horizontal part)
	double strawWidth = width/7.0;
	double verticalStrawLength = height + 2*(width/3.0);
	double horizStrawLength = verticalStrawLength/3.0;

	double vertical_x = x + (width/2) - (strawWidth/2);
	double vertical_y = y - (verticalStrawLength - height);
	double horiz_x = vertical_x;
	double horiz_y = vertical_y - strawWidth;
	
	Rectangle2D.Double verticalStraw =
	    new Rectangle2D.Double(vertical_x, vertical_y, strawWidth, verticalStrawLength);
	Rectangle2D.Double horizStraw =
            new Rectangle2D.Double(horiz_x, horiz_y, horizStrawLength, strawWidth);
	
	// add the straw to the waterbottle
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")
	
        GeneralPath wholeWaterBottle = this.get();
        wholeWaterBottle.append(verticalStraw, false);
	wholeWaterBottle.append(horizStraw, false);
    }    
}
