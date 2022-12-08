package com.ciosmak.virus_spread.model.State;

import com.ciosmak.virus_spread.model.Person;
import com.ciosmak.virus_spread.model.Simulation;
import javafx.scene.paint.Color;

public class HealthyState extends State
{
    public HealthyState(Person person)
    {
        super(person);
    }

    public HealthyState(Simulation simulation)
    {
        super(simulation);
    }

    @Override
    public Color getColor()
    {
        return Color.GREEN;
    }
}
