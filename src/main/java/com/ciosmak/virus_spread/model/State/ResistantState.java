package com.ciosmak.virus_spread.model.State;

import com.ciosmak.virus_spread.model.Person;
import com.ciosmak.virus_spread.model.Simulation;
import javafx.scene.paint.Color;

public class ResistantState extends State
{
    public ResistantState(Person person)
    {
        super(person);
    }

    public ResistantState(Simulation simulation)
    {
        super(simulation);
    }

    @Override
    public Color getColor()
    {
        return Color.BLUE;
    }
}
