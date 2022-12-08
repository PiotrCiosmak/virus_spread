package com.ciosmak.virus_spread.model.State;

import com.ciosmak.virus_spread.model.Person;
import com.ciosmak.virus_spread.model.Simulation;
import javafx.scene.paint.Color;

public class NoSymptomsState extends State
{
    public NoSymptomsState(Person person)
    {
        super(person);
    }

    public NoSymptomsState(Simulation simulation)
    {
        super(simulation);
    }
    @Override
    public Color getColor()
    {
        return Color.ORANGE;
    }
}
