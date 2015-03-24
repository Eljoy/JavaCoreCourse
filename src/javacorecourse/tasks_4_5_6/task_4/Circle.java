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
public class Circle extends Figure
{
    protected int radius;
    
   public void setRadius(int radius)
   {this.radius=radius;}
   
     public void draw()
    {
    System.out.println("Circle has been drawn from the point: x = "+this.x+
            " y = "+this.y+" radius = "+this.radius);}
     
    public void move(int x, int y)
    {
     this.x=this.x+x;
     this.y=this.y+y;
     System.out.println("Circle has been move to the point: x = "+this.x+
            " y = "+this.y);
    }
}
