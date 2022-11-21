package agh.ics.oop;

import java.util.List;

public class World
{
    public static void main(String[] args)
    {
        /*
        * PROGRAM NALEZY URUCHOMIĆ PRZEZ PODANIE f b r l f f r r f f f f f f f f jako Program arguments
        */

        /*kod z zadania 6*/
        List<MoveDirection> directions=new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        /*W celu wywołania metody toString rzutujemy mapę na typ RectangularMap*/
        RectangularMap rectangularMap = (RectangularMap) map;
        rectangularMap.toString(map);



//        OptionsParser optionsParser=new OptionsParser();
//        Scanner scanner=new Scanner(System.in);
//        List<String> options=new ArrayList<>();
//
//        System.out.println("Wprowadź kolejne kierunki zwierzaka [forward/f/backward/b/right/r/left]: ");
//        while (true)
//        {
//            String choice = scanner.nextLine();;
//            if(choice.equals("X")) //X kończy dodawanie
//                break;
//            else
//                options.add(choice);
//        }
//
//        String[] optionsArray=new String[options.size()];
//        optionsArray=options.toArray(optionsArray);
//        //System.out.println(optionsParser.parse(optionsArray));
//
//        for(MoveDirection dir: optionsParser.parse(optionsArray))
//        {
//            animal.move(dir,rectangularMap);
//            System.out.println(animal.toString());
//        }
    }
}
