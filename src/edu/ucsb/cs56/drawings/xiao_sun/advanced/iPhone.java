package edu.ucsb.cs56.drawings.xiao_sun.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
/**                                                                             
   A Iphone                                                                      
                                                                                
   @author Xiao Sun                                                        
   @version for CS56, F17, UCSB                                                 
                                                                                
*/
public class iPhone extends mobilePhone implements Shape
{
    /**                                                                         
     * Constructor for objects of class iphone                               
     */
    public iPhone(double x, double y, double height, double width)
    {
        // construct the basic Phone shell                                      
        super(x,y,height,width);

        // get the GeneralPath that we are going to append stuff to             
        //GeneralPath gp = this.get();

        //screen
        Rectangle2D.Double screen =
            new Rectangle2D.Double(0.15*width+x, 0.17*height + y, 0.7*width, 0.6*height);
        //home button
        Ellipse2D.Double homeButton =
            new Ellipse2D.Double(x+0.5*width-width/12, y+0.85*height, width/6, width/6);

        // add the screen and button to the basic phone                                                                       

        GeneralPath wholePhone = this.get();
        wholePhone.append(screen, false);
        wholePhone.append(homeButton, false);
    }
}

