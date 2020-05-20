package uvsq21807481.Command;

import uvsq21807481.Shape.Group;

public abstract class Screen implements Command {

    protected Group screen;

    public Screen(Group g) {
        this.screen = g;
    }
}
