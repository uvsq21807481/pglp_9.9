package uvsq21807481.Command;

import uvsq21807481.Shape.Point;
import uvsq21807481.Shape.Rectangle;
import uvsq21807481.Shape.Group;

public class CommandRectangle extends Screen{

    private String name;
    private Point center;
    private double length;
    private double width;

    public CommandRectangle(Group g, String name, double x, double y, double length, double width) {
        super(g);
        Point p = new Point(x, y);
        this.name = name;
        this.center = p;
        this.length = length;
        this.width = width;
    }

    @Override
    public void execute() {
        super.screen.addShape(new Rectangle(name, center, length, width));
    }

}
