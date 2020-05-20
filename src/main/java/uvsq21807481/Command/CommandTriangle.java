package uvsq21807481.Command;

import uvsq21807481.Shape.Point;
import uvsq21807481.Shape.Triangle;
import uvsq21807481.Shape.Group;

public class CommandTriangle extends Screen{

    private String name;
    private Point p1;
    private Point p2;
    private Point p3;

    public CommandTriangle(Group g, String name, double x1, double y1, double x2, double y2, double x3, double y3) {
        super(g);
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Point p3 = new Point(x3, y3);
        this.name = name;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public void execute() {
        super.screen.addShape(new Triangle(name, p1, p2, p3));
    }

}
