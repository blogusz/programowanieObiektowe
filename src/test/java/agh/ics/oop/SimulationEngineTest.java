package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimulationEngineTest
{
    @Test
    void IntegrationTest()
    {
        String[] args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(6, 6);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Vector2d position1 = new Vector2d(2,1);
        Vector2d position2 = new Vector2d(3,5);
        Vector2d position3 = new Vector2d(0,0);

        Assertions.assertTrue(map.isOccupied(position1));
        Assertions.assertTrue(map.isOccupied(position2));
        Assertions.assertFalse(map.isOccupied(position3));

        Object object1 = map.objectAt(position1);
        Object object2 = map.objectAt(position2);
        Object object3 = map.objectAt(position3);

        Assertions.assertTrue(object1 instanceof Animal);
        Assertions.assertTrue(object2 instanceof Animal);
        Assertions.assertTrue(object3 == null);

        Animal animal1 = (Animal)object1;
        Animal animal2 = (Animal)object2;

        Assertions.assertEquals(MapDirection.SOUTH, animal1.getDirection());
        Assertions.assertEquals(MapDirection.NORTH, animal2.getDirection());
    }

}