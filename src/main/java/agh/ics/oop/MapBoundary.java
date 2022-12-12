package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver
{
    private SortedSet<Vector2d> zbiorOX = new TreeSet<>(Comparator.comparingInt(object->object.x));
    private SortedSet<Vector2d> zbiorOY = new TreeSet<>(Comparator.comparingInt(object->object.y));
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {
        remove(oldPosition);
        add(newPosition);
    }

    public void add(Vector2d position)
    {
        this.zbiorOX.add(position);
        this.zbiorOY.add(position);
    }

    public void remove(Vector2d position)
    {
        this.zbiorOX.remove(position);
        this.zbiorOY.remove(position);
    }

    public Vector2d getLowerLeft()
    {
        Vector2d lowerLeft=new Vector2d(this.zbiorOX.first().x, this.zbiorOY.first().y);
        return lowerLeft;
    }


    public Vector2d getUpperRight()
    {
        Vector2d upperRight=new Vector2d(this.zbiorOX.last().x, this.zbiorOY.last().y);
        return upperRight;
    }


}
