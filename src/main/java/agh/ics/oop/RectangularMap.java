package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap
{
    private final int width;
    private final int height;
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    private final List<Animal> listOfAnimals = new ArrayList<>();

    public RectangularMap(int width, int height)
    {
        this.width=width;
        this.height=height;
        this.lowerLeft=new Vector2d(0,0);
        this.upperRight=new Vector2d(width,height);
    }

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        if(!isOccupied(position))
        {
            if(!position.follows(lowerLeft) || !position.precedes(upperRight))
                return false;
            else
                return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal)
    {
        Vector2d position = animal.getPosition();

        if (isOccupied(position))
            return false;
        else
        {
            listOfAnimals.add(animal);
            return true;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        if(objectAt(position) != null)
        {
            return true;
        }
        else
            return false;
    }

    @Override
    public Object objectAt(Vector2d position)
    {
        for(Animal animal: listOfAnimals)
        {
            Vector2d temp = animal.getPosition();
            if(temp.x == position.x && temp.y == position.y)
            {
                return position;
            }
        }
        return null;
    }
    public void toString(IWorldMap map)
    {
        System.out.println(new MapVisualizer(map).draw(this.lowerLeft, this.upperRight));
    }
}


