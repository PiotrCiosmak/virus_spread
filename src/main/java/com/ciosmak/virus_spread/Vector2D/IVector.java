package com.ciosmak.virus_spread.Vector2D;

import java.util.ArrayList;

public interface IVector
{
    double abs();

    double cdot(IVector param);

    ArrayList<Double> getComponents();
}