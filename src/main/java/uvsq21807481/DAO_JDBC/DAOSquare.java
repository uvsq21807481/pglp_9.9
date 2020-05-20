package uvsq21807481.DAO_JDBC;

import uvsq21807481.Shape.Square;
import uvsq21807481.Shape.Point;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOSquare extends DAOJdbc<Square>{

    @Override
    public Square create(Square s) {
        this.open();
        try {
            PreparedStatement newSquare = this.register.prepareStatement(
                    "INSERT INTO Square(name, centerX, centerY, side) VALUES (?,?,?,?)");
            newSquare.setString(1, s.getName());
            newSquare.setString(2, String.valueOf(s.getMainPoint().getX()));
            newSquare.setString(3, String.valueOf(s.getMainPoint().getY()));
            newSquare.setString(4, String.valueOf(s.side));
            newSquare.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
        return null;
    }

    @Override
    public Square read(String s) {
        this.open();
        Square square = null;

        try {
            PreparedStatement findRectangle = this.register.prepareStatement(
                    "SELECT * FROM Square WHERE name = ?");
            findRectangle.setString(1, s);
            ResultSet rs = findRectangle.executeQuery();
            if(rs.next()) {
                square = new Square(s, new Point(rs.getDouble("centerX"), rs.getDouble("centerY")), rs.getDouble("side"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
        return square;
    }

    @Override
    public Square update(Square square, String s) {
        this.open();
        try {
            PreparedStatement updateSquare = this.register.prepareStatement(
                    "UPDATE Square SET name = '?', centerX = '?', centerY = '?', side = '?'" +
                            " WHERE name = ?");
            updateSquare.setString(1, square.getName());
            updateSquare.setString(2, String.valueOf(square.getMainPoint().getX()));
            updateSquare.setString(3, String.valueOf(square.getMainPoint().getY()));
            updateSquare.setString(4, String.valueOf(square.side));
            updateSquare.setString(5, s);
            updateSquare.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
        return null;
    }

    @Override
    public void delete(String s) {
        this.open();
        try {
            PreparedStatement deleteRectangle = this.register.prepareStatement(
                    "DELETE FROM Square WHERE name = ?");
            deleteRectangle.setString(1, s);
            deleteRectangle.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }
}
