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
public class CompositeFigure  extends Figure
{   private int n, i=0;
    private Figure[] figures;
    
    public CompositeFigure(int n)
    {
        this.n = n;
        figures=new Figure[n];
    }
    
    
    public void addFigure(Figure figure)
    { 
        try{
        figures[i]=figure;
        i++;
        }
    catch(IndexOutOfBoundsException e)
    {System.out.println("Out of array's range!");}
        
    }    
    
    public void draw()
    {
      for(int j=0; j<figures.length; j++)
      { 
          if(figures[j] == null) break;
          figures[j].draw();
      }    
    }
    
    public void move(int x, int y)
    {
      for(int j=0; j<figures.length; j++)
      { 
          if(figures[j] == null) break;
          figures[j].move(x,y);
      }   
    }

}
