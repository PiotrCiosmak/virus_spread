package com.ciosmak.virus_spread.model;

import com.ciosmak.virus_spread.Vector2D.Vector2D;
import javafx.scene.layout.Pane;

public class Position
{
    private Vector2D vector2D;

    public Position(double x, double y)
    {
        vector2D = new Vector2D(x,y);
    }

    double getX()
    {
        return this.vector2D.getX();
    }

    double getY()
    {
        return this.vector2D.getY();
    }

    public Position(Pane world, int edge)
    {
        if (edge == 1)
        {
            vector2D = new Vector2D(Person.radius + Math.random() * (world.getWidth() - 2 * Person.radius),Person.radius);
        }
        else if (edge == 2)
        {
            vector2D = new Vector2D(world.getWidth() - Person.radius,Person.radius + Math.random() * (world.getHeight() - 2 * Person.radius));
        }
        else if (edge == 3)
        {
            vector2D = new Vector2D(Person.radius + Math.random() * (world.getWidth() - 2 * Person.radius),world.getHeight() - Person.radius);
        }
        else
        {
            vector2D = new Vector2D(Person.radius,Person.radius + Math.random() * (world.getHeight() - 2 * Person.radius));
        }
    }

    public Position(Pane world)
    {
        this(Person.radius + Math.random() * (world.getWidth() - 2 * Person.radius), Person.radius + Math.random() * (world.getHeight() - 2 * Person.radius));
    }

    public double distance(Position other)
    {
        return Math.sqrt(Math.pow(this.vector2D.getX() - other.vector2D.getX(), 2) + (Math.pow(this.vector2D.getY() - other.vector2D.getY(), 2)));
    }

    public boolean move(Heading heading, Pane world)
    {
        if (Math.random() < 0.1)
        {
            heading.randomizeDir();
        }
        this.vector2D.setX(this.vector2D.getX() + heading.getDx());
        this.vector2D.setY(this.vector2D.getY() + heading.getDy());
        return leftOrTurnBack(heading, world);

    }

    private boolean leftOrTurnBack(Heading heading, Pane world)
    {
        if (this.vector2D.getX() < Person.radius || this.vector2D.getX() > world.getWidth() - Person.radius)
        {
            if (Math.random() < 0.5)
            {
                heading.bounceX();
                this.vector2D.setX(this.vector2D.getX() + heading.getDx());
            }
            else
            {
                return true;
            }
        }
        else if (this.vector2D.getY() < Person.radius || this.vector2D.getY() > world.getHeight() - Person.radius)
        {
            if (Math.random() < 0.5)
            {
                heading.bounceY();
                this.vector2D.setY(this.vector2D.getY() + heading.getDy());
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
