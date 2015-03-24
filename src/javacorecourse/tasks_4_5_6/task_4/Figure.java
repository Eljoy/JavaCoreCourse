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
  public  abstract class Figure
    {   private static int count;
        protected int x,y;
        
        protected Figure()
        {count++;}
        
        public  int getCount()
        { 
         return count;
        }
        
        public void setX(int x)
        {this.x = x;}
         
        public void setY(int y)
        {this.y=y;}
        
        public int getX()
        { return this.x;}
        
        public int getY()
        {return this.y;}
        
        public abstract void draw();
        
        public abstract void move(int x,int y);
       
    }
    
