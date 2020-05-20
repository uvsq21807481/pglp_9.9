package uvsq21807481.Shape;

public class Triangle extends Shape{

    public Point p2;
    public Point p3;

    public Triangle(String name, Point p1, Point p2, Point p3) {
        super(name, p1);
        this.p2 = p2;
        this.p3 = p3;
    }

    public void move(double x, double y) {
        this.getMainPoint().movePoint(x, y);
        this.p2.movePoint(x, y);
        this.p3.movePoint(x, y);
    }

    public void show() {
        System.out.println("Triangle(Point 1 = ("
                + this.getMainPoint().getX()
                + ","
                + this.getMainPoint().getY()
                + "), Point 2 = ("
                + this.p2.getX()
                + ","
                + this.p2.getY()
                + "), Point 3 = ("
                + this.p3.getX()
                + ","
                + this.p3.getY()
                + "))");
    }
}
