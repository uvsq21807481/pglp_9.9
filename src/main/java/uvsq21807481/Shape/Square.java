package uvsq21807481.Shape;

public class Square extends Shape{

    public double side;

    public Square(String name, double x, double y, double side) {
        super(name, x, y);
        this.side = side;
    }

    @Override
    public void move(double x, double y) {
        this.getMainPoint().movePoint(x, y);
    }

    @Override
    public void show() {

        double upLeftX = this.getMainPoint().getX() - (side / 2);
        double upLeftY = this.getMainPoint().getY() + (side / 2);

        double upRightX = this.getMainPoint().getX() + (side / 2);
        double upRightY = this.getMainPoint().getY() + (side / 2);

        double downLeftX = this.getMainPoint().getX() - (side / 2);
        double downLeftY = this.getMainPoint().getY() - (side / 2);

        double downRightX = this.getMainPoint().getX() + (side / 2);
        double downRightY = this.getMainPoint().getY() - (side / 2);

        System.out.println("Square(Up left = ("
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
