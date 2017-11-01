package edu.ucsb.cs56.drawings.aberlanga.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, W16, UCSB
   
*/
public class Wheatie extends GeneralPathWrapper implements Shape
{

    public static double bodyWidthScaling;
    public static double bodyHeightScaling;
    public static double armWidthScaling;
    public static double legHeightScaling;
    /**
       Constructor
       
       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the house
       @param height of house (including first story and second story)
    */
    public Wheatie(double x, double y, double width, double height)
    {
	
	double wheatWidth = 0.6*width;
	this.bodyWidthScaling = 0.6;
	double wheatHeight = 0.7*height;
	this.bodyHeightScaling = 0.7;

	double legHeight = height-wheatHeight;
	this.legHeightScaling = (height-wheatHeight)/height;
	//double legWidth = 0.1*wheatWidth;
	
	double armWidth = (width-wheatWidth)/2;
	this.armWidthScaling = ((width-wheatWidth)/width)/2;
	double armHeight = 0.5*wheatHeight;


	double frostingWidth = 0.85*wheatWidth;
	double frostingHeight = 0.9*wheatHeight;

	double eyeDistance = 0.25;
	


	double centerWheatX = x + width/2;
	double centerWheatY = y + wheatHeight/2;
	double eyeRadius=0;

	
	// Information to create eyes for Wheatie
	if(frostingWidth>frostingHeight)
	{
	    eyeRadius = 0.1*frostingHeight;
	}
	else
	{
	    eyeRadius = 0.1*frostingWidth;
	}
	double leftEyeCoordx = x + armWidth + (wheatWidth-frostingWidth)/2 + eyeDistance*frostingWidth;
	double leftEyeCoordy = y + (wheatHeight-frostingHeight)/2 + eyeDistance*frostingHeight;

	double rightEyeCoordx = x + armWidth + wheatWidth - ((wheatWidth-frostingWidth)/2) - (eyeDistance*frostingWidth);
	double rightEyeCoordy = y + (wheatHeight-frostingHeight)/2 + eyeDistance*frostingHeight;

	//Information to draw rectangles for Wheatie Body
	double bodyCoordx = x + armWidth;
	double bodyCoordy = y;

	double frostingCoordx = x + armWidth + (wheatWidth-frostingWidth)/2 ;
	double frostingCoordy = y + (wheatHeight-frostingHeight)/2;



	//Information to draw arms and legs
	double legFromEdgeOfBody = wheatWidth*0.2;
	double legFromEdgeOfBodyToGround = wheatWidth*0.1;

	double leftArmCoordx_i = x + armWidth;
	double leftArmCoordy_i = centerWheatY;
	double leftArmCoordx_f = x;
	double leftArmCoordy_f = centerWheatY + armHeight;

	
	double rightArmCoordx_i = x + armWidth + wheatWidth;
	double rightArmCoordy_i = centerWheatY;
	double rightArmCoordx_f = x + width;
	double rightArmCoordy_f = centerWheatY + armHeight;


	double leftLegCoordx_i =  x + armWidth + legFromEdgeOfBody;
	double leftLegCoordy_i = y + wheatHeight;
	double leftLegCoordx_f = x + armWidth + legFromEdgeOfBodyToGround;
	double leftLegCoordy_f = y+height;
	
	double rightLegCoordx_i =  x + armWidth + wheatWidth - legFromEdgeOfBody;
	double rightLegCoordy_i = y + wheatHeight;
	double rightLegCoordx_f = x + armWidth + wheatWidth - legFromEdgeOfBodyToGround;
	double rightLegCoordy_f = y+ height;
	
	// Methods to draw Wheatie with information

	//Objects to draw frosting and body
	 Rectangle2D.Double wheatieBody = 
            new Rectangle2D.Double(bodyCoordx, bodyCoordy ,
				   wheatWidth, wheatHeight);
	 Rectangle2D.Double wheatieFrosting =
	     new Rectangle2D.Double(frostingCoordx,frostingCoordy,frostingWidth, frostingHeight);
	 //Objects to draw arms and legs
	 
	 Line2D.Double leftArm = 
            new Line2D.Double (leftArmCoordx_i, leftArmCoordy_i,
                               leftArmCoordx_f, leftArmCoordy_f);
	 Line2D.Double rightArm = 
            new Line2D.Double (rightArmCoordx_i, rightArmCoordy_i,
                               rightArmCoordx_f, rightArmCoordy_f);
	 Line2D.Double leftLeg = 
            new Line2D.Double (leftLegCoordx_i, leftLegCoordy_i,
                               leftLegCoordx_f, leftLegCoordy_f);
	 Line2D.Double rightLeg = 
            new Line2D.Double (rightLegCoordx_i, rightLegCoordy_i,
                               rightLegCoordx_f, rightLegCoordy_f);

	 // Objects to eyes
	 Circle leftEye = new Circle(leftEyeCoordx,leftEyeCoordy,eyeRadius);
	 Circle rightEye = new Circle(rightEyeCoordx,rightEyeCoordy,eyeRadius);

	 Ellipse2D.Double mouth = new Ellipse2D.Double(centerWheatX-(0.6*frostingWidth)/2, centerWheatY-(0.1*frostingHeight)/2, 0.6*frostingWidth, 0.1*frostingHeight 
);
	 
	 
	 
	 GeneralPath Wheatie = this.get();
        Wheatie.append(wheatieBody, false);
        Wheatie.append(wheatieFrosting, false);
        Wheatie.append(leftArm, false);
	Wheatie.append(rightArm, false);
	Wheatie.append(leftLeg, false);
	Wheatie.append(rightLeg, false);
	Wheatie.append(leftEye, false);
	Wheatie.append(rightEye, false);
	Wheatie.append(mouth,false);

	
	
	
	
	
    }

}
