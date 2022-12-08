package com.ciosmak.virus_spread.model;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Simulation
{
    private ArrayList<Person> people;

    public Simulation(Pane world, int popSize)
    {
        people = new ArrayList<Person>();
        for (int i = 0; i < popSize; ++i)
        {
            if (Math.random() < 0.1)
            {
                if (Math.random() < 0.5)
                {
                    people.add(new Person(State.HAS_SYMPTOMS, world));
                }
                else
                {
                    people.add(new Person(State.NO_SYMPYOMS, world));
                }
            }
            else
            {
                people.add(new Person(State.HEALTHY, world));
            }

        }
        draw();
    }

    public ArrayList<Person> getPeople()
    {
        return people;
    }

    public void move()
    {

        for (int i = 0; i < people.size(); ++i)
        {
            people.get(i).move();
            if (people.get(i).isLeft())
            {
                people.get(i).setCircleRadius(-1);
                people.remove(i);
            }
        }

    }

    public void draw()
    {
        for (Person p : people)
        {
            p.draw();
        }
    }

    public void addNewPersonAtBoard(Pane world)
    {
        int randomEdge = ThreadLocalRandom.current().nextInt(1, 5);

        if (Math.random() < 0.1)
        {
            if (Math.random() < 0.5)
            {
                people.add(new Person(State.HAS_SYMPTOMS, world, randomEdge));
            }
            else
            {
                people.add(new Person(State.NO_SYMPYOMS, world, randomEdge));
            }
        }
        else
        {
            people.add(new Person(State.HEALTHY, world, randomEdge));
        }
    }


    //nowe nizej
    public void checkAround()
    {
        for (Person p : people)
        {
            for (Person q : people)
            {
                if (p != q)
                {
                    p.checkAround(q);
                }
            }

        }
    }

    public void feelBetter()
    {
        for (Person p : people)
        {
            p.feelBetter();
        }
    }

    public void randomizeSpeed()
    {
        for (Person p : people)
        {
            p.randomizeSpeed();
        }
    }
}
