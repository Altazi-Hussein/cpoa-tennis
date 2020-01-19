package model.ObjectDAO;

import classesJava.ArbitreDeChaise;
import classesJava.Court;
import classesJava.EquipeArbitreDeLigne;
import classesJava.EquipeRamasseur;
import classesJava.Joueur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.interfaces.InterfaceMatchSimpleDAO;
import classesJava.MatchSimple;
import classesJava.ScoreMatch;
import java.util.Date;

public class MatchSimpleDAO implements InterfaceMatchSimpleDAO {

    private final Connection connexionBD;

    public MatchSimpleDAO(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public MatchSimple findById(int idMatchSimple) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        MatchSimple matchS = null;
        try {
            pst = connexionBD.prepareStatement("SELECT tournoi, idJoueur1, idJoueur2, idMatch, idPlanning, idAChaise, idEquipeAL, idEquipeR, dateDebutM, dateFinM, idCourt, idGagnant, tour"
                    + "from MatchSimple join `Match` on idMatchSimple=idMatch WHERE idMatchSimple=?");
            pst.setInt(1, idMatchSimple);
            rset = pst.executeQuery();
            if (rset.next()) {
                ArbitreDeChaiseDAO acDAO = new ArbitreDeChaiseDAO(connexionBD);
                EquipeArbitreDeLigneDAO eqAL = new EquipeArbitreDeLigneDAO(connexionBD);
                EquipeRamasseurDAO eqR = new EquipeRamasseurDAO(connexionBD);
                CourtDAO cDAO = new CourtDAO(connexionBD);
                ScoreMatchDAO sDAO = new ScoreMatchDAO(connexionBD);
                JoueurDAO jDAO = new JoueurDAO(connexionBD);
                
                
                ArbitreDeChaise arbitreC = acDAO.findbyId(rset.getInt(6));
                EquipeArbitreDeLigne equipeAL = eqAL.findById(rset.getInt(7));
                EquipeRamasseur equipeR = eqR.findById(rset.getInt(8));
                Court court = cDAO.findById(rset.getInt(11));
                ScoreMatch scorematch = sDAO.findById(rset.getInt(4));
                Joueur j1 = jDAO.findById(rset.getInt(2));
                Joueur j2 = jDAO.findById(rset.getInt(3));
                ArrayList<Joueur> lesJoueurs = new ArrayList<>();
                lesJoueurs.add(j1);
                lesJoueurs.add(j2);
                Date dateD = new Date(rset.getString(9));
                Date dateF = new Date(rset.getString(10));
                
                int idGagnant = rset.getInt(12); 
                if (idGagnant == 0) idGagnant = scorematch.getGagnant();
                
                matchS = new MatchSimple(rset.getInt(1), lesJoueurs, idMatchSimple, rset.getInt(5), arbitreC, equipeAL, equipeR,dateD, dateF, court, scorematch, rset.getInt(13), idGagnant);
            }
            else 
            {
                throw new SQLException ("Match Simple : " + idMatchSimple + " inconnu");
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
        return matchS;
    }

    @Override
    public int create (MatchSimple ms) throws SQLException {
        int rowCount = 0;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO MatchSimple VALUES (?,?,?,?)");
            pst.setInt(1, ms.getIdMatch());
            pst.setInt(2, ms.getLesJoueurs().get(0).getIdJoueur());
            pst.setInt(3, ms.getLesJoueurs().get(1).getIdJoueur());
            pst.setInt(4, ms.getTournoi());
            rowCount += pst.executeUpdate();
            pst = connexionBD.prepareStatement("INSERT INTO `Match` VALUES (?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, ms.getIdMatch());
            pst.setInt(2, ms.getArbitreDeChaise().getIdArbitre());
            pst.setInt(3, ms.getEquipeArbitresDeLigne().getIdEquipeAL());
            pst.setInt(4, ms.getEquipeDeRamasseur().getIdEquipeR());
            
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateD = sdf.format(ms.getDateDebut());
            String dateF = sdf.format(ms.getDateFin());
            
            pst.setString(5, dateD);
            pst.setString(6, dateF);
            pst.setInt(7, ms.getCourt().getIdCourt());
            pst.setInt(8, ms.getIdGagnant());
            pst.setInt(9, ms.getTour());
            pst.setInt(10, ms.getIdPlanning());
            rowCount += pst.executeUpdate();
            
            ScoreMatchDAO sDAO = new ScoreMatchDAO(connexionBD);
            rowCount += sDAO.create(ms.getScore());
            
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Code d'erreur : "+ exc.getErrorCode() +"\nMessage d'erreur : "+ exc.getMessage());
            rowCount = -1;
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
    public ArrayList<MatchSimple> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<MatchSimple> lesMatchSimple = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("SELECT idMatchSimple from MatchSimple");
            while (rs.next()){
                MatchSimple ms = this.findById(rs.getInt(1));
                lesMatchSimple.add(ms);
            }  
        }catch (SQLException exc) {
            throw exc;
        }
        return lesMatchSimple;
        
    }


    @Override
    public int delete(MatchSimple ms) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from MatchSimple WHERE idMatchSimple=?; delete from `Match` where idMatch = ?");
            pst.setInt(1, ms.getIdMatch());
            pst.setInt(2, ms.getIdMatch());
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
    public int update (MatchSimple ms) throws SQLException {
        int rowCount = 0;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE MatchSimple SET idJoueurs1=?, idJoueur2=?, tournoi=? WHERE idMatchSimple=?");
            pst.setInt(1, ms.getLesJoueurs().get(0).getIdJoueur());
            pst.setInt(2, ms.getLesJoueurs().get(1).getIdJoueur());
            pst.setInt(3, ms.getTournoi());
            rowCount += pst.executeUpdate();
            
            pst = connexionBD.prepareStatement("UPDATE `Match` SET idPlanning=?, idAChaise=?, idEquipeAL=?, idEquipeR=?, dateDebutM=?, dateFinM=?, idCourt=?, idGagnant=?, tour=?"
                    + " WHERE idMatch=?");
            pst.setInt(10, ms.getIdMatch());
            pst.setInt(1, ms.getIdPlanning());
            pst.setInt(2, ms.getArbitreDeChaise().getIdArbitre());
            pst.setInt(3, ms.getEquipeArbitresDeLigne().getIdEquipeAL());
            pst.setInt(4, ms.getEquipeDeRamasseur().getIdEquipeR());
            
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateD = sdf.format(ms.getDateDebut());
            String dateF = sdf.format(ms.getDateFin());
            
            pst.setString(5, dateD);
            pst.setString(6, dateF);
            
            pst.setInt(7, ms.getCourt().getIdCourt());
            pst.setInt(8, ms.getIdGagnant());
            pst.setInt(9, ms.getTour());
            rowCount += pst.executeUpdate();
            
            ScoreMatchDAO sDAO = new ScoreMatchDAO(connexionBD);
            sDAO.update(ms.getScore());

        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Code d'erreur : "+ exc.getErrorCode() +"\nMessage d'erreur : "+ exc.getMessage());
            rowCount = -1;
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
    public ArrayList<MatchSimple> findAllMatchsQualif() throws SQLException {
        PreparedStatement pst = null;
        ArrayList<MatchSimple> lesMatchSimple = new ArrayList<>();
        ResultSet rset;
        try{
            pst = connexionBD.prepareStatement("select idMatchSaimple from MatchSimple where tournoi=?");
            pst.setInt(1, 0);
            rset = pst.executeQuery();
            while (rset.next()){
                MatchSimple ms = this.findById(rset.getInt(1));
                lesMatchSimple.add(ms);
            }  
        }catch (SQLException exc) {
            throw exc;
        }
        return lesMatchSimple;
    }

    @Override
    public ArrayList<MatchSimple> findAllMatchsTTournoi() throws SQLException {
        PreparedStatement pst = null;
        ArrayList<MatchSimple> lesMatchSimple = new ArrayList<>();
        ResultSet rset;
        try{
            pst = connexionBD.prepareStatement("select idMatchSaimple from MatchSimple where tournoi=?");
            pst.setInt(1, 1);
            rset = pst.executeQuery();
            while (rset.next()){
                MatchSimple ms = this.findById(rset.getInt(1));
                lesMatchSimple.add(ms);
            }  
        }catch (SQLException exc) {
            throw exc;
        }
        return lesMatchSimple;
    }

}
