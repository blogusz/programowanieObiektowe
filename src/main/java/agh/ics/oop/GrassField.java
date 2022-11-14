package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

public class GrassField extends AbstractWorldMap
{
        int grassAmount;
        ArrayList<Grass> grassAll = new ArrayList<>();
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
                this.grassAll.add(grass);
            }
        }

        @Override
        public boolean isOccupied(Vector2d position)
        {
            if (super.isOccupied(position))
                return true;

            for (Grass grass: this.grassAll)
            {
                if (position.equals(grass.position))
                    return true;
            }
            return false;
        }

        @Override
        public Object objectAt(Vector2d position)
        {
            if(super.objectAt(position) != null)
                return super.objectAt(position);

            for (Grass grass: this.grassAll)
            {
                if (position.equals(grass.position)) // nie było zwierzaka, więc szukamy kępki trawy
                {
                    return grass;
                }
            }
            return null; // nie ma ani zwierzaka ani trawy
        }
        @Override
        public void drawBounds() // kod modyfikujący wartosci lewego dolnego i prawego gornego rogu rysowanego obszaru mapy
        {
            if (!animals.isEmpty())
                drawLowerLeft = drawUpperRight = animals.get(0).getPosition(); // granice jako pozycja 1. zwierzaka (nasz punkt zaczepienia)
            else if (!this.grassAll.isEmpty())
                drawLowerLeft = drawUpperRight = this.grassAll.get(0).getPosition(); // granice jako pozycja 1. kępki (nasz punkt zaczepienia)
            else
            {
                drawLowerLeft = new Vector2d(0,0); // granice jako (0,0) bo nie ma nic na mapie
                drawUpperRight = new Vector2d(0,0);
                return;
            }
            for (Animal animal: animals) // teraz po kolei przyrownujemy lower i upper z pozycjami zwierzakow i ewentualnie je modyfikujemy (rozszerzamy mape)
            {
                drawLowerLeft = drawLowerLeft.lowerLeft(animal.getPosition());
                drawUpperRight = drawUpperRight.upperRight(animal.getPosition());
            }
            for (Grass grass: this.grassAll) // teraz po kolei przyrownujemy lower i upper z pozycjami kępek trawy i ewentualnie je modyfikujemy (rozszerzamy mape)
            {
                drawLowerLeft = drawLowerLeft.lowerLeft(grass.getPosition());
                drawUpperRight = drawUpperRight.upperRight(grass.getPosition());
            }
        }
}
