package uvsq21807481.Shape;

public class Rectangle extends Shape{

    public double length;
    public double width;

    public Rectangle(String name, double x, double y, double length, double width) {
        super(name, x, y);
        this.length = length;
        this.width = width;
    }

    @Override
    public void move(double x, double y) {
        this.getMainPoint().movePoint(x, y);
    }

    @Override
    public void show() {
        double upLeftX = this.getMainPoint().getX() - (width / 2);
        double upLeftY = this.getMainPoint().getY() + (length / 2);

        double upRightX = this.getMainPoint().getX() + (width / 2);
        double upRightY = this.getMainPoint().getY() + (length / 2);

        double downLeftX = this.getMainPoint().getX() - (width / 2);
        double downLeftY = this.getMainPoint().getY() - (length / 2);

        double downRightX = this.getMainPoint().getX() + (width / 2);
        double downRightY = this.getMainPoint().getY() - (length / 2);
        System.out.println(
                "Rectangle(Up left = ("
                        + upLeftX
                        + ","
                        + upLeftY
                        + "), Up right = ("
                        + upRightX
                        + ","
                        + upRightY
                        + "), Down left = ("
                        + downLeftX
                        + ","
                        + downLeftY
                        + "), Down right =("
                        + downRightX
                        + ","
                        + downRightY
                        + ")"
        );
    }
}
