package agh.ics.oop;

import java.util.HashMap;
import java.util.Random;

public class GrassField extends AbstractWorldMap
{
    int grassAmount;
    public HashMap<Vector2d, Grass> grassAll=new HashMap<>();
    Vector2d lowerLeftGrass;
    Vector2d upperRightGrass;

    public GrassField(int grassAmount)
    {
        this.grassAmount = grassAmount;

        this.lowerLeftGrass = new Vector2d(0,0); // lewa dolna i prawa górna granica dla kępek trawy
        this.upperRightGrass = new Vector2d((int)Math.sqrt(grassAmount*10), (int)Math.sqrt(grassAmount*10));

        int intMax = Integer.MAX_VALUE; // maksymalna wartość możliwa do osiągnięcia przez integer
        int intMin = Integer.MIN_VALUE; // minimalna wartość możliwa do osiągnięcia przez integer
        this.upperRight = new Vector2d(intMax, intMax); // prawy górny róg mapy
        this.lowerLeft = new Vector2d(intMin, intMin); // lewy dolny róg mapy

        for (int i = 0; i < grassAmount; i++) // tworzymy podaną ilość kępek trawy
        {
            int minX=0;
            int minY=0;
            int maxX=this.upperRightGrass.x;
            int maxY=this.upperRightGrass.y;
            Vector2d newGrassPosition;
            Random random=new Random();

            do {
                int x=random.nextInt(maxX-minX)+minX;
                int y=random.nextInt(maxY-minY)+minY;
                newGrassPosition= new Vector2d(x,y);

            } while (isOccupied(newGrassPosition)); // tworzymy nowę kępki trawy tak długo, aż którąś będzie się dało umieścić na mapie

            Grass grass=new Grass(newGrassPosition);
            this.grassAll.put(newGrassPosition, grass);
            mapBoundary.add(newGrassPosition);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        if (super.isOccupied(position))
            return true;
        if (grassAll.get(position)!=null)
            return true;
        else
            return false;
    }

    @Override
    public Object objectAt(Vector2d position)
    {
        if(super.objectAt(position) != null)
            return super.objectAt(position);
        if(grassAll.get(position)!=null)
            return grassAll.get(position);
        else
            return null;
    }


    @Override
    public void drawBounds() // kod modyfikujący wartosci lewego dolnego i prawego gornego rogu rysowanego obszaru mapy
    {
        this.drawLowerLeft=this.mapBoundary.getLowerLeft();
        this.drawUpperRight=this.mapBoundary.getUpperRight();
    }

}
