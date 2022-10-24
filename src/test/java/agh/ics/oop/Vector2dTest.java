package agh.ics.oop;

import org.junit.jupiter.api.Test;
//import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest
{
    @Test
    public void TesttoString()
    {
        assertEquals("(2,5)", new Vector2d(2,5).toString());

    }

    @Test
    public void Testprecedes()
    {
        assertTrue(new Vector2d(0,1).precedes(new Vector2d(5,2)));
        assertFalse(new Vector2d(5,2).precedes(new Vector2d(0,1)));
    }

    @Test
    public void Testfollows()
    {
        assertFalse(new Vector2d(0,1).follows(new Vector2d(5,2)));
        assertTrue(new Vector2d(5,2).follows(new Vector2d(0,1)));
    }

    @Test
    public void Testadd()
    {
        assertEquals(new Vector2d(1,1),new Vector2d(-1,-2).add(new Vector2d(2,3)));
    }

    @Test
    public void Testsubtract()
    {
        assertEquals(new Vector2d(1,1),new Vector2d(-1,-2).subtract(new Vector2d(-2,-3)));
    }

    @Test
    public void TestupperRight()
    {
        assertEquals(new Vector2d(1,1),new Vector2d(-1,1).upperRight(new Vector2d(1,0)));
    }

    @Test
    public void TestlowerLeft()
    {
        assertEquals(new Vector2d(1,1),new Vector2d(5,1).lowerLeft(new Vector2d(1,4)));
    }

    @Test
    public void Testopossite()
    {
        assertEquals(new Vector2d(-5,-2),new Vector2d(5,2).opossite());
    }

    @Test
    public void Testequals() //Nie wiem, co by to miało być
    {
        //assertEquals(new Vector2d(1, 2).equals(new Vector2d(1,2)));
    }
}
