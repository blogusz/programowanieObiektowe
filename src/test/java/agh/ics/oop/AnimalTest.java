package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {

    Animal animaltest=new Animal(); //zwierze o domyślnych wartoścaich tj. (2,2), NORTH
    OptionsParser optionsParser=new OptionsParser();

    @Test
    void inputTest() //testujemy, czy dane wejściowe podane jako tablica łańcuchów znaków są poprawnie interpretowane.
    {
        String[] directions=new String[]{"x","y","z", "ala ma kota","0"};

        for(MoveDirection dir : optionsParser.parse(directions))
        {
            animaltest.move(dir); //wykonujemy ruchy pobrane z tablict kierunków
        }
        assertEquals("(2, 2), Północ",animaltest.toString());
    }

    @Test
    void orientationTest() //testujemy prawidłowość orientacji
    {
        String[] directions=new  String[]{"right","right","r","r","left","l"};

        for(MoveDirection dir : optionsParser.parse(directions))
        {
            animaltest.move(dir);
        }
        assertEquals("(2, 2), Południe",animaltest.toString());
    }

    @Test
    void positionTest() //testujemy prawidłowe pozycjonowanie
    {
        String[] directions=new  String[]{"l","forward","f", "backward","left","left","f","f"};

        for(MoveDirection dir : optionsParser.parse(directions))
        {
            animaltest.move(dir);
        }
        assertEquals("(3, 2), Wschód",animaltest.toString());
    }

    @Test
    void boundariesTest() //testujemy wyjście poza granice
    {
        Animal animaltest1=new Animal(); //cztery zwierzaki na polu (2,2) NORTH, każdy pójdzie w innym kierunku
        Animal animaltest2=new Animal();
        Animal animaltest3=new Animal();
        Animal animaltest4=new Animal();

        String[] directions1=new String[]{"forward","forward","forward","forward"}; //badamy wszystkie cztery granice, tzn obie boczne i obie górne
        String[] directions2=new String[]{"backward","backward","backward","backward"};
        String[] directions3=new String[]{"right","forward","forward","forward"};
        String[] directions4=new String[]{"left","forward","forward","forward"};

        for(MoveDirection dir : optionsParser.parse(directions1))
        {
            animaltest1.move(dir);
        }
        for(MoveDirection dir : optionsParser.parse(directions2))
        {
            animaltest2.move(dir);
        }
        for(MoveDirection dir : optionsParser.parse(directions3))
        {
            animaltest3.move(dir);
        }
        for(MoveDirection dir : optionsParser.parse(directions4))
        {
            animaltest4.move(dir);
        }
        assertEquals("(2, 4), Północ", animaltest1.toString());
        assertEquals("(2, 0), Północ", animaltest2.toString());
        assertEquals("(4, 2), Wschód", animaltest3.toString());
        assertEquals("(0, 2), Zachód", animaltest4.toString());
    }
}