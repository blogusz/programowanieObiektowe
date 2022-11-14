package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position= new Vector2d(2, 2);
    private final IWorldMap map;

    public Animal(IWorldMap map)
    {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        this.position = initialPosition;
        this.map = map;
    }
    @Override
    public String toString()
    {
        switch (this.direction)
        {
            case NORTH ->
            {
                return "N";
            }
            case SOUTH ->
            {
                return "S";
            }
            case EAST ->
            {
                return "E";
            }
            case WEST ->
            {
                return "W";
            }
            default ->
            {
                return null;
            }
        }
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction, IWorldMap map)
    {
        if (direction == null)
            return;

        switch (direction)
        {
            case FORWARD ->
            {
                Vector2d nextPosition = this.position.add(Objects.requireNonNull(this.direction.toUnitVector()));
                if (this.map.canMoveTo(nextPosition))
                {
                    if(!this.map.isOccupied(nextPosition) || !(this.map.objectAt(nextPosition) instanceof Animal))
                        this.position=nextPosition;
                }
            }

            case BACKWARD ->
            {
                Vector2d nextPosition = this.position.subtract(Objects.requireNonNull(this.direction.toUnitVector()));
                if (this.map.canMoveTo(nextPosition))
                {
                    if(!this.map.isOccupied(nextPosition) || !(this.map.objectAt(nextPosition) instanceof Animal))
                        this.position=nextPosition;
                }
            }

            case RIGHT -> this.direction = this.direction.next();

            case LEFT -> this.direction = this.direction.previous();

        }
    }

    public Vector2d getPosition() //funkcja pomocnicza pomagająca odczytywać bierzącą pozycje danego zwierzaka
    {
        return this.position;
    }

    public MapDirection getDirection() {
        return this.direction;
    }
}