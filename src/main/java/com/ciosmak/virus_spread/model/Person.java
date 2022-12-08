package com.ciosmak.virus_spread.model;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Person
{
    public static int radius = 5;
    public int healtime;

    public int generateHealtime()
    {
        return (ThreadLocalRandom.current().nextInt(20, 31)) * 25;
    }

    private State state;
    private Position position;
    private Heading heading;
    private Circle circle;
    private Pane world;
    private boolean left;
    private int sickTime = 0;
    private double speed = 0.0;
    private HashMap<Integer, Double> timeNearOthers = new HashMap<>();

    public Person(State state, Pane world)
    {
        this.state = state;
        this.heading = new Heading();
        this.position = new Position(world);
        this.circle = new Circle(radius, state.getColor());
        this.world = world;
        this.left = false;
        healtime = generateHealtime();
        circle.setStroke(Color.BLACK);
        world.getChildren().add(circle);
    }

    public Person(State state, Pane world, int edge)
    {
        this.state = state;
        this.heading = new Heading();
        this.position = new Position(world, edge);
        this.circle = new Circle(radius, state.getColor());
        this.world = world;
        this.left = false;
        healtime = generateHealtime();
        circle.setStroke(Color.BLACK);
        world.getChildren().add(circle);
    }

    public boolean isLeft()
    {
        return left;
    }

    public State getState()
    {
        return state;
    }

    public void setCircleRadius(double radius)
    {
        this.circle.setRadius(radius);
    }

    public void setState(State state)
    {
        this.state = state;
        circle.setFill(state.getColor());
    }

    public void move()
    {
        left = position.move(heading, world);
    }

    public void draw()
    {
        circle.setRadius(radius);
        circle.setTranslateX(position.getX());
        circle.setTranslateY(position.getY());
    }

    //nowe niżej
    public void checkAround(Person other)
    {
        if (timeNearOthers.get(java.lang.System.identityHashCode(other)) != null)
        {
            if (!other.isLeft())
            {
                if ((other.getState() == State.NO_SYMPYOMS || other.getState() == State.HAS_SYMPTOMS) && state == State.HEALTHY)
                {

                    if (position.near(other.position))
                    {
                        timeNearOthers.put(java.lang.System.identityHashCode(other), timeNearOthers.get(java.lang.System.identityHashCode(other)) + 1);
                        if (timeNearOthers.get(java.lang.System.identityHashCode(other)) >= 75)
                        {
                            if (Math.random() < 0.5)
                            {
                                setState(State.HAS_SYMPTOMS);
                            }
                            else
                            {
                                setState(State.NO_SYMPYOMS);
                            }
                        }
                    }
                    else
                    {
                        timeNearOthers.put(java.lang.System.identityHashCode(other), 0.0);
                    }
                }
            }
            else
            {
                timeNearOthers.put(java.lang.System.identityHashCode(other), -1.0);
            }
        }
        else
        {
            timeNearOthers.put(java.lang.System.identityHashCode(other), 0.0);
        }
    }

    public void feelBetter()
    {
        if (state == State.HAS_SYMPTOMS || state == State.NO_SYMPYOMS)
        {
            sickTime++;
            if (sickTime > healtime)
            {
                setState(State.RESISTANT);
            }
        }
    }

    public void randomizeSpeed()
    {
        speed = ThreadLocalRandom.current().nextDouble(0.0, 2.5);
    }
}
