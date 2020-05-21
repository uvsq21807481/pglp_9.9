package uvsq21807481.Command;

public class CommandList implements Command{

    private String list;

    public CommandList() {
        this.list = "";
    }

    @Override
    public void execute() {
        System.out.println("List of available commands :");
        System.out.println("The general group's name is 'all'");
        System.out.println("Create a circle : circle(name, CoorX, CoorY, radius)");
        System.out.println("Create a rectangle : rectangle(name, CenterX, CenterY, length, width)");
        System.out.println("Create a square : square(name, CenterX, CenterY, side)");
        System.out.println("Create a triangle : circle(name, CoorX1, CoorY1, CoorX2, CoorY2, CoorX3, CoorY3)");
        System.out.println("Create a group : group(nameNewGroup)");
        System.out.println("Add a shape to a Group : link(groupName, shapeName");
        System.out.println("Show a shape / a group of shapes: show(name)");
        System.out.println("Delete a shape : delete(group name");
    }
}
