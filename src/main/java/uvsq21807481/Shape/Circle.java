package uvsq21807481.Shape;

public class Circle extends Shape{

    public double radius;

    public Circle(String name, Point p, double radius) {
        super(name, p);
        this.radius = radius;
    }

    @Override
    public void move(double x, double y) {
        this.getMainPoint().movePoint(x, y);
    }

    @Override
    public void show() {
        System.out.println("Circle(centre = ("
                            + this.getMainPoint().getX()
                            + ","
                            + this.getMainPoint().getY()
                            + "), radius = "
                            + this.radius
                            + ")");
    }
}
