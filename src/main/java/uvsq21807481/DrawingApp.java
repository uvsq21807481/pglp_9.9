package uvsq21807481;

import uvsq21807481.Command.Command;
import uvsq21807481.Command.DrawingTUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DrawingApp {

    public static Connection co = null;
    public static Statement st = null;

    public static void initialize() {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            co = DriverManager.getConnection("jdbc:derby:Test;create=true");
            st = co.createStatement();

            String create = "CREATE TABLE Circle (name VARCHAR(30), centerX double, centerY double, radius double)";
            st.execute(create);

            create = "CREATE TABLE Rectangle (name VARCHAR(30), centreX double, centreY double, length double, width double)";
            st.execute(create);

            create = "CREATE TABLE Square (name VARCHAR(30), centreX double, centreY double, side double)";
            st.execute(create);

            create = "CREATE TABLE Triangle (name VARCHAR(30), x1 double, y1 double, x2 double, y2 double, x3 double, y3 double)";
            st.execute(create);

            create = "CREATE TABLE Group (name VARCHAR(30))";
            st.execute(create);

            create = "CREATE TABLE Link (groupName VARCHAR(30), shapeName VARCHAR(30), shapeType VARCHAR(30))";
            st.execute(create);

            co.close();
        } catch (ClassNotFoundException | SQLException e) {
            try {
                co.close();
            } catch (SQLException eSQL) {
                eSQL.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void run() {
        initialize();
        DrawingTUI dtui = new DrawingTUI();
        Command cmd;
        System.out.println("Everything draw goes into a group called 'all'");
        System.out.println("To see the available commands, type : list");
        while(true) {
            cmd = dtui.nextCommand();
            cmd.execute();
        }
    }

    public static void main(String[] args) {
        DrawingApp dApp = new DrawingApp();
        dApp.run();
    }
}
