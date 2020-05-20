package uvsq21807481.Command;

import uvsq21807481.Shape.Shape;

public class CommandMove implements Command {

    private double moveX;
    private double moveY;
    private Shape shape;

    public CommandMove(Shape s, double x, double y) {
        this.shape = s;
        this.moveX = x;
        this.moveY = y;
    }

    @Override
    public void execute() {
        this.shape.move(moveX, moveY);
    }
}
