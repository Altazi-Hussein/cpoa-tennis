package model;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;


/**
 *
 * @author p1806052
 */
public class MonDataSource extends OracleDataSource {
//L’instance unique

    private static MonOracleDataSource ods;
// Constructeur privé

    private MonOracleDataSource() throws SQLException {
    }

    public static MonOracleDataSource getOracleDataSource() throws
            SQLException{
        if (ods == null) {// on contrôle qu'il n' existe pas déjà une source de données
            ods = new MonOracleDataSource();
// on la définit avec les paramètres suivants :
            ods.setDriverType("thin");
            ods.setPortNumber(1521);
            ods.setServerName("iutdoua-oracle.univ-lyon1.fr");
            ods.setServiceName("orcl.univ-lyon1.fr");
            ods.setUser("p1806052");
            ods.setPassword("368992");
        } // sinon , un datasource existe déjà :
        return ods;
    }
}
