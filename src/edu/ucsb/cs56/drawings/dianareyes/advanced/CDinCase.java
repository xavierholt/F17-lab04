package edu.ucsb.cs56.drawings.dianareyes.advanced;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.GeneralPath; 
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

/**
   A drawing of a CD inside of it case.
   @author Diana Reyes
   @version for CS56, F17, UCSB
*/

public class CDinCase extends CD implements Shape {
    /**
       Constructor
       @param x the coordinate of the left edge
       @param y the coordinate of the top
       @param r the radius of the CD
    */
    public CDinCase(double x, double y, double r)
    {	
        // Create the basic shell that we will be adding to
        super(x, y, r);
	
        double xIn = x - (x*.25); 
	double yIn = y - (y*.25);

	double widthIn = (r*2.5);
	double heightIn = widthIn;

	double widthOut = (r*3);
	double heightOut = widthOut;

	double xOut = x - (x*.50);
	double yOut = y - (y*.50);


        // The extended class adds a square around the first circle


        Rectangle2D.Double caseCD1 = 
	 	new Rectangle2D.Double(xIn, yIn,
				   widthIn, heightIn);

	Rectangle2D.Double caseCD2 = 
		new Rectangle2D.Double(xOut, yOut, widthOut, heightOut);

        // put the whole CD in case together
        GeneralPath CDcase = this.get();
        CDcase.append(caseCD1, false);
        CDcase.append(caseCD2, false);
        
    }

}
