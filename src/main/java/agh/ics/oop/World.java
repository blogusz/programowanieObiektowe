package agh.ics.oop;

public class World
{
    public static void main(String[] args)
    {
        //Program arguments f b r l f f r r f f f f f f f f
        IWorldMap map = new GrassField(10);
        MoveDirection[] direction = new OptionsParser().parse(args);
        Vector2d[] position = { new Vector2d(2,2), new Vector2d(3,4) };
        //System.out.println(map);

        SimulationEngine engine = new SimulationEngine(direction, map, position);
        engine.run();
        System.out.println(map);
    }
}
