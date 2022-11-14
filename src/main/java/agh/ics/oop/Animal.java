package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection direction;
    private Vector2d position;
    private IWorldMap map;

    /**"zastanów się nad dotychczasowym konstruktorem bezparametrowym, czy nadal ma on sens? W jaki sposób uprościć wszystkie konstruktory?"*/
    // Można by po prostu stworzyć jeden główny konstruktor, w którym ustalana będzie mapa, pozycja startowa i orientacja startowa zwierzaka
    public Animal()
    {
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map)
    {
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        this.direction = MapDirection.NORTH;
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
        //return null;
    }

    public boolean isAt(Vector2d position) {
        if (position.x == this.position.x && position.y == this.position.y)
        {
            return true;
        }
        else
            return false;
    }

    public void move(MoveDirection direction, IWorldMap map)
    {
        switch (direction)
        {
            case FORWARD ->
            {
                if (this.map.canMoveTo(this.position.add(Objects.requireNonNull(this.direction.toUnitVector()))))
                {
                    this.position = this.position.add(Objects.requireNonNull(this.direction.toUnitVector()));
                }
            }

            case BACKWARD ->
            {
                if (this.map.canMoveTo(this.position.subtract(Objects.requireNonNull(this.direction.toUnitVector()))))
                {
                    this.position = this.position.subtract(Objects.requireNonNull(this.direction.toUnitVector()));
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
}
