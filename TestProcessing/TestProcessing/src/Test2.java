/*
 * Minimal OpenGL Globe in Processing
 * By Dov Kruger
 * (c)2014 Ad Astra Education
 * Educational not-for-profit use permitted as long as this comment remains intact
 */
import processing.core.*;

public class Test2 extends PApplet {
  private float angle = 0;
  private PImage img;
  private PShape ball;

  public void setup() {
    size(900, 700, OPENGL); 		// Set window size and use OpenGL graphics
    noStroke();             		// do not draw edges for triangles in the globe 
    img = loadImage("earth.jpg");	// load in the picture of the earth
    sphereDetail(40); 		    	// create the sphere from a 40x40 grid of tiles
    ball = createShape(SPHERE, 240);// create a sphere with radius = 240 pixels
    ball.setTexture(img);			// attach the image to the sphere
    background(0);					// set background to black
  }

  public void draw() {
	lights();						// turn on the default lights
	translate(width/2, height/2);	// set origin to center of screen
	rotateY(angle);					// rotate around a vertical axis
	shape(ball);					// draw the globe at current orientation
	angle += 0.01;					// spin to next orientation
  }
}