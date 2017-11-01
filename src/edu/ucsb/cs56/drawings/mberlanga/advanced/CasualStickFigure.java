package edu.ucsb.cs56.drawings.mberlanga.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

/**
   A Coffee Cup (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.   
      
   @author Miguel Berlanga
   @version for CS56, F17, UCSB
   
*/
public class CasualStickFigure extends GeneralPathWrapper implements Shape
{   
    /**
     * Constructor for objects of class CoffeeCup
     */
    public CasualStickFigure(double x, double y, double width, double height)
    {
	
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* stick figure
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 150.0; 
        final double ORIG_WIDTH = 40;
	
	Ellipse2D.Double stickHead = new Ellipse2D.Double(205, 230, ORIG_WIDTH-10,ORIG_WIDTH+10); //was 200,250
	

	GeneralPath leftRightArms = new GeneralPath();
	// the left and right arms of the Stick Figure...note that perfect 1:1 ratio from the x length of the legs
	leftRightArms.moveTo(200,300);
	leftRightArms.lineTo(240,300);
        
        GeneralPath leftLeg = new GeneralPath();
	
        // left leg of stick figure...note that perfect 2:1 ratio of x to y
	
        leftLeg.moveTo(200,400);
        leftLeg.lineTo(220,360);
        
        GeneralPath body = new GeneralPath();

	// body of stick figure....note that perfect 2x ratio of y leg height to body
       
        body.moveTo(220,360);
        body.lineTo(220,280); // top of cup
        
 
       
       GeneralPath rightLeg = new GeneralPath();
	
        // left leg of stick figure...note that perfect 2:1 ratio of x to y
	
        rightLeg.moveTo(240,400);
        rightLeg.lineTo(220,360);
       
        // now we put the whole thing together ino a single path.

	//append stickHead, body, leftRightArms, leftLeg, rightLeg
        GeneralPath wholeStick = new GeneralPath ();
        wholeStick.append(body, false);
        wholeStick.append(leftLeg, false);
        wholeStick.append(rightLeg, false);
	wholeStick.append(leftRightArms, false);
	wholeStick.append(stickHead, false);

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeStick, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	this.set(new GeneralPath(s));
        
    }

}
