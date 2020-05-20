package uvsq21807481.DAO_JDBC;

import uvsq21807481.Shape.Rectangle;
import uvsq21807481.Shape.Point;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAORectangle extends DAOJdbc<Rectangle> {

    @Override
    public void create(Rectangle r) {
        this.open();
        try {
            PreparedStatement newRectangle = this.register.prepareStatement(
                    "INSERT INTO Rectangle(name, centerX, centerY, length, width) VALUES (?,?,?,?,?)");
            newRectangle.setString(1, r.getName());
            newRectangle.setString(2, String.valueOf(r.getMainPoint().getX()));
            newRectangle.setString(3, String.valueOf(r.getMainPoint().getY()));
            newRectangle.setString(4, String.valueOf(r.length));
            newRectangle.setString(5, String.valueOf(r.width));
            newRectangle.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }

    @Override
    public Rectangle read(String s) {
        this.open();
        Rectangle r = null;

        try {
            PreparedStatement findRectangle = this.register.prepareStatement(
                    "SELECT * FROM Rectangle WHERE name = ?");
            findRectangle.setString(1, s);
            ResultSet rs = findRectangle.executeQuery();
            if(rs.next()) {
                r = new Rectangle(s, new Point(rs.getDouble("centerX"), rs.getDouble("centerY")), rs.getDouble("length"), rs.getDouble("width"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
        return r;
    }

    @Override
    public void update(Rectangle r, String s) {
        this.open();
        try {
            PreparedStatement updateRectangle = this.register.prepareStatement(
                    "UPDATE Rectangle SET name = '?', centerX = '?', centerY = '?', length = '?', width = '?'" +
                            " WHERE name = ?");
            updateRectangle.setString(1, r.getName());
            updateRectangle.setString(2, String.valueOf(r.getMainPoint().getX()));
            updateRectangle.setString(3, String.valueOf(r.getMainPoint().getY()));
            updateRectangle.setString(4, String.valueOf(r.length));
            updateRectangle.setString(5, String.valueOf(r.width));
            updateRectangle.setString(6, s);
            updateRectangle.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }

    @Override
    public void delete(String s) {
        this.open();
        try {
            PreparedStatement deleteRectangle = this.register.prepareStatement(
                    "DELETE FROM Rectangle WHERE name = ?");
            deleteRectangle.setString(1, s);
            deleteRectangle.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }
}
