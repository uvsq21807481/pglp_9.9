package uvsq21807481.Command;

import uvsq21807481.Shape.Group;
import uvsq21807481.Shape.Shape;

public class CommandLink implements Command {

    private Group group;
    private Shape shape;

    public CommandLink(Group g, Shape s) {
        this.group = g;
        this.shape = s;
    }

    @Override
    public void execute() {
        this.group.addShape(this.shape);
    }
}
