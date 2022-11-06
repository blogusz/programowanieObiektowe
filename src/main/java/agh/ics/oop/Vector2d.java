package agh.ics.oop;

public class Vector2d {
    final int x;
    final int y;
    public Vector2d(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public String toString()
    {
        return ("("+x+","+y+")");
    }
    public boolean precedes(Vector2d other)
    {
        if(this.x<=other.x && this.y<=other.y)
        {
            return true;
        }
        else return false;
    }
    public boolean follows(Vector2d other)
    {
        if(this.x>=other.x && this.y>=other.y)
        {
            return true;
        }
        else return false;
    }
    public Vector2d add(Vector2d other)
    {
        //System.out.println("("+(this.x+other.x)+","+(this.y+ other.y)+")");
        return new Vector2d(this.x+ other.x,this.y+ other.y);
    }
    public Vector2d subtract(Vector2d other)
    {
        return new Vector2d(this.x- other.x,this.y- other.y);
    }
    public Vector2d upperRight(Vector2d other)
    {
        if(this.x>= other.x)
        {
            if(this.y>= other.y)
            {
                return new Vector2d(this.x,this.y);
            }
            else
            {
                return new Vector2d(this.x,other.y);
            }
        }
        else
        {
            if(this.y>= other.y)
            {
                return new Vector2d(other.x,this.y);
            }
            else
            {
                return new Vector2d(other.x,other.y);
            }
        }
    }

    public Vector2d lowerLeft(Vector2d other)
    {
        if(this.x<= other.x)
        {
            if(this.y<= other.y)
            {
                return new Vector2d(this.x,this.y);
            }
            else
            {
                return new Vector2d(this.x,other.y);
            }
        }
        else
        {
            if(this.y<= other.y)
            {
                return new Vector2d(other.x,this.y);
            }
            else
            {
                return new Vector2d(other.x,other.y);
            }
        }
    }

    public Vector2d opossite()
    {
        return new Vector2d((-1)*this.x,(-1)*this.y);
    }

    public boolean equals(Object other)
    {
        if (this.x == ((Vector2d) other).x && this.y==((Vector2d) other).y)
        {
            return true;
        }
        return false;
    }
}
