package edu.ucsb.cs56.drawings.mmaatubang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

/**
   A Bag (wrapper around a General Path, implements Shape)

   @author Matthew Maatubang
   @version for CS56, F17, UCSB
   @credit Adapted from CoffeeCup by Phil Conrad
   
*/

public class Bag extends GeneralPathWrapper implements Shape
{   
    /**
     * Constructor for objects of class Bag
    */
    public Bag(double x, double y, double width, double height)
    {
	
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* coffee cup
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 300.0; 
        final double ORIG_WIDTH = 400.0; 
        
        GeneralPath leftSide = new GeneralPath();
	
        // left side of cup
	
        leftSide.moveTo(150,400);
        leftSide.lineTo(135,360);
        leftSide.lineTo(110,300);
        leftSide.lineTo(100,200);
        leftSide.lineTo(100,100);
        
        GeneralPath topAndBottom = new GeneralPath();
       
        topAndBottom.moveTo(100,100);
        topAndBottom.lineTo(500,100); // top of cup
        
        topAndBottom.moveTo(150,400);
        topAndBottom.lineTo(450,400); // bottom of cup
       
        Shape rightSide = ShapeTransforms.horizontallyFlippedCopyOf(leftSide);
       
        // after flipping around the upper left hand corner of the
        // bounding box, we move this over to the right by 400 pixels
       
        rightSide = ShapeTransforms.translatedCopyOf(rightSide, 400.0, 0.0);
       
        // now we put the whole thing together ino a single path.

	GeneralPath insideHandle = new GeneralPath();

	insideHandle.moveTo(250, 100);
	insideHandle.curveTo(295, 65, 305, 65, 350, 100);

	GeneralPath outsideHandle = new GeneralPath();

	outsideHandle.moveTo(220, 100);
	outsideHandle.curveTo(290, 40, 310, 40, 380, 100);
	
        GeneralPath wholeBag = new GeneralPath ();
        wholeBag.append(topAndBottom, false);
        wholeBag.append(leftSide, false);
        wholeBag.append(rightSide, false);
	wholeBag.append(insideHandle, false);
	wholeBag.append(outsideHandle, false);

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeBag, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	this.set(new GeneralPath(s));
        
    }

}
