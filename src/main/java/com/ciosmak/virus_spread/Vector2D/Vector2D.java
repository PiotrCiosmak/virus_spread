package com.ciosmak.virus_spread.Vector2D;

import java.util.ArrayList;

public class Vector2D implements IVector
{
    public Vector2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public ArrayList<Double> getComponents()
    {
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(x);
        arrayList.add(y);
        return arrayList;
    }

    public double abs()
    {
        return Math.sqrt(x * x + y * y);
    }

    public double cdot(IVector param)
    {
        return x * param.getComponents().get(0) + y * param.getComponents().get(1);
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    private double x;
    private double y;
}