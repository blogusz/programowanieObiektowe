package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest
{
    @Test
    void Test()
    {
        IWorldMap map = new RectangularMap(5,5);
        Animal animal1 = new Animal(map);
        Animal animal2 = new Animal(map);
        String[] dire1 = {"f", "r", "f", "l", "f", "r", "f", "f", "f", "l", "f", "f"};
        MoveDirection[] direction1 = OptionsParser.parse(dire1);

        String[] dire2 = {"b", "b", "b", "l", "f", "f", "f", "f"};
        MoveDirection[] direction2 = OptionsParser.parse(dire2);

        for (MoveDirection dir :direction1)
        {
            animal1.move(dir,map);
        }
        Assertions.assertTrue(animal1.isAt(new Vector2d(5, 5)));

        for (MoveDirection dir :direction2)
        {
            animal2.move(dir,map);
        }
        Assertions.assertTrue(animal2.isAt(new Vector2d(0, 0)));

        for (MoveDirection dir :direction2)
        {
            animal1.move(dir,map);
        }
        Assertions.assertEquals("W", animal1.toString());
        Assertions.assertEquals(new Vector2d(1, 2), animal1.getPosition());

        animal1.move(MoveDirection.LEFT,map);
        Assertions.assertEquals("S", animal1.toString());
    }
}