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
public class main 
{
    public static void main(String[] args)
    {
       Line line=new Line();
       line.setX(4);
       line.setY(3);
       line.setLength(7);
     
       
       Rectangle rec=new Rectangle();
       rec.setX(3);
       rec.setY(3);
       rec.setLines(3, 3);
     
       
       Circle circle = new Circle();
       circle.setX(4);
       circle.setY(4);
       circle.setRadius(7);
        
       CompositeFigure figure = new CompositeFigure(3);
       
       System.out.println(figure.getCount());
       
       figure.addFigure(line);
       figure.addFigure(rec);
       figure.addFigure(circle);
       
       figure.draw();
       figure.move(4, 5);
     
        
        
      
    }
}
