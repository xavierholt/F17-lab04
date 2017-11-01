package edu.ucsb.cs56.drawings.xiao_sun.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Xiao Sun 
 * @version for UCSB CS56, F17 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	mobilePhone p1 = new mobilePhone(100,250,100,50);
	g2.setColor(Color.CYAN); g2.draw(p1);
	
	// Make a black phone that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.BLACK); g2.draw(p2);
	
	// Here's a phone that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	p2 = ShapeTransforms.scaledCopyOfLL(p2,4,4);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(p2); 
	
	// Draw two iphones
	
	iPhone ip1 = new iPhone(50,50,100,50);
	iPhone ip2 = new iPhone(300,150,100,50);
	
	g2.draw(ip1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(ip2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few phones by Xiao Sun", 20,20);
    }
    
    
    /** Draw a picture with a few mobile phones and iPhones
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some mobile phones
	
	mobilePhone large = new mobilePhone(100,50,300,150);
	mobilePhone small = new mobilePhone(20,50,60,30);
	mobilePhone tall = new mobilePhone(20,150,80,40);
	mobilePhone verySmall = new mobilePhone(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tall);
	g2.setColor(Color.MAGENTA); g2.draw(verySmall);
	
	mobilePhone p1 = new mobilePhone(100,250,150,75);
	g2.setColor(Color.CYAN); g2.draw(p1);
	
	// Make a black phone that's half the size, 
	// and moved over 150 pixels in x direction
	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.BLACK); g2.draw(p2);
	
	// Here's a phone that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	p2 = ShapeTransforms.scaledCopyOfLL(p2,4,4);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(p2); 
	
	// Draw two iphones
	
	iPhone ip1 = new iPhone(50,350,120,60);
	iPhone ip2 = new iPhone(200,350,200,100);
	
	g2.draw(ip1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second phone 45 degrees around its center.
	Shape ip3 = ShapeTransforms.rotatedCopyOf(ip2, Math.PI/4.0);
	
	g2.draw(ip3);

        // Rotate the first around its center.                                                    
        Shape ip4 = ShapeTransforms.rotatedCopyOf(ip1, Math.PI/2.5);
	g2.setColor(new Color(0x2F0FF2));
        g2.draw(ip4);
	
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of mobile phones and a few iPhones by Xiao Sun", 20,20);
    }
    
    /** Draw a different picture with a few mobile phones and iPhones
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of mobilePhones by Xiao Sun", 20,20);
	
	
	// Draw some mobile phones.
	
	mobilePhone large = new mobilePhone(100,50,300,150);
	mobilePhone small = new mobilePhone(20,50,60,30);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	// Rotate the phone around its center.                                                    
        Shape largeOne = ShapeTransforms.rotatedCopyOf(large, Math.PI/3.0);
	g2.setColor(new Color(0x4F0FF2));
        g2.draw(largeOne);
    }       
}
