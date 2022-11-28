package agh.ics.oop;

import org.junit.jupiter.api.Test;
//import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest
{
    @Test
    public void toStringTest()
    {
        assertEquals("(2,5)", new Vector2d(2,5).toString());

    }

    @Test
    public void precedesTest()
    {
        assertTrue(new Vector2d(0,1).precedes(new Vector2d(5,2)));
        assertFalse(new Vector2d(5,2).precedes(new Vector2d(0,1)));
    }

    @Test
    public void followsTest()
    {
        assertFalse(new Vector2d(0,1).follows(new Vector2d(5,2)));
        assertTrue(new Vector2d(5,2).follows(new Vector2d(0,1)));
    }

    @Test
    public void addTest()
    {
        assertEquals(new Vector2d(1,1),new Vector2d(-1,-2).add(new Vector2d(2,3)));
    }

    @Test
    public void subtractTest()
    {
        assertEquals(new Vector2d(1,1),new Vector2d(-1,-2).subtract(new Vector2d(-2,-3)));
    }

    @Test
    public void upperRightTest()
    {
        assertEquals(new Vector2d(1,1),new Vector2d(-1,1).upperRight(new Vector2d(1,0)));
    }

    @Test
    public void lowerLeftTest()
    {
        assertEquals(new Vector2d(1,1),new Vector2d(5,1).lowerLeft(new Vector2d(1,4)));
    }

    @Test
    public void oppositeTest()
    {
        assertEquals(new Vector2d(-5,-2),new Vector2d(5,2).opposite());
    }

    @Test
    public void equalsTest() //Nie wiem, co by to miało być
    {
        //assertEquals(new Vector2d(1, 2).equals(new Vector2d(1,2)));
    }
}
