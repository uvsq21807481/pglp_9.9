package uvsq21807481.Command;

import uvsq21807481.Shape.Group;

public class CommandGroup extends Screen{

    private String name;

    public CommandGroup(Group g, String name) {
        super(g);
        this.name = name;
    }

    @Override
    public void execute() {
        super.screen.addShape(new Group(name));
    }

}
