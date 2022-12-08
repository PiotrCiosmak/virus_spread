package com.ciosmak.virus_spread.model;

public class Heading
{
    private double dx;
    private double dy;
    private double dir;

    public Heading(double dx, double dy)
    {
        this.dx = dx;
        this.dy = dy;
    }

    public Heading()
    {
        dir = Math.random() * 2 * Math.PI;
        dx = Math.sin(dir);
        dy = Math.cos(dir);
    }

    public double getDx()
    {
        return dx;
    }

    public double getDy()
    {
        return dy;
    }

    public void randomizeDir()
    {
        dir = Math.random() * 2 * Math.PI;
        dx = Math.sin(dir);
        dy = Math.cos(dir);
    }

    public void bounceX()
    {
        dx *= -1;
    }

    public void bounceY()
    {
        dy *= -1;
    }
}
