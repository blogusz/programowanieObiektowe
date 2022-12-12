package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest
{
    @Test
    void canMoveToTest()
    {
        IWorldMap map = new GrassField(3);

        Assertions.assertTrue(map.canMoveTo(new Vector2d(2147483647,2147483647))); // skrajne wartości w górę
        Assertions.assertTrue(map.canMoveTo(new Vector2d(-2147483648, -2147483648))); // skrajne wartości w dół
    }

    @Test
    void isOccupiedTest()
    {
        IWorldMap map = new GrassField(3);
        Vector2d position1 = new Vector2d(10,11);
        Animal animal1 = new Animal(map, position1);
        map.place(animal1);

        int grassCounter = 0;

        for (int i = 0; i <= 5; i++) // górna granica mapy dla 3 kepęk trawy da ~upperRight=(5,5)
        {
            for (int j = 0; j <= 5; j++)
            {
                Vector2d dummy = new Vector2d(i, j); // co ppozycję tworzymy wektor i sprawdzamy, czy ta pozycja jest zajęta przez jedną z 3 kepek trawy
                if (map.isOccupied(dummy))
                    grassCounter++;
            }
        }

        Assertions.assertTrue(map.isOccupied(position1)); // sprawdzamy, czy pozycja jest zajętą przez zwierzaka
        Assertions.assertEquals(3, grassCounter); // oczekujemy, że natrafimy na wszystkie 3 kępki
    }

    @Test
    void placeTest()
    {
        IWorldMap map = new GrassField(3);
        Vector2d position1 = new Vector2d(3,7);
        Animal animal1 = new Animal(map, position1);
        Animal animal2 = new Animal(map, position1);

        Assertions.assertTrue(map.place(animal1));
        Assertions.assertEquals("There is another animal at (3,7)", Assertions.assertThrows(IllegalArgumentException.class, ()-> map.place(animal2)).getMessage());
    }

    @Test
    void objectAtTest()
    {
        IWorldMap map = new GrassField(3);
        Vector2d position1 = new Vector2d(6,7);
        Vector2d position2 = new Vector2d(6,9);
        Animal animal1 = new Animal(map, position1);
        Animal animal2 = new Animal(map, position2);
        map.place(animal1);
        map.place(animal2);

        Assertions.assertEquals(animal1, map.objectAt(position1));
        Assertions.assertNull(map.objectAt(new Vector2d(6,8)));
        Assertions.assertNotNull(map.objectAt(new Vector2d(6,9)));

        for (int i = 0; i <=5; i++)
        {
            for (int j = 0; j <=5; j++)
            {
                Vector2d dummy = new Vector2d(i, j);
                if (map.isOccupied(dummy))
                {
                    Object object = map.objectAt(dummy);
                    Assertions.assertTrue(object instanceof Grass);
                }
            }
        }
    }

}