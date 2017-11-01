package edu.ucsb.cs56.drawings.mberlanga.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

/**
   A Fancy Stick Figure
      
   @author Miguel Berlanga 
   @version for CS56, F17, UCSB
   
*/
public class FancyStickFigure extends CasualStickFigure implements Shape
{
    /**
     * Constructor for objects of class FancyStickFigure
     */
    public FancyStickFigure(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append stuff to

	final double head_height = 50;
	GeneralPath gp = this.get(); //was gp

	GeneralPath hat_Bottom = new GeneralPath();
	hat_Bottom.moveTo(x+100,y+130);
	hat_Bottom.lineTo(x+100+width,y+130);
	
	
	
	double top_Shift = x+100+(width*0.1);// attempts to slide top_part of hat into middle
	double hat_Ht =  20; //makes the hat size scale with height of the stick
	double  top_Head= y+110; //locates the top of sticks head
	double hat_Width = width - (0.2 *width); // makes width of hat scale with width of stick
	// make the hat top for the hat that fancy stick will wear
	Rectangle2D.Double hat_Top =
	    new Rectangle2D.Double(top_Shift, top_Head, hat_Width,hat_Ht);
	
	
        GeneralPath fancyStick = this.get();
        fancyStick.append(hat_Top, false);
	fancyStick.append(hat_Bottom,false); //put hat bottom here
    }    
}
