package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap
{
    private final int width;
    private final int height;


    public RectangularMap(int width, int height)
    {
        this.width = width;
        this.height = height;

        this.upperRight = new Vector2d(width, height);
        this.drawUpperRight = new Vector2d(width, height);

        this.lowerLeft = new Vector2d(0,0);
        this.drawLowerLeft = new Vector2d(0,0);

    }

    @Override
    public void drawBounds() // ustalenie granic rysowanej mapy
    {
        drawLowerLeft = this.lowerLeft;
        drawUpperRight = this.upperRight;
    }

}


