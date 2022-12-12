package agh.ics.oop;

public class OptionsParser
{
    public static MoveDirection[] parse(String[] array)
    {
        MoveDirection[] directions=new MoveDirection[array.length];
        int counter=0;

        for (String s : array) {
            switch (s) {
                case "f", "forward" -> directions[counter] = MoveDirection.FORWARD;
                case "b", "backward" -> directions[counter] = MoveDirection.BACKWARD;
                case "r", "right" -> directions[counter] = MoveDirection.RIGHT;
                case "l", "left" -> directions[counter] = MoveDirection.LEFT;
                default -> throw new IllegalArgumentException(s + " is not legal move specification");
            }
            counter++;
        }
        return directions;
    }
}