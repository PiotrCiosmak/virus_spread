package com.ciosmak.virus_spread.model.State;

import com.ciosmak.virus_spread.model.Person;
import com.ciosmak.virus_spread.model.Simulation;
import javafx.scene.paint.Color;

public abstract class State
{
    protected Person person;
    protected Simulation simulation;

    public State(Person person)
    {
        this.person = person;
    }

    public State(Simulation simulation)
    {
        this.simulation = simulation;
    }

    abstract public Color getColor();
}
