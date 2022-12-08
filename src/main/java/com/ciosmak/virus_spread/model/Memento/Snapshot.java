package com.ciosmak.virus_spread.model.Memento;

import com.ciosmak.virus_spread.model.Person;
import com.ciosmak.virus_spread.model.Position;
import com.ciosmak.virus_spread.model.State.State;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class Snapshot
{
    private Person person;
    private State state;
    private int healtime;
    private Position position;
    private boolean isLeft;
    private Pane world;
    private int sickTime;
    private double speed;
    private HashMap<Integer, Double> timeNearOthers;

    public Snapshot(State state, int healtime, Position position, boolean isLeft, Pane world, int sickTime, double speed, HashMap<Integer, Double> timeNearOthers)
    {
        this.state = state;
        this.healtime = healtime;
        this.position = position;
        this.isLeft = isLeft;
        this.world = world;
        this.sickTime = sickTime;
        this.speed = speed;
        this.timeNearOthers = timeNearOthers;
    }

    public void restore()
    {
        person.setState(state);
        person.setHealtime(healtime);
        person.setPosition(position);
        person.setLeft(isLeft);
        person.setWorld(world);
        person.setSickTime(sickTime);
        person.setSpeed(speed);
        person.setTimeNearOthers(timeNearOthers);
    }
}
