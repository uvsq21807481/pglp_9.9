package uvsq21807481.DAO_JDBC;

import uvsq21807481.Shape.Triangle;
import uvsq21807481.Shape.Point;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOTriangle extends DAOJdbc<Triangle>{

    @Override
    public void create(Triangle t) {
        this.open();
        try {
            PreparedStatement newTriangle = this.register.prepareStatement(
                    "INSERT INTO Triangle (name, x1, y1, x2, y2, x3, y3) VALUES (?,?,?,?,?,?,?)");
            newTriangle.setString(1, t.getName());
            newTriangle.setString(2, String.valueOf(t.getMainPoint().getX()));
            newTriangle.setString(3, String.valueOf(t.getMainPoint().getY()));
            newTriangle.setString(4, String.valueOf(t.p2.getX()));
            newTriangle.setString(5, String.valueOf(t.p2.getY()));
            newTriangle.setString(6, String.valueOf(t.p3.getX()));
            newTriangle.setString(7, String.valueOf(t.p3.getY()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }

    @Override
    public Triangle read(String s) {
        this.open();
        Triangle t = null;
        try {
            PreparedStatement selectTriangle = this.register.prepareStatement(
                    "SELECT * FROM Triangle WHERE name = ?");
            selectTriangle.setString(1, s);
            ResultSet rs = selectTriangle.executeQuery();
            if(rs.next()) {
                t = new Triangle(s,
                        new Point(rs.getDouble("x1"), rs.getDouble("y1")),
                        new Point(rs.getDouble("x2"), rs.getDouble("y2")),
                        new Point(rs.getDouble("x3"), rs.getDouble("y3")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
        return t;
    }

    @Override
    public void update(Triangle t, String s) {
        this.open();
        try {
            PreparedStatement updateTriangle = this.register.prepareStatement(
                    "UPDATE Triangle SET name = '?', x1 = '?', y1 = '?', x2 = '?', y2 = '?', x3 = '?', y3 = '?'" +
                            " WHERE name = ?");
            updateTriangle.setString(1, t.getName());
            updateTriangle.setString(2, String.valueOf(t.getMainPoint().getX()));
            updateTriangle.setString(3, String.valueOf(t.getMainPoint().getY()));
            updateTriangle.setString(4, String.valueOf(t.p2.getX()));
            updateTriangle.setString(5, String.valueOf(t.p2.getY()));
            updateTriangle.setString(6, String.valueOf(t.p3.getX()));
            updateTriangle.setString(7, String.valueOf(t.p3.getY()));
            updateTriangle.setString(8, s);
            updateTriangle.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }

    @Override
    public void delete(String s) {
        this.open();
        try {
            PreparedStatement deleteTriangle = this.register.prepareStatement(
                    "DELETE FROM Triangle WHERE name = ?");
            deleteTriangle.setString(1, s);
            deleteTriangle.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }
}
