package model;

import java.sql.*;

public class ConnexionBD {

private static Connection conn; // l’instance en champ privé
/**
* Méthode qui va retourner l’instance de connexion ou la créer si elle n'existe pas
* @return Connection
     * @throws SQLException
*/
public static Connection getConnection() throws SQLException, ClassNotFoundException {

    try {
        //On teste si la connexion n’est pas deja ouverte
        if (conn == null) {
            Class.forName("com.mysql.jdbc.Driver");
            // Connexion à MariaDB de l’IUT (OK juin 2018) :
            DriverManager.getConnection("jdbc:mysql://iutdoua-web.univ-lyon1.fr:3306/p1806052", // ici nom de votre base
                    "p1806052", "368992"); // ici vos login et pwd
            System.out.println("==> connexion à MariaDB effectuee !");
            // (c’est bien la BD MariaDB mais les processus sont encore appelés mySQL dans la version APACHE de l’IUT…)
        }
    }catch (ClassNotFoundException e){
        System.out.println(e.getMessage());
    }
    // si la connexion existe, on la renvoie
return conn;
}
}