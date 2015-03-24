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
public class Rectangle  extends Figure
{   protected int x_line_length, y_line_length;
     
    public void setLines(int x_line_length, int y_line_length)
    {
        this.x_line_length = x_line_length;
        this.y_line_length = y_line_length;
    }
     public void draw()
    { 
        String figure;
        
        if(this.x_line_length == this.y_line_length) figure = "Square";
        
        else figure = "Rectangle";
        
    System.out.println(figure + " has been drawn from the point: x = "+this.x+
            " y = "+this.y+" x line = "+this.x_line_length+
            " y line = "+this.y_line_length);
    
   
      
    }
     
    public void move(int x, int y)
    {
     this.x=this.x+x;
     this.y=this.y+y;
     System.out.println("Rectangle has been move to the point: x = "+this.x+
            " y = "+this.y);
    }
    
}
