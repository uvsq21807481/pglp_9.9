package uvsq21807481.Shape;

public abstract class Shape {

    private String name;
    private Point mainPoint;

    public Shape(String name) {
        this.name = name;
    }

    public Shape(String name, Point p) {
        this.name = name;
        this.mainPoint = p;
    }

    public String getName() {
        return name;
    }

    public Point getMainPoint() {
        return mainPoint;
    }

    public abstract void move(double x, double y);

    public abstract void show();
}
