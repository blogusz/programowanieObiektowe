package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest
{
    /**
     *
     * Testy nie działają, bo ich nie zrobiłem :(
     *
     */


    List<Animal> listOfAnimals = new ArrayList<>();

    @Test
    public void animal_position2()
    {
        String[] args={"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};

        List<MoveDirection> directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);

        for (Vector2d position : positions)
        {
            Animal animal = new Animal(map, position);
            if (map.place(animal))
            {
                listOfAnimals.add(animal);
            }
        }
        assertTrue();

        assertEquals('S', engine.run());

    }
}