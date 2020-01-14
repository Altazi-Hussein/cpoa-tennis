package model.ObjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import model.interfaces.InterfaceJoueurDAO;
import classesJava.Joueur;

public class JoueurDAO implements InterfaceJoueurDAO {

    private final Connection connexionBD;

    public JoueurDAO(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public Joueur findById(int idJoueur) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        Joueur j = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * FROM Joueur WHERE idJoueur=?");
            pst.setInt(1, idJoueur);
            rset = pst.executeQuery();
            if (rset.next()) {
                j = new Joueur(rset.getInt(1), rset.getInt(2), rset.getString(3) ,rset.getString(4), rset.getString(5));
            }
            else 
            {
                throw new SQLException ("Contact " + idJoueur + " inconnu");
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
            pst = connexionBD.prepareStatement("INSERT INTO Joueur VALUES (?,?,?,?,?)");
            pst.setInt(1, j.getIdJoueur());
            pst.setInt(2, j.getEquipe());
            pst.setString(3, j.getNationaliteJoueur());
            pst.setString(4, j.getNomJoueur());
            pst.setString(5, j.getPrenomJoueur());
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
        ArrayList<Joueur> lesJoueur = new ArrayList<Joueur>();
        try{
            ResultSet rs = st.executeQuery("SELECT * from Joueur");
            int no;
            String nom;
            String pre;
            String nat;
            int eq;
            while (rs.next()){
                no = rs.getInt(1);
                eq = rs.getInt(2);
                nat = rs.getString(3);
                nom = rs.getString(4);
                pre = rs.getString(5);
                
                
                Joueur j = new Joueur(no, eq, nat, nom, pre);
                lesJoueur.add(j);
            }  
        }catch (SQLException exc) {
            throw exc;
        }
        return lesJoueur;
        
    }


    public int delete(Joueur j) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from Joueur WHERE idJoueur=?");
            pst.setInt(1, j.getIdJoueur());
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


    public int update (Joueur j) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE Joueur SET prenomJoueur=?, nomJoueur=?, nationaliteJoueur=?, equipe=? WHERE idJoueur=?");
            pst.setString(1, j.getPrenomJoueur());
            pst.setString(2, j.getNomJoueur());
            pst.setString(3, j.getNationaliteJoueur());
            pst.setInt(4, j.getEquipe());
            pst.setInt(5, j.getIdJoueur());
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

}
