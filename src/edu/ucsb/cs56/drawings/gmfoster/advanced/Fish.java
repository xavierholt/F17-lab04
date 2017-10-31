package edu.ucsb.cs56.drawings.gmfoster.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape; 

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;


public class Fish extends GeneralPathWrapper implements Shape
{
    
    public Fish(double x, double y, double length, double height)
    {
	
        GeneralPath tail = new GeneralPath();
	tail.moveTo(x,y);
	tail.lineTo(x - .25*length ,y + .3*height);
	tail.lineTo(x - .25*length ,y - .3*height);
	tail.lineTo(x,y);

	GeneralPath body = new GeneralPath();
	body.moveTo(x + .7*length, y - .4*height);
	body.lineTo(x,y);
	body.lineTo(x + .7*length, y + .4*height);

	Ellipse2D.Double head = new Ellipse2D.Double(x + .4*length, y - .4* height, .8* length,  .8* height);
	

        GeneralPath wholeFish = this.get();
        wholeFish.append(tail, false);
        wholeFish.append(body, false);
      	wholeFish.append(head, false);
    }
}
