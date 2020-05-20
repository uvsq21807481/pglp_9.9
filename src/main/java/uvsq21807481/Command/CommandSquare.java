package uvsq21807481.Command;

import uvsq21807481.Shape.Point;
import uvsq21807481.Shape.Square;
import uvsq21807481.Shape.Group;

public class CommandSquare extends Screen{

    private String name;
    private Point center;
    private double side;

    public CommandSquare(Group g, String name, double x, double y, double side) {
        super(g);
        Point p = new Point(x, y);
        this.name = name;
        this.center = p;
        this.side = side;
    }

    @Override
    public void execute() {
        super.screen.addShape(new Square(name, center, side);
    }
}
