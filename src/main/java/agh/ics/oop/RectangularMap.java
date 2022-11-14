package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap
{
    private final int width;
    private final int height;


    public RectangularMap(int width, int height)
    {
        this.width = width ;
        this.height = height ;

        this.upperRight = new Vector2d(width, height);
        this.drawUpperRight = new Vector2d(width, height);

        this.lowerLeft = new Vector2d(0,0);
        this.drawLowerLeft = new Vector2d(0,0);

        this.animals = new ArrayList<Animal>();
    }

    @Override
    public Object objectAt(Vector2d position)
    {
        if(super.objectAt(position) != null)
            return super.objectAt(position);
        else
            return null;
    }

    @Override
    public void drawBounds() // ustalenie granic rysowanej mapy
    {
        drawLowerLeft = this.lowerLeft;
        drawUpperRight = this.upperRight;
    }

}


