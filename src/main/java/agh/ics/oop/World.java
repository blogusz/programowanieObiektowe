package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class World
{
//    static void run(Direction[] kierunki)
//    {
//        System.out.println("\nZwierzak idzie do przodu\n");//ZADANIE 8
//
//        for (int i = 0; i < kierunki.length-1; i++)        //ZADANIE 11
//        {
//            System.out.print(kierunki[i]+", ");
//        }
//        System.out.println(kierunki[kierunki.length-1]);
//
//        for (int i = 0; i <kierunki.length-1 ; i++)         //ZADANIE 14
//        {
//            switch(kierunki[i])
//            {
//                case f-> System.out.print("Zwierzak idzie do przodu, ");
//                case b-> System.out.print("Zwierzak idzie do tyłu, ");
//                case r-> System.out.print("Zwierzak skręca w prawo, ");
//                case l-> System.out.print("Zwierzak skręca w lewo, ");
//            }
//        }
//        switch(kierunki[kierunki.length-1])
//        {
//            case f-> System.out.print("Zwierzak idzie do przodu");
//            case b-> System.out.print("Zwierzak idzie do tyłu");
//            case r-> System.out.print("Zwierzak skręca w prawo");
//            case l-> System.out.print("Zwierzak skręca w lewo");
//        }
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
        System.out.println("System wystartował");

        Direction direction;

        List<String> directions=new ArrayList<>();

        Scanner scanner=new Scanner(System.in);

        System.out.println("\n\nSystem zakończył działanie");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(position1.opossite().toString());

    }
}
