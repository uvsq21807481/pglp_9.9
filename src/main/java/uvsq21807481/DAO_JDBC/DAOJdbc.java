package uvsq21807481.DAO_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAOJdbc<T> {

    Connection register = null;

    public abstract T create(T obj);
    public abstract T read(String name);
    public abstract T update(T obj, String name);
    public abstract void delete(String name);

    public void open() {
        String url = "jdbc:derby:Test;create=false";

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            register = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            register.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
