package edu.ucsb.cs56.drawings.dianareyes.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes
import java.awt.geom.Ellipse2D; //imported
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Diana Reyes 
   @version for CS56, F17, UCSB
   
*/
public class CD extends GeneralPathWrapper implements Shape
{
    /**
       Constructor 
       
       @param x x coord of lower left corner of CD
       @param y y coord of lower left corner of CD
       @param r the radius of the CD
    */
    public CD(double x, double y, double r)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double circum = 2*r;
        double firstHole = circum/3;
        double secondHole = firstHole/3;

	double bX = x;
	double bY = y;

	double mX = bX+(bX*.7);
	double mY = bY+(bY*.7); 
	double sX = mX+(mX*.13);
	double sY = mY+(mY*.13);
        
       Ellipse2D.Double biggest = new Ellipse2D.Double(bX, bY, circum, circum);
       Ellipse2D.Double bigger = new Ellipse2D.Double(mX, mY, firstHole, firstHole);
       Ellipse2D.Double big = new Ellipse2D.Double(sX, sY, secondHole, secondHole);
        // put the whole CD together
	
        GeneralPath cD = this.get();
        cD.append(biggest, false);
        cD.append(bigger, false);
        cD.append(big, false);    
    }
}
