package uvsq21807481.Command;

import uvsq21807481.Shape.Group;
import uvsq21807481.Shape.Shape;

import java.util.ArrayList;

public class CommandDelete implements Command {

    private Group g;
    private String name;

    public CommandDelete(Group g, String name) {
        this.g = g;
        this.name = name;
    }

    @Override
    public void execute() {
        ArrayList<Shape> shapes = this.g.getShapes();
        for(Shape s : shapes) {
            if(s.getName().matches(name)) {
                shapes.remove(s);
            }
            else {
                System.out.println("No such shape in this group");
            }
        }
    }
}
