package edu.ucsb.cs56.drawings.aberlanga.advanced;

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
 * @author Phill Conrad 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Wheatie w1 = new Wheatie(100,250,50,75);
	g2.setColor(Color.ORANGE); g2.draw(w1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape w2 = ShapeTransforms.scaledCopyOfLL(w1,0.5,0.5);
	w2 = ShapeTransforms.translatedCopyOf(w2,150,0);
	g2.setColor(Color.BLACK); g2.draw(w2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	w2 = ShapeTransforms.scaledCopyOfLL(w2,4,4);
	w2 = ShapeTransforms.translatedCopyOf(w2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(w2); 
	
	// Draw two houses with Windows
	
	SuperWheatie s1 = new SuperWheatie(50,350,40,75);
	SuperWheatie s2 = new SuperWheatie(200,350,200,100);
	
	g2.draw(s1);
	g2.setColor(Color.RED); g2.draw(s2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Frosted Wheaties, Stay Frosty My Friends by Alex Berlanga", 20,20);
    }
    
    
    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	SuperWheatie large = new SuperWheatie(100,50,225,150);
	Wheatie smallCC = new Wheatie(20,50,40,30);
	Wheatie tallSkinny = new Wheatie(20,150,20,40);
	Wheatie shortFat = new Wheatie(20,250,40,20);
	
	g2.setColor(Color.BLACK);     g2.draw(large);
	g2.setColor(Color.ORANGE);   g2.draw(smallCC);
	g2.setColor(Color.CYAN);    g2.draw(tallSkinny);
	g2.setColor(Color.RED); g2.draw(shortFat);
	
	Wheatie w1 = new Wheatie(100,250,100,100);
	g2.setColor(Color.CYAN); g2.draw(w1);
	
	// Make a orange wheatie that's half the size, 
	// and moved over 150 pixels in x direction
	Shape w2 = ShapeTransforms.scaledCopyOfLL(w1,0.5,0.5);
	w2 = ShapeTransforms.translatedCopyOf(w2,150,0);
	g2.setColor(Color.ORANGE); g2.draw(w2);
	
	// Here's a wheatie that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	w2 = ShapeTransforms.scaledCopyOfLL(w2,4,4);
	w2 = ShapeTransforms.translatedCopyOf(w2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x001111)); 
	g2.draw(w2); 
	
	// Draw two SuperWheaties
	
	SuperWheatie s1 = new SuperWheatie(50,350,50,50);
	SuperWheatie s2 = new SuperWheatie(200,350,200,200);
	
	g2.draw(s1);
	g2.setColor(new Color(0x888888)); 
	g2.draw(s2);
	// Rotate the second wheatie 45 degrees around its center.
	Shape s3 = ShapeTransforms.rotatedCopyOf(s2, Math.PI/4);
	s3 = ShapeTransforms.translatedCopyOf(s3,200,100);

	



	
	
	g2.draw(s3);

	s3 = ShapeTransforms.rotatedCopyOf(s2, Math.PI/2);
	s3 = ShapeTransforms.translatedCopyOf(s3,400,200);
	g2.setColor(Color.RED);
	g2.draw(s3);

	s3 = ShapeTransforms.rotatedCopyOf(s2, Math.PI);
	s3 = ShapeTransforms.translatedCopyOf(s3,650,300);
	g2.setColor(Color.BLACK);
	g2.draw(s3);
	
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.ORANGE); 
	g2.drawString("You either die a hero, or live long enough to become SuperWheatie by Alex Berlanga", 20,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Heroes Come In All Flavors by Alex Berlanga", 20,20);
	
	
	// Draw some Wheaties.
	
	SuperWheatie large = new SuperWheatie(100,50,225,300);
	Wheatie smallW = new Wheatie(20,50,40,30);
	
	g2.setColor(Color.BLACK);     g2.draw(large);
	g2.setColor(Color.ORANGE);   g2.draw(smallW);
	Shape w = smallW;
	w  = ShapeTransforms.rotatedCopyOf(w, -Math.PI/4);
	w = ShapeTransforms.translatedCopyOf(w,265,-10);
	w = ShapeTransforms.scaledCopyOf(w,4,6);
	g2.setColor(Color.ORANGE); g2.draw(w);
	
    }
    
    public static void drawPicture4(Graphics2D g2){
	g2.drawString("A plain Wheatie with frosting, just add Milk by Alex Berlanga",20,20);

	Wheatie largeWheat = new Wheatie(150,100,200,300);
	Wheatie smallWheat = new Wheatie(20,50,40,30);
	SuperWheatie superWheat = new SuperWheatie(150, 500, 200, 300);

	g2.draw(largeWheat);
	g2.draw(smallWheat);
	g2.draw(superWheat);

    }
}
