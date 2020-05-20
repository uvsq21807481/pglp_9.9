package uvsq21807481.Command;

import uvsq21807481.Shape.Point;
import uvsq21807481.Shape.Circle;
import uvsq21807481.Shape.Group;

public class CommandCircle extends Screen{

    private String name;
    private Point center;
    private double radius;

    public CommandCircle(Group g, String name, double x, double y, double radius) {
        super(g);
        Point p = new Point(x, y);
        this.name = name;
        this.center = p;
        this.radius = radius;
    }

    @Override
    public void execute() {
        super.screen.addShape(new Circle(name, center, radius));
    }
}
