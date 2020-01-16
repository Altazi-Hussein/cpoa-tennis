/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ConnexionBD;
import model.DAO.JoueurDAO;
import planning.Joueur;
import java.util.List;

/**
 *
 * @author angel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            // TODO code application logic here
            Connection conn = ConnexionBD.getConnection();
            JoueurDAO joueurDAO = new JoueurDAO(conn);
            List<Joueur> lesJoueurs = joueurDAO.findAll();
            System.out.println(lesJoueurs.get(0).getIdJoueur());

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
