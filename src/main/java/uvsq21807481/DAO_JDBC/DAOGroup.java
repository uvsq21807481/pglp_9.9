package uvsq21807481.DAO_JDBC;

import uvsq21807481.Shape.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOGroup extends DAOJdbc<Group>{

    @Override
    public void create(Group g) {
        this.open();
        try {
            PreparedStatement newGroup = this.register.prepareStatement(
                    "INSERT INTO Group(name) VALUES (?)");
            newGroup.setString(1, g.getName());
            newGroup.execute();

            PreparedStatement newBelong = this.register.prepareStatement(
                    "INSERT INTO Belong (groupName, shapeName, type) VALUES (?, ?, ?)");
            ArrayList<Shape> shapes = g.getShapes();
            for(Shape s : shapes) {
                newBelong.setString(1, g.getName());
                newBelong.setString(2, s.getName());
                if(s instanceof Circle) {
                    newBelong.setString(3, "circle");
                }
                else if(s instanceof Rectangle) {
                    newBelong.setString(3, "rectangle");
                }
                else if(s instanceof Square) {
                    newBelong.setString(3, "square");
                }
                else if(s instanceof Triangle) {
                    newBelong.setString(3, "triangle");
                }
                newBelong.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }

    @Override
    public Group read(String s) {
        this.open();
        Group g = null;
        try {
            PreparedStatement selectGroup = this.register.prepareStatement(
                    "SELECT * FROM Group WHERE name = ?");
            selectGroup.setString(1, s);
            ResultSet rs = selectGroup.executeQuery();

            PreparedStatement selectBelong = this.register.prepareStatement(
                    "SELECT * FROM Belong WHERE groupName = ?");
            ResultSet rs2 = selectBelong.executeQuery();

            if(rs.next()) {
                g = new Group(s);
                DAOJdbc dao;
                while(rs2.next()) {
                    if(rs2.getString("type").contains("circle")) {
                        dao = new DAOCircle();
                        g.addShape((Circle) dao.read(rs2.getString("shapeName")));
                    }
                    else if(rs2.getString("type").contains("rectangle")) {
                        dao = new DAORectangle();
                        g.addShape((Rectangle) dao.read(rs2.getString("shapeName")));
                    }
                    else if(rs2.getString("type").contains("square")) {
                        dao = new DAOSquare();
                        g.addShape((Square) dao.read(rs2.getString("shapeName")));
                    }
                    else if(rs2.getString("type").contains("triangle")) {
                        dao = new DAOTriangle();
                        g.addShape((Triangle) dao.read(rs2.getString("shapeName")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
        return g;
    }

    @Override
    public void update(Group g, String s) {
        //Ne permet pas de modifier quelles formes composent le groupe dans les groupes
        //Necessité d'une partie JDBC dédiée à BELONG ?
        this.open();
        try {
            PreparedStatement updateGroup = this.register.prepareStatement(
                    "UPDATE Group SET name = '?' WHERE name = ?");
            updateGroup.setString(1, g.getName());
            updateGroup.setString(2, s);
            updateGroup.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }

    @Override
    public void delete(String s) {
        this.open();
        try {
            PreparedStatement deleteBelong = this.register.prepareStatement(
                    "DELETE FROM Belong WHERE groupName = ?");
            deleteBelong.setString(1, s);
            deleteBelong.execute();

            PreparedStatement deleteGroup = this.register.prepareStatement(
                    "DELETE FROM Group WHERE name = ?");
            deleteGroup.setString(1, s);
            deleteGroup.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }
}
