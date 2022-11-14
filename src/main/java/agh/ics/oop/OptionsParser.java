package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser
{
    List<MoveDirection> parse(String[] array)
    {
        List<MoveDirection> moveDirections=new ArrayList<>();

        for(int i=0; i< array.length; i++)
        {
            switch (array[i])
            {
                case "f", "forward" -> moveDirections.add(MoveDirection.FORWARD);
                case "b", "backward" -> moveDirections.add(MoveDirection.BACKWARD);
                case "r", "right" -> moveDirections.add(MoveDirection.RIGHT);
                case "l", "left" -> moveDirections.add(MoveDirection.LEFT);
            }
        }
        return moveDirections;
    }
}
