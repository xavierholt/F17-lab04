package edu.ucsb.cs56.drawings.xiao_sun.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves                                                
import java.awt.Shape; // general class for shapes                                                                   

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

/**                                                                                                                  
   A vector drawing of a mobile that implements                                                                       
   the Shape interface, and so can be drawn, as well as                                                              
   rotated, scaled, etc.                                                                                                                                                                                                  
   @author Xiao Sun                                                                                        
   @version for CS56, F17, UCSB                                                                                      
                                                                                                                     
*/

public class mobilePhone extends GeneralPathWrapper implements Shape{
    public mobilePhone(double  x, double y, double height, double width){

                                                                                 

        //mainbody
        Rectangle2D.Double mainBody = new Rectangle2D.Double(x, y ,width, height);
        //receiver
        Rectangle2D.Double receiver = new Rectangle2D.Double(x+0.45*width, y+0.1*height ,width/7, width/100);
        //camera
        Ellipse2D.Double camera = new Ellipse2D.Double(x+0.35*width, y+0.1*height ,width/100, width/100);
        // put the whole mobile phonetogether                                                                              

        GeneralPath wholePhone = this.get();
        wholePhone.append(mainBody, false);
        wholePhone.append(receiver, false);
        wholePhone.append(camera, false);
    }

}