/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacorecourse.tasks_4_5_6.task_4;

/**
 *
 * @author Home
 */
public class Line extends Figure
{  protected int length, angle;
    public void setLength(int length)
    
    {this.length = length;}
    
    public void setAngle(int angle)
    {this.angle = angle;}        
    
    public void draw()
    {
    System.out.println("Line has been drawn from the point: x = "+this.x+
            " y = "+this.y +" with length = "+this.length+
            " with angle = "+this.angle);
    }
    
    public void move(int x, int y)
    {
     this.x=this.x+x;
     this.y=this.y+y;
     System.out.println("Line has been move to the point: x = "+this.x+
            " y = "+this.y);
    }
   
}
