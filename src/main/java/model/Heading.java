package model;

public class Heading
{
    public static final double SPEED = 2.5;
    private double dx;
    private double dy;

    public Heading(double dx, double dy)
    {
        this.dx=dx;
        this.dy=dy;
    }

    public Heading()
    {
        double dir = Math.random()*2*Math.PI;
        dx=Math.sin(dir);
        dy=Math.cos(dir);
    }

    public double getDx()
    {
        return dx;
    }

    public double getDy()
    {
        return dy;
    }

/*    public void bounceX()
    {

    }*/
}
