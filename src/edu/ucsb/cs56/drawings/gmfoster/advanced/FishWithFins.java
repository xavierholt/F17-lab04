package edu.ucsb.cs56.drawings.gmfoster.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Ellipse2D;

public class FishWithFins extends Fish implements Shape
{
    public FishWithFins(double x, double y, double length, double height)
    {
	super(x,y,length,height);
	
	GeneralPath gp = this.get();
	
	Ellipse2D.Double bub1 =
	    new Ellipse2D.Double(x + .4 * length, y - 1.2 * height, .1* length, .1 * length);
	Ellipse2D.Double bub2 =
	    new Ellipse2D.Double(x + .6 * length, y -1.5 * height, .12 * length, .12 * length);
	Ellipse2D.Double bub3 =
	    new Ellipse2D.Double(x, y - 1.8 * height, .08 * length, .08 * length);

	GeneralPath fin1 = new GeneralPath();
	fin1.moveTo(x + .2* length ,y);
	fin1.lineTo(x + .4* length ,y);
	fin1.lineTo(x + .3* length ,y + .3*height);
	fin1.lineTo(x + .2* length ,y);

	Ellipse2D.Double eye =
	    new Ellipse2D.Double(x + length, y - .1 * height, .1 * length, .1 * length);
    
        GeneralPath wholeFish = this.get();
        wholeFish.append(bub1, false);
        wholeFish.append(bub2, false);
        wholeFish.append(bub3, false);
	wholeFish.append(eye, false);
	wholeFish.append(fin1, false);
    }    
}
