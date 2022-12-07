package model;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Person
{
    public static int radius = 5;

    private State state;
    private Position position;
    private Heading heading;
    private Circle circle;
    private Pane world;

    public Person(State state, Pane world)
    {
        this.state = state;
        this.heading = new Heading();
        this.position = new Position(world, 5);
        this.circle = new Circle(radius,state.getColor());
        circle.setStroke(Color.BLACK);
        world.getChildren().add(circle);
    }

    public State getState()
    {
        return state;
    }

    public void setState(State state)
    {
        this.state=state;
        circle.setFill(state.getColor());
    }

    public void move()
    {
        position.move(heading);
    }

    public void draw()
    {
        circle.setRadius(radius);
        circle.setTranslateX(position.getX());
        circle.setTranslateY(position.getY());
    }
}
