package edu.ucsb.cs56.drawings.yuhaozhang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

public class Door extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of door
       @param y y coord of lower left corner of door
       @param width width of the door
       @param height of door (including door handle)
    */
    public Door(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double bottomHandleHeight = .5 * height;
        double upperHandleHeight = .6 * height;
	double handleHeight = upperHandleHeight - bottomHandleHeight;
	
        // Make the first story
        
        Rectangle2D.Double handle = 
            new Rectangle2D.Double(x + 0.6 * width , y + upperHandleHeight,
				   0.35 * width, handleHeight);
	
        Rectangle2D.Double door =
            new Rectangle2D.Double(x, y, width, height);
                                  
	Ellipse2D.Double circleHandle =
	    new Ellipse2D.Double(x + 0.8 * width, y + upperHandleHeight, handleHeight, handleHeight);
        // put the whole door together
	
        GeneralPath wholeDoor = this.get();
        wholeDoor.append(handle, false);
        wholeDoor.append(door, false);
	wholeDoor.append(circleHandle, false);
    }
}