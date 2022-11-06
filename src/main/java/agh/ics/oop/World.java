package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class World
{
    static void run(Direction dir)
{
        String direction=switch(dir)
        {
            case f-> "Zwierzak idzie do przodu, ";
            case b-> "Zwierzak idzie do tyłu, ";
            case r-> "Zwierzak skręca w prawo, ";
            case l-> "Zwierzak skręca w lewo, ";
        };
    System.out.print(direction);
}

    public static void main(String[] args)
    {
        Animal animal =new Animal(); //zwierzak na polu (2,2), NORTH
        System.out.println(animal.toString());

        Vector2d position=new Vector2d(2,3);
        System.out.println(animal.isAt(position)); //porównujemy pozycję (2,3) z polem naszego zwierzaka

        OptionsParser optionsParser=new OptionsParser();
        Scanner scanner=new Scanner(System.in);
        List<String> options=new ArrayList<>();

        System.out.println("Wprowadź kolejne kierunki zwierzaka [forward/f/backward/b/right/r/left]: ");
        while (true)
        {
            String choice = scanner.nextLine();;
            if(choice.equals("X")) //X kończy dodawanie
                break;
            else
                options.add(choice);
        }

        String[] optionsArray=new String[options.size()];
        optionsArray=options.toArray(optionsArray);
        //System.out.println(optionsParser.parse(optionsArray));

        for(MoveDirection dir: optionsParser.parse(optionsArray))
        {
            animal.move(dir);
            System.out.println(animal.toString());
        }
    }
}
