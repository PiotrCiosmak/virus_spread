package com.ciosmak.virus_spread.model;

import javafx.scene.layout.Pane;

public class Position
{
    private double x;
    private double y;

    public Position(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Position(Pane world, int edge)
    {
        if (edge == 1)
        {
            this.x = Person.radius + Math.random() * (world.getWidth() - 2 * Person.radius);
            this.y = Person.radius;
        }
        else if (edge == 2)
        {
            this.x = world.getWidth() - Person.radius;
            this.y = Person.radius + Math.random() * (world.getHeight() - 2 * Person.radius);
        }
        else if (edge == 3)
        {
            this.x = Person.radius + Math.random() * (world.getWidth() - 2 * Person.radius);
            this.y = world.getHeight() - Person.radius;
        }
        else
        {
            x = Person.radius;
            this.y = Person.radius + Math.random() * (world.getHeight() - 2 * Person.radius);
        }
    }

    public Position(Pane world)
    {
        this(Person.radius + Math.random() * (world.getWidth() - 2 * Person.radius), Person.radius + Math.random() * (world.getHeight() - 2 * Person.radius));
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double distance(Position other)
    {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + (Math.pow(this.y - other.y, 2)));
    }

    public boolean move(Heading heading, Pane world)
    {
        if (Math.random() < 0.1)
        {
            heading.randomizeDir();
        }
        x += heading.getDx();
        y += heading.getDy();
        return leftOrTurnBack(heading, world);

    }

    private boolean leftOrTurnBack(Heading heading, Pane world)
    {
        if (x < Person.radius || x > world.getWidth() - Person.radius)
        {
            if (Math.random() < 0.5)
            {
                heading.bounceX();
                x += heading.getDx();
            }
            else
            {
                return true;
            }
        }
        else if (y < Person.radius || y > world.getHeight() - Person.radius)
        {
            if (Math.random() < 0.5)
            {
                heading.bounceY();
                y += heading.getDy();
            }
            else
            {
                return true;
            }
        }
        return false;
    }

    //NOWE NIŻEJ
    public boolean near(Position other)
    {
        return distance(other) < 15;
    }
}
