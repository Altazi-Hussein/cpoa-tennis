package model.ObjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            pst.setInt(2, j.getIdEquipeJ());
            pst.setString(3, j.getNationaliteJ());
            pst.setString(4, j.getNomJ());
            pst.setString(5, j.getPrenomJ());
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
    public ArrayList<Joueur> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<Joueur> lesJoueur = new ArrayList<>();
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


    @Override
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


    @Override
    public int update (Joueur j) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE Joueur SET prenomJ=?, nomJ=?, nationaliteJ=?, idEquipeJ=? WHERE idJoueur=?");
            pst.setString(1, j.getPrenomJ());
            pst.setString(2, j.getNomJ());
            pst.setString(3, j.getNationaliteJ());
            pst.setInt(4, j.getIdEquipeJ());
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
