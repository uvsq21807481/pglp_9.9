package uvsq21807481.DAO_JDBC;
import uvsq21807481.Shape.*;

public class DAOFactory {

    public static DAOJdbc<Circle> getDAOCircle() {
        return new DAOCircle();
    }
}
