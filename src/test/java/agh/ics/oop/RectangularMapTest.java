package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest
{
    @Test
    void canMoveToTest()
    {
        IWorldMap map = new RectangularMap(3, 7);

        Assertions.assertTrue(map.canMoveTo(new Vector2d(1,0)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(3,7)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(2, 8)));
    }

    @Test
    void isOccupiedTest()
    {
        IWorldMap map = new RectangularMap(3, 7);
        Vector2d position1 = new Vector2d(2,3);
        Vector2d position2 = new Vector2d(1,1);
        Vector2d position3 = new Vector2d(0,2);
        Animal animal1 = new Animal(map, position1);
        Animal animal2 = new Animal(map, position2);
        Animal animal3 = new Animal(map, position3);
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        Assertions.assertTrue(map.isOccupied(position1));
        Assertions.assertTrue(map.isOccupied(position2));
        Assertions.assertTrue(map.isOccupied(position3));
        Assertions.assertFalse(map.isOccupied(new Vector2d(0,1)));
    }

    @Test
    void placeTest()
    {
        IWorldMap map = new RectangularMap(3, 7);
        Vector2d position1 = new Vector2d(2,3);
        Vector2d position2 = new Vector2d(2,3);
        Vector2d position3 = new Vector2d(4,8);
        Animal animal1 = new Animal(map, position1);
        Animal animal2 = new Animal(map, position2);
        Animal animal3 = new Animal(map, position3);

        Assertions.assertTrue(map.place(animal1));
        Exception exception_position1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> map.place(animal2));
        Assertions.assertEquals("There is another animal at (2,3)", exception_position1.getMessage());
        Exception exception_position2 = Assertions.assertThrows(IllegalArgumentException.class, ()-> map.place(animal3));
        Assertions.assertEquals("Animal can't move to (4,8)", exception_position2.getMessage());
    }

    @Test
    void objectAtTest()
    {
        IWorldMap map = new RectangularMap(3, 7);
        Vector2d position1 = new Vector2d(2,3);
        Vector2d position2 = new Vector2d(0,5);
        Animal animal1 = new Animal(map, position1);
        Animal animal2 = new Animal(map, position2);
        map.place(animal1);
        map.place(animal2);

        Assertions.assertEquals(animal1, map.objectAt(position1));
        Assertions.assertEquals(animal2, map.objectAt(position2));
        Assertions.assertNotEquals(animal1, map.objectAt(position2));
        Assertions.assertNotEquals(animal2, map.objectAt(position1));
    }

}