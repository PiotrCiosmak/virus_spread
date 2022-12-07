package model;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

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
    }

    public ArrayList<Person> getPeople()
    {
        return people;
    }

    public void move()
    {
        for (Person p : people)
        {
            p.move();
        }
    }

    public void draw()
    {
        for (Person p : people)
        {
            p.draw();
        }
    }
}