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

        while(true) //tworzymy listę kolejnych kierunków ruchu dla zwierzaka
        {
            System.out.println("Podaj następny kierunek ruchu zwierzaka [f/b/l/r]. 'X' kończy dodawanie kierunków. ");
            String choice=scanner.nextLine();

            if(choice.equals("X")) break;
            if(choice.equals(Direction.valueOf("f").toString()) || choice.equals(Direction.valueOf("b").toString()) || choice.equals(Direction.valueOf("r").toString()) || choice.equals(Direction.valueOf("l").toString()) )
            {
                directions.add(choice);
            }
        }

        for (String dir : directions)   //przypisujemy wartościom String wartości typu wyliczeniowego
        {
            switch (dir)
            {
                case "f" -> direction = Direction.f;
                case "b" -> direction = Direction.b;
                case "l" -> direction = Direction.l;
                case "r" -> direction = Direction.r;
                default -> direction=null;

            }
            if(direction != null) run(direction); //wywołujemy funkcję run()

        }

        System.out.println("\n\nSystem zakończył działanie");

    }
}
