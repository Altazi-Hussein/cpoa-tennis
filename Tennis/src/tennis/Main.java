/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import classesJava.ArbitreDeLigne;
import classesJava.Equipe;
import classesJava.EquipeArbitreDeLigne;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ObjectDAO.JoueurDAO;
import model.MonMariaDbDataSource;
import classesJava.Joueur;
import java.util.List;
import java.util.ArrayList;
import model.ObjectDAO.EquipeArbitreDeLigneDAO;
import model.ObjectDAO.EquipeDAO;

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
            MonMariaDbDataSource dataSourceDAO = MonMariaDbDataSource.getMdbDataSource();
            Connection connexionBD = dataSourceDAO.getConnection();
            JoueurDAO joueurDAO = new JoueurDAO(connexionBD);
            EquipeDAO equipeDAO = new EquipeDAO(connexionBD);
            EquipeArbitreDeLigneDAO equipeALDAO = new EquipeArbitreDeLigneDAO(connexionBD);
            ArrayList<EquipeArbitreDeLigne> lesAL = equipeALDAO.findAll();
            List<Joueur> lesJoueurs = joueurDAO.findAll();
            Joueur j1 = joueurDAO.findById(1);
            Equipe equipe1 = equipeDAO.findById(1);
            System.out.println("Nom joueur dont l'id est 1: " + j1.getNomJoueur());
            System.out.println("ID du joueur 2 dont l'id est 2 dans la base de données :" + equipe1.getJoueur2().getIdJoueur());
            System.out.println("");


        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
