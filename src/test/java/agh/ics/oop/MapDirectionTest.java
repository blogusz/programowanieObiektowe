package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest
{
    @Test
    public void Testnext()
    {
        MapDirection north = MapDirection.NORTH;
        assertEquals(north.next(),MapDirection.EAST);

        MapDirection south = MapDirection.SOUTH;
        assertEquals(south.next(),MapDirection.WEST);

        MapDirection west = MapDirection.WEST;
        assertEquals(west.next(),MapDirection.NORTH);

        MapDirection east = MapDirection.EAST;
        assertEquals(east.next(),MapDirection.SOUTH);
    }

    @Test
    public void Testprevious()
    {
        MapDirection north = MapDirection.NORTH;
        assertEquals(north.previous(),MapDirection.WEST);

        MapDirection south = MapDirection.SOUTH;
        assertEquals(south.previous(),MapDirection.EAST);

        MapDirection west = MapDirection.WEST;
        assertEquals(west.previous(),MapDirection.SOUTH);

        MapDirection east = MapDirection.EAST;
        assertEquals(east.previous(),MapDirection.NORTH);
    }
}
