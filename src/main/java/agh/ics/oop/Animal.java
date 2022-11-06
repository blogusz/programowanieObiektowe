package agh.ics.oop;

public class Animal
{
    private MapDirection direction;
    private Vector2d position;
    public Animal()
    {
        this.direction=MapDirection.NORTH;
        this.position=new Vector2d(2,2);
    }


    @Override
    public String toString()
    {
        return "("+position.x+", "+position.y+")"+", "+direction;
    }

    public boolean isAt(Vector2d position)
    {
        if(position.x == this.position.x && position.y == this.position.y)
        {
            return true;
        }
        else return false;
    }

    public void move(MoveDirection direction)
    {
        while (true)
        {
            if(direction==MoveDirection.RIGHT)
            {
                if(this.direction==MapDirection.NORTH)
                {
                    this.direction=MapDirection.EAST;
                    break;
                }
                if(this.direction==MapDirection.SOUTH)
                {
                    this.direction=MapDirection.WEST;
                    break;
                }
                if(this.direction==MapDirection.WEST)
                {
                    this.direction=MapDirection.NORTH;
                    break;
                }
                if(this.direction==MapDirection.EAST)
                {
                    this.direction=MapDirection.SOUTH;
                    break;
                }
            }
            if(direction==MoveDirection.LEFT)
            {
                if(this.direction==MapDirection.NORTH)
                {
                    this.direction=MapDirection.WEST;
                    break;
                }
                if(this.direction==MapDirection.SOUTH)
                {
                    this.direction=MapDirection.EAST;
                    break;
                }
                if(this.direction==MapDirection.WEST)
                {
                    this.direction=MapDirection.SOUTH;
                    break;
                }
                if(this.direction==MapDirection.EAST)
                {
                    this.direction=MapDirection.NORTH;
                    break;
                }
            }
            if(direction==MoveDirection.FORWARD)
            {
                if(this.position.y<4 && this.direction==MapDirection.NORTH)
                {
                    this.position=this.position.add(new Vector2d(0,1));
                    break;
                }
                if(this.position.y>0 && this.direction==MapDirection.SOUTH)
                {
                    this.position=this.position.add(new Vector2d(0,-1));
                    break;
                }
                if(this.position.x>0 && this.direction==MapDirection.WEST)
                {
                    this.position=this.position.add(new Vector2d(-1,0));
                    break;
                }
                if(this.position.x<4 && this.direction==MapDirection.EAST)
                {
                    this.position=this.position.add(new Vector2d(1,0));
                    break;
                }
                break;
            }
            if(direction==MoveDirection.BACKWARD)
            {
                if(this.position.y>0 && this.direction==MapDirection.NORTH)
                {
                    this.position=this.position.add(new Vector2d(0,-1));
                    break;
                }
                if(this.position.y<4 && this.direction==MapDirection.SOUTH)
                {
                    this.position=this.position.add(new Vector2d(0,1));
                    break;
                }
                if(this.position.x<4 && this.direction==MapDirection.WEST)
                {
                    this.position=this.position.add(new Vector2d(1,0));
                    break;
                }
                if(this.position.x>0 && this.direction==MapDirection.EAST)
                {
                    this.position=this.position.add(new Vector2d(-1,0));
                    break;
                }
                break;
            }

        }
    }
}
