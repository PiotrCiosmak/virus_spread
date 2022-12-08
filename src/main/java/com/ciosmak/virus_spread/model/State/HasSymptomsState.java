package com.ciosmak.virus_spread.model.State;

import com.ciosmak.virus_spread.model.Person;
import com.ciosmak.virus_spread.model.Simulation;
import javafx.scene.paint.Color;

public class HasSymptomsState extends State
{
    public HasSymptomsState(Person person)
    {
        super(person);
    }

    public HasSymptomsState(Simulation simulation)
    {
        super(simulation);
    }
    @Override
    public Color getColor()
    {
        return Color.RED;
    }
}
