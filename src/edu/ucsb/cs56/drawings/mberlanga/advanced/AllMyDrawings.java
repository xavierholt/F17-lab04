package edu.ucsb.cs56.drawings.mberlanga.advanced;

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
    //Draws some stick figures of different varieties
    
    public static void drawPicture1(Graphics2D g2) {
	
;
	CasualStickFigure  cs1= new CasualStickFigure(150,100,50,100);

	g2.setColor(Color.RED); g2.draw(cs1);

	

	Shape cs2 = ShapeTransforms.scaledCopyOfLL(cs1,0.5,0.5); 
	cs2 = ShapeTransforms.translatedCopyOf(cs2,150,0);
	g2.setColor(Color.BLACK); g2.draw(cs2);
	
	
	cs2 = ShapeTransforms.scaledCopyOfLL(cs2,4,4); 
	cs2 = ShapeTransforms.translatedCopyOf(cs2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 

	g2.draw(cs2);
	
	//draw 2 fancy sticks
	FancyStickFigure fs1 = new FancyStickFigure(0,50,100,200); //commented code given
	FancyStickFigure fs2 = new FancyStickFigure(100,25,50,100);
	
	g2.draw(fs1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(fs2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("The Storming of The Bastille by Miguel Berlanga", 20,20);
    }
    
    //***************************************************
    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	CasualStickFigure large = new CasualStickFigure(100,50,225,150);
	CasualStickFigure smallCC = new CasualStickFigure(20,50,40,30);
	CasualStickFigure tallSkinny = new CasualStickFigure(20,150,20,40);
	CasualStickFigure shortFat = new CasualStickFigure(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	CasualStickFigure cs1 = new CasualStickFigure(100,150,50,75);
	g2.setColor(Color.YELLOW); g2.draw(cs1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	Shape cs2 = ShapeTransforms.scaledCopyOfLL(cs1,0.5,0.5);
	cs2 = ShapeTransforms.translatedCopyOf(cs2,150,0);
	g2.setColor(Color.BLACK); g2.draw(cs2);
	

	cs2 = ShapeTransforms.scaledCopyOfLL(cs2,4,4);
	cs2 = ShapeTransforms.translatedCopyOf(cs2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (7.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x000FA7)); 
	g2.draw(cs2); 
       
	
	FancyStickFigure fs1 = new FancyStickFigure(340,35,40,75);
	FancyStickFigure fs2 = new FancyStickFigure(-50,-20,100,70);
	
	g2.draw(fs1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	Shape fs3 = ShapeTransforms.rotatedCopyOf(fs2, Math.PI/4.0);	
	g2.draw(fs3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some are Gucci, Some Aren't by Miguel Berlanga", 20,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("An artistic rendition of the cold war", 20,20);
	
	
	// Draw some coffee cups.
	
	CasualStickFigure large = new CasualStickFigure(100,50,225,150);
	FancyStickFigure smallCC = new FancyStickFigure(20,50,40,100);
	
	g2.setColor(Color.BLACK);     g2.draw(large);
	g2.setColor(Color.BLUE);   g2.draw(smallCC);
	
    }       
}
