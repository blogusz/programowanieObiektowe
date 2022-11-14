package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap
{
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    protected Vector2d drawLowerLeft; // lewy dolny róg rysowanej mapy
    protected Vector2d drawUpperRight; // prawy górny róg rysowanej mapy
    ArrayList<Animal> animals = new ArrayList<>();

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return position.precedes(this.upperRight) && position.follows(this.lowerLeft);
    }
    @Override
    public boolean isOccupied(Vector2d position)
    {
        for (Animal animal: this.animals)
        {
            if (animal.isAt(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position)
    {
        for (Animal animal: this.animals)
        {
            if (animal.isAt(position))
                return animal;
        }
        return null;
    }
    @Override
    public boolean place(Animal animal)
    {
        if (!canMoveTo(animal.getPosition()))
            return false;
        if (isOccupied(animal.getPosition()) && (objectAt(animal.getPosition()) instanceof Animal)) // sprawdzamy, czy zajmowane pole nalezy do innego zwierzaka, czy może do kępki trawy
            return false;
        this.animals.add(animal);
        return true;
    }

    @Override
    public String toString()
    {
        MapVisualizer visualizer = new MapVisualizer(this);
        drawBounds();

        return visualizer.draw(this.drawLowerLeft, this.drawUpperRight); // rysujemy mape opierając się na uzyskanych lewym dolnym i prawym gornym rogu mapy
    }
    public abstract void drawBounds(); // funkcja ustalająca granice rysowanego obszaru mapy

}
