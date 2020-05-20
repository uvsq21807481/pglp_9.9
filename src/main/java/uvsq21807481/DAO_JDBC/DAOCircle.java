package uvsq21807481.DAO_JDBC;

import uvsq21807481.Shape.Circle;
import uvsq21807481.Shape.Point;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCircle extends DAOJdbc<Circle> {

    @Override
    public void create(Circle c) {
        this.open();
        try {
            PreparedStatement newCircle = this.register.prepareStatement(
                    "INSERT INTO Circle(name, centerX, centerY, radius) VALUES (?,?,?,?)");
            newCircle.setString(1, c.getName());
            newCircle.setString(2, String.valueOf(c.getMainPoint().getX()));
            newCircle.setString(3, String.valueOf(c.getMainPoint().getY()));
            newCircle.setString(4, String.valueOf(c.radius));
            newCircle.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }

    @Override
    public Circle read(String s) {
        this.open();
        Circle c = null;

        try {
            PreparedStatement findCircle = this.register.prepareStatement(
                    "SELECT * FROM Circle WHERE name = ?");
            findCircle.setString(1, s);
            ResultSet rs = findCircle.executeQuery();
            if(rs.next()) {
                c = new Circle(s, new Point(rs.getDouble("centerX"), rs.getDouble("centerY")), rs.getDouble("radius"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
        return c;
    }

    @Override
    public void update(Circle c, String s) {
        this.open();
        try {
            PreparedStatement updateCircle = this.register.prepareStatement(
                    "UPDATE Circle SET name = '?', centerX = '?', centerY = '?', radius = '?'" +
                            " WHERE name = ?");
            updateCircle.setString(1, c.getName());
            updateCircle.setString(2, String.valueOf(c.getMainPoint().getX()));
            updateCircle.setString(3, String.valueOf(c.getMainPoint().getY()));
            updateCircle.setString(4, String.valueOf(c.radius));
            updateCircle.setString(5, s);
            updateCircle.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }

    @Override
    public void delete(String s) {
        this.open();
        try {
            PreparedStatement deleteCircle = this.register.prepareStatement(
                    "DELETE FROM Circle WHERE name = ?");
            deleteCircle.setString(1, s);
            deleteCircle.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }
}
