/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import classesJava.ArbitreDeLigne;
import classesJava.Court;
import classesJava.EquipeJoueur;
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
import java.util.Date;
import model.ObjectDAO.CourtDAO;
import model.ObjectDAO.EquipeArbitreDeLigneDAO;
import model.ObjectDAO.EquipeJoueurDAO;
import model.ObjectDAO.RamasseurDeBalleDAO;

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
            EquipeJoueurDAO equipeDAO = new EquipeJoueurDAO(connexionBD);
            RamasseurDeBalleDAO rDAO = new RamasseurDeBalleDAO(connexionBD);
            EquipeArbitreDeLigneDAO equipeALDAO = new EquipeArbitreDeLigneDAO(connexionBD);
            ArrayList<EquipeArbitreDeLigne> lesAL = equipeALDAO.findAll();
            Joueur j1 = joueurDAO.findById(2);
            EquipeJoueur equipe1 = equipeDAO.findById(1);
            System.out.println("Nom joueur dont l'id est 1: " + j1.getNomJ());
            System.out.println("ID du joueur 2 dont l'id est 2 dans la base de données :" + equipe1.getJoueur2().getIdJoueur());
            System.out.println(lesAL.get(0).getLesArbitresDeLigne().get(0).getNom());
            System.out.println("Le premier ramasseur de balle se nomme: " + rDAO.findAll().get(0).getPrenomR());
            
            Date dateD = new Date(2020 -1900, 0, 27);
            Date dateF = new Date(2020 -1900,0,28);
            System.out.println(dateD +" - " + dateF);
            CourtDAO courtdao = new CourtDAO(connexionBD);
            ArrayList<Court> courtsLibre = courtdao.findFreeCourts(dateD,dateF);
            for(Court c : courtsLibre){
                System.out.println("id court libre: " + c.getIdCourt() + " typeCourt: " + c.getTypeCourt());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
