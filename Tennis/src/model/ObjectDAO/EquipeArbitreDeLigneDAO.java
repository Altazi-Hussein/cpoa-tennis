/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ObjectDAO;

import classesJava.ArbitreDeLigne;
import classesJava.EquipeArbitreDeLigne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.interfaces.InterfaceEquipeArbitreDeLigne;

/**
 *
 * @author angel
 */
public class EquipeArbitreDeLigneDAO implements InterfaceEquipeArbitreDeLigne{

    private final Connection connexionBD;

    public EquipeArbitreDeLigneDAO(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public EquipeArbitreDeLigne findById(int idEquipe) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        EquipeArbitreDeLigne equipe = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * FROM EquipeArbitreDeLigne_ArbitreDeLigne WHERE idEquipeArbitreDeLigne=?");
            pst.setInt(1, idEquipe);
            rset = pst.executeQuery();
            ArbitreDeLigneDAO DAO = new ArbitreDeLigneDAO(connexionBD);
            ArrayList<ArbitreDeLigne> lesArbitres = null;
            while (rset.next()) {
                ArbitreDeLigne al = DAO.findbyId(rset.getInt(2));
                lesArbitres.add(al);
            }
            equipe = new EquipeArbitreDeLigne(idEquipe, lesArbitres);
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
        return equipe;
    }

    @Override
    public int create (EquipeArbitreDeLigne equipe) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO EquipeArbitreDeLigne VALUES (?)");
            pst.setInt(1, equipe.getIdEquipe());
            rowCount = pst.executeUpdate();
            for(ArbitreDeLigne a : equipe.getLesArbitresDeLigne()){
                pst = connexionBD.prepareStatement("INSERT INTO EquipeArbitreDeLigne_ArbitreDeLigne VALUES (?,?)");
                pst.setInt(1, equipe.getIdEquipe());
                pst.setInt(2, a.getIdArbitre());
                pst.executeUpdate();
            }

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
    public ArrayList<EquipeArbitreDeLigne> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<EquipeArbitreDeLigne> lesEquipe = new ArrayList<EquipeArbitreDeLigne>();
        try{
            ResultSet rs = st.executeQuery("SELECT * from Equipe");
            int no;
            Joueur j1, j2;
            while (rs.next()){
                no = rs.getInt(1);
                ArrayList<Joueur> joueurs = null;
                JoueurDAO joueurDao = new JoueurDAO(connexionBD);
                j1 = joueurDao.findById(rs.getInt(2));
                j2 = joueurDao.findById(rs.getInt(3));
                joueurs.add(j1);
                joueurs.add(j2);
                EquipeArbitreDeLigne equipe = new EquipeArbitreDeLigne(no,joueurs);
                lesEquipe.add(equipe);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesEquipe;

    }


    public int delete(EquipeArbitreDeLigne equipe) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from Equipe WHERE idEquipe=?");
            pst.setInt(1, equipe.getIdEquipe());
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


    public int update (EquipeArbitreDeLigne equipe) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE Equipe SET idJoueur1=?, idJoueur2=? WHERE idEquipe=?");
            pst.setInt(1, equipe);
            pst.setInt(2, equipe);
            pst.setInt(3, equipe);
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
    
}
