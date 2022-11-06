package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser
{
    List<MoveDirection> parse(String[] tablica)
    {
        List<MoveDirection> moveDirections=new ArrayList<>();

        for(int i=0; i< tablica.length; i++)
        {
            switch (tablica[i])
            {
                case "f"-> moveDirections.add(MoveDirection.FORWARD);
                case "forward"-> moveDirections.add(MoveDirection.FORWARD);
                case "b"-> moveDirections.add(MoveDirection.BACKWARD);
                case "backward"-> moveDirections.add(MoveDirection.BACKWARD);
                case "r"-> moveDirections.add(MoveDirection.RIGHT);
                case "right"-> moveDirections.add(MoveDirection.RIGHT);
                case "l"-> moveDirections.add(MoveDirection.LEFT);
                case "left"-> moveDirections.add(MoveDirection.LEFT);
            }
        }
        return moveDirections;
    }
}
