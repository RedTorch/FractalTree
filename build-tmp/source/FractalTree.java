import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FractalTree extends PApplet {

private double fractionLength = .8f; 
private int smallestBranch = 5; 
private double branchAngle = 7;
public int mouseCharge = 0;
ArrayList <Integer> trees = new ArrayList();
public void setup() 
{   
	size(640,480); 
	noLoop(); 
} 
public void draw() 
{   
	background(0,0,100); 
	fill(0,15,0);  
	stroke(0,40,640,40);   
	strokeWeight(4);
	line(320,480,320,280);   
	//strokeWeight(2);
	drawBranches(320,280,100,360);
	drawBranches(320,280,100,380);
	drawBranches(320,280,100,340);
	drawBranches(320,280,50,370);
	drawBranches(320,280,50,350);
	for(int i = 0; i > trees.size(); i++)
	{
		stroke(0,15,0);   
		strokeWeight(4);
		line(trees.get(i),480,trees.get(i),280);
		println(i);   
		drawBranches(trees.get(i),280,100,360);
		drawBranches(trees.get(i),280,100,380);
		drawBranches(trees.get(i),280,100,340);
		drawBranches(trees.get(i),280,50,370);
		drawBranches(trees.get(i),280,50,350);
	}
} 
public void drawBranches(int x,int y, double branchLength, double angle)
{
	line(x,y,x+(int)(Math.cos((int)angle)*branchLength),y-(int)(Math.sin((int)angle)*branchLength));
	//ellipse(x+(int)(Math.cos((int)angle)*branchLength),y-(int)(Math.sin((int)angle)*branchLength),10,10);
	//ellipse(x,y,10,10);
	if(branchLength>=smallestBranch)
	{	
		drawBranches(x+(int)(Math.cos((int)angle)*branchLength),y-(int)(Math.sin((int)angle)*branchLength),(int)(branchLength/2),angle+(branchAngle)*2-0.25f+Math.random());
		drawBranches(x+(int)(Math.cos((int)angle)*branchLength),y-(int)(Math.sin((int)angle)*branchLength),(int)(branchLength/2),angle+branchAngle-0.25f+Math.random()/2);
		drawBranches(x+(int)(Math.cos((int)angle)*branchLength),y-(int)(Math.sin((int)angle)*branchLength),(int)(branchLength/2),angle+0.5f+Math.random());
		drawBranches(x+(int)(Math.cos((int)angle)*branchLength),y-(int)(Math.sin((int)angle)*branchLength),(int)(branchLength/2),angle-branchAngle+0.25f-Math.random());
		drawBranches(x+(int)(Math.cos((int)angle)*branchLength),y-(int)(Math.sin((int)angle)*branchLength),(int)(branchLength/2),angle-(branchAngle)*2+0.25f-Math.random());
		//println(x,y);
	}
}
public void mousePressed()
{
	mouseCharge++;
}
public void mouseReleased()
{
	trees.add(mouseCharge);
	//println("random");
	mouseCharge=0;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
