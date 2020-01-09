package model;

import java.sql.*;

public class ConnexionBD {

private static Connection conn; // l’instance en champ privé
/**
* Méthode qui va retourner l’instance de connexion ou la créer si elle n'existe pas
* @return Connection
     * @throws java.sql.SQLException
*/
public static Connection getConnection() throws SQLException, ClassNotFoundException {

    try{
        if (conn == null) {
            String base = "jdbc:mysql://iutdoua-web.univ-lyon1.fr/p1806052";
            String login = "p1806052";
            String pwd = "368992";
            conn = DriverManager.getConnection(base, login, pwd);
            System.out.println("==> connexion à MariaDB effectuee !");
            }
    }catch (Exception e) {
        e.printStackTrace();
    }
return conn;
}
}