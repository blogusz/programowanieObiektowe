package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements  IEngine
{
    public  MoveDirection[] listOfDirections;
    public IWorldMap map;
    public Vector2d[] initialPositions;
    private final List<Animal> listOfAnimals = new ArrayList<>();

    //public SimulationEngine(List<MoveDirection> directions, IWorldMap map, Vector2d[] initialPositions)
    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initialPositions)
    {
        this.listOfDirections = directions;
        this.map = map;
        this.initialPositions=initialPositions;

        for(Vector2d initialPosition: initialPositions)
        {
            Animal animal = new Animal(map, initialPosition);

            if(map.place(animal))
                this.listOfAnimals.add(animal);

        }
    }
@Override
    public void run()
    {
        int i = 0;

        for (MoveDirection direction : this.listOfDirections)
        {
            if(i < this.listOfAnimals.size())
            {
                Animal animal = this.listOfAnimals.get(i);
                animal.move(direction, this.map);
            }

            i++;

            if(i == this.listOfAnimals.size())
            {
                i = 0;
            }
        }

        for(Animal animal: this.listOfAnimals)
        {
            System.out.println(animal.toString());
        }
    }

}
