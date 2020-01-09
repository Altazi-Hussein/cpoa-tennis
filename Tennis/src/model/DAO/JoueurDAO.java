/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import model.interfaces.InterfaceJoueurDAO;
import planning.Joueur;

/**
 *
 * @author p1806052
 */
public class JoueurDAO implements InterfaceJoueurDAO {

    private static Connection connexionBD;

    public JoueurDAO(Connection c) {
        JoueurDAO.connexionBD = c;
    }

    @Override
    public Joueur findById(int noJoueur) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        Joueur j = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * FROM Joueur WHERE idJoueur=?");
            pst.setInt(1, noJoueur);
            rset = pst.executeQuery();
            if (rset.next()) {
                j = new Joueur(rset.getInt(1), rset.getString(2), rset.getString(3) ,rset.getString(4));
            }
            else 
            {
                throw new SQLException ("Contact " + noJoueur + " inconnu");
            }

        } catch (SQLException exc) {
            throw exc;
        } finally {
            try {
                // la clause finally est toujours executée, quoi qu'il arrive
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException exc) {
                throw exc;
            }
        }
        return j;
    }

    @Override
    public int create (Joueur j) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO Joueur VALUES (?,?,?,?)");
            pst.setInt(1, j.getIdJoueur());
            pst.setString(2, j.getNomJoueur());
            pst.setString(3, j.getPrenomJoueur());
            pst.setString(4, j.getNationaliteJoueur());
            rowCount = pst.executeUpdate();

        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Code d'erreur : "+ exc.getErrorCode() +"\nMessage d'erreur : "+ exc.getMessage());
            throw exc;
        } finally {
            try {
                // la clause finally est toujours executée, quoi qu'il arrive
                if (pst != null) {
                    pst.close();

                }
            } catch (SQLException exc) {
                throw exc;
            }
        }
        return rowCount;
    }

    @Override
    public List<Joueur> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<Joueur> lesJoueur = null;
        try{
            lesJoueur = new ArrayList<Joueur>();
            ResultSet rs = st.executeQuery("SELECT * from Joueur");
            int no;
            String nom;
            String pre;
            String nat;
            while (rs.next()){
                no = rs.getInt(1);
                nom = rs.getString(2);
                pre = rs.getString(3);
                nat = rs.getString(4);
                Joueur j = new Joueur(no, nom, pre, nat);
                lesJoueur.add(j);
            }  
        }catch (SQLException exc) {
            throw exc;
        }
        return lesJoueur;
        
    }

}
