package com.ciosmak.virus_spread.model;


import com.ciosmak.virus_spread.model.Memento.Snapshot;
import com.ciosmak.virus_spread.model.State.ResistantState;
import com.ciosmak.virus_spread.model.State.State;
import com.ciosmak.virus_spread.model.State.HasSymptomsState;
import com.ciosmak.virus_spread.model.State.NoSymptomsState;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.HashMap;
import java.util.Objects;
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

    void changeState(State state)
    {
        this.state = state;
    }

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
                if ((other.getState() == state || other.getState() == state) && state == state)
                {

                    if (position.near(other.position))
                    {
                        timeNearOthers.put(java.lang.System.identityHashCode(other), timeNearOthers.get(java.lang.System.identityHashCode(other)) + 1);
                        if (timeNearOthers.get(java.lang.System.identityHashCode(other)) >= 5)
                        {
                            if (Objects.equals(other.getState(), new HasSymptomsState(this)))
                            {
                                if (Math.random() < 0.5)
                                {
                                    changeState(new HasSymptomsState(this));
                                }
                                else
                                {
                                    changeState(new NoSymptomsState(this));
                                }
                            }
                            else
                            {
                                if (Math.random() < 0.5)
                                {
                                    if (Math.random() < 0.5)
                                    {
                                        changeState(new HasSymptomsState(this));
                                    }
                                    else
                                    {
                                        changeState(new NoSymptomsState(this));
                                    }
                                }
                                else
                                {
                                    timeNearOthers.put(java.lang.System.identityHashCode(other), 0.0);
                                }
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
        if (Objects.equals(state, new HasSymptomsState(this)) || Objects.equals(state, new NoSymptomsState(this)))
        {
            sickTime++;
            if (sickTime > healtime)
            {
                changeState(new ResistantState(this));
            }
        }
    }

    public void randomizeSpeed()
    {
        speed = ThreadLocalRandom.current().nextDouble(0.0, 2.5);
    }

    public void setHealtime(int healtime)
    {
        this.healtime = healtime;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public void setLeft(boolean left)
    {
        this.left = left;
    }

    public void setTimeNearOthers(HashMap<Integer, Double> timeNearOthers)
    {
        this.timeNearOthers = timeNearOthers;
    }

    public void setWorld(Pane world)
    {
        this.world = world;
    }

    public void setSickTime(int sickTime)
    {
        this.sickTime = sickTime;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public Snapshot createSnapshot()
    {
        return new Snapshot(state, healtime, position, isLeft(), world, sickTime, speed, timeNearOthers);
    }

    public class Command
    {
        private Snapshot backup;

        public void makeBackup()
        {
            backup= createSnapshot();
        }

        public void undo()
        {
            if(backup!=null)
                backup.restore();
        }
    }
}