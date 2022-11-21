package agh.ics.oop;

public class World
{
    public static void main(String[] args)
    {
        // Program arguments f b r l f f r r f f f f f f f f jako

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };


        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);

    }
}
