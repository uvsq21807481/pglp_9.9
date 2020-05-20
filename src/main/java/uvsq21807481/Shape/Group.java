package uvsq21807481.Shape;

import java.util.ArrayList;

public class Group extends Shape{

    private ArrayList<Shape> shapes;

    public Group(String name) {
        super(name);
        shapes = new ArrayList<>();
    }

    public void addShape(Shape s) {
        this.shapes.add(s);
    }

    public void move(double x, double y) {
        for(Shape s : this.shapes) {
            s.move(x, y);
        }
    }

    public void show() {
        for(Shape s : this.shapes) {
            s.show();
        }
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}
