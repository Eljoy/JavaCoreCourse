package javacorecourse.task_9;

import javacorecourse.tasks_4_5_6.task_4.Figure;

import java.util.LinkedList;

/**
 * Created by Home on 18.11.2014.
 */
public class Collections_task
{

    private int n, i=0;
    private LinkedList <Figure> figures;


    public void addFigure(Figure figure)
    {
        figures.add(figure);

    }

    public void draw()
    {
        for (Figure figure : figures) {
            figure.draw();
        }

    }

    public void move(int x, int y)
    {
        for (Figure figure : figures) {
            figure.move(x,y);
        }

    }

}
