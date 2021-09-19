package data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class EMFactory {
    public static EntityManagerFactory getConnection() throws SQLException {
        return Persistence.createEntityManagerFactory("gregoryDB");
    }
}
