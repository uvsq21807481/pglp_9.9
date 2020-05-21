package uvsq21807481.Command;

import uvsq21807481.Shape.Shape;

public class CommandShow implements Command {

    private Shape shape;

    public CommandShow(Shape s) {
        this.shape = s;
    }

    @Override
    public void execute() {
        shape.show();
    }
}
