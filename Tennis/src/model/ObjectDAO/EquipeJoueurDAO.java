package model.ObjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import classesJava.EquipeJoueur;
import classesJava.Joueur;
import model.interfaces.InterfaceEquipeJoueurDAO;

public class EquipeJoueurDAO implements InterfaceEquipeJoueurDAO {

    private final Connection connexionBD;

    public EquipeJoueurDAO(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public EquipeJoueur findById(int idEquipe) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        EquipeJoueur equipe = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * FROM Joueur WHERE idEquipeJ=?");
            pst.setInt(1, idEquipe);
            rset = pst.executeQuery();
            ArrayList<Joueur> joueurs = new ArrayList<>();
            while (rset.next()) {
                JoueurDAO joueurDAO = new JoueurDAO(connexionBD);
                Joueur j = joueurDAO.findById(rset.getInt(2));
                joueurs.add(j);
            }
            equipe = new EquipeJoueur(idEquipe, joueurs);

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
    public int create (EquipeJoueur equipe) throws SQLException {
        int rowCount = 0;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO Joueur VALUES (?,?,?,?,?)");
            pst.setInt(2, equipe.getIdEquipe());
            JoueurDAO dao = new JoueurDAO(connexionBD);
            if(equipe.getLesJoueurs().size()==2){
                for(Joueur j : equipe.getLesJoueurs()){
                    rowCount += dao.create(j);
                }
            }else
                rowCount = -1;
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
    public ArrayList<EquipeJoueur> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<EquipeJoueur> lesEquipe = new ArrayList<EquipeJoueur>();
        try{
            ResultSet rs = st.executeQuery("SELECT distinct idEquipeJ from Joueur");
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
                EquipeJoueur equipe = new EquipeJoueur(no,joueurs);
                lesEquipe.add(equipe);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesEquipe;

    }


    public int delete(EquipeJoueur equipe) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("Update Joueur set idEquipeJ = 0 WHERE idEquipeJ=?");
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


    public int update (EquipeJoueur equipe) throws SQLException {
        int rowCount = 0;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE Joueur SET idEquipeJ=? WHERE idJoueur=?");
            pst.setInt(1, equipe.getIdEquipe());
            if(equipe.getLesJoueurs().size()==2){
                for(Joueur j : equipe.getLesJoueurs()){
                    pst.setInt(2, j.getIdJoueur());
                    rowCount += pst.executeUpdate();
                }
            }else rowCount = -1;

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
