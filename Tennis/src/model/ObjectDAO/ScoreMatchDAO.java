package model.ObjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.interfaces.InterfaceScoreMatchDAO;
import classesJava.ScoreMatch;

public class ScoreMatchDAO implements InterfaceScoreMatchDAO {

    private final Connection connexionBD;

    public ScoreMatchDAO(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public ScoreMatch findById(int idMatch) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        ScoreMatch sm = null;
        try {
            pst = connexionBD.prepareStatement("SELECT count(*) from ScoreMatch WHERE idMatch=?");
            pst.setInt(1, idMatch);
            rset = pst.executeQuery();
            if(rset.next()){
                int nbLignes = rset.getInt(1);
                int[][] score;
                score = new int[nbLignes][2];
                pst = connexionBD.prepareStatement("SELECT * from ScoreMatch WHERE idMatch=?");
                pst.setInt(1, idMatch);
                rset = pst.executeQuery();
                while(rset.next()){
                    score[rset.getInt(2) - 1][0] = rset.getInt(3);
                    score[rset.getInt(2) - 1][1] = rset.getInt(4);
                }
                sm = new ScoreMatch(idMatch, score);
            }else 
            {
                throw new SQLException ("Score " + idMatch + " n'existe pas");
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
        return sm;
    }

    @Override
    public int create (ScoreMatch sm) throws SQLException {
        int rowCount = 0;
        PreparedStatement pst = null;
        int[][] score;
        try {
            score = sm.getScoreMatch();
            for(int i = 0; i<score.length; i++){
                pst = connexionBD.prepareStatement("INSERT INTO ScoreMatch VALUES (?,?,?,?)");
                pst.setInt(1, sm.getIdMatch());
                pst.setInt(2, i+1);
                pst.setInt(3, score[i][0]);
                pst.setInt(4, score[i][1]);
                rowCount += pst.executeUpdate();
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
    public int delete(ScoreMatch sm) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from ScoreMatch WHERE idMatch=?");
            pst.setInt(1, sm.getIdMatch());
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
    public int update (ScoreMatch sm) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            this.delete(sm);
            rowCount = this.create(sm);
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
