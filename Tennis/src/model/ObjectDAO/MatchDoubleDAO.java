package model.ObjectDAO;

import classesJava.ArbitreDeChaise;
import classesJava.Court;
import classesJava.EquipeArbitreDeLigne;
import classesJava.EquipeRamasseur;
import classesJava.EquipeJoueur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.interfaces.InterfaceMatchDoubleDAO;
import classesJava.MatchDouble;
import classesJava.ScoreMatch;
import java.util.Date;

public class MatchDoubleDAO implements InterfaceMatchDoubleDAO {

    private final Connection connexionBD;

    public MatchDoubleDAO(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public MatchDouble findById(int idMatchDouble) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        MatchDouble matchD = null;
        try {
            pst = connexionBD.prepareStatement("SELECT idEquipeJ1, idEquipeJ2, idMatch, idPlanning, idAChaise, idEquipeAL, idEquipeR, dateDebutM, dateFinM, idCourt, idGagnant, tour"
                    + "from MatchDouble join `Match` on idMatchDouble=idMatch WHERE idMatchDouble=?");
            pst.setInt(1, idMatchDouble);
            rset = pst.executeQuery();
            if (rset.next()) {
                ArbitreDeChaiseDAO acDAO = new ArbitreDeChaiseDAO(connexionBD);
                EquipeArbitreDeLigneDAO eqAL = new EquipeArbitreDeLigneDAO(connexionBD);
                EquipeRamasseurDAO eqR = new EquipeRamasseurDAO(connexionBD);
                CourtDAO cDAO = new CourtDAO(connexionBD);
                ScoreMatchDAO sDAO = new ScoreMatchDAO(connexionBD);
                EquipeJoueurDAO eqJDAO = new EquipeJoueurDAO(connexionBD);
                
                
                ArbitreDeChaise arbitreC = acDAO.findbyId(rset.getInt(6));
                EquipeArbitreDeLigne equipeAL = eqAL.findById(rset.getInt(7));
                EquipeRamasseur equipeR = eqR.findById(rset.getInt(8));
                Court court = cDAO.findById(rset.getInt(11));
                ScoreMatch scorematch = sDAO.findById(rset.getInt(4));
                EquipeJoueur eq1 = eqJDAO.findById(rset.getInt(2));
                EquipeJoueur eq2 = eqJDAO.findById(rset.getInt(3));
                ArrayList<EquipeJoueur> lesEquipes = new ArrayList<>();
                lesEquipes.add(eq1);
                lesEquipes.add(eq2);
                Date dateD = new Date(rset.getString(9));
                Date dateF = new Date(rset.getString(10));
                
                int idGagnant = rset.getInt(12); 
                if (idGagnant == 0) idGagnant = scorematch.getGagnant();
                
                matchD = new MatchDouble( lesEquipes, idMatchDouble, rset.getInt(5), arbitreC, equipeAL, equipeR,dateD, dateF, court, scorematch, rset.getInt(13), idGagnant);
            }
            else 
            {
                throw new SQLException ("Match Simple : " + idMatchDouble + " inconnu");
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
        return matchD;
    }

    @Override
    public int create (MatchDouble ms) throws SQLException {
        int rowCount = 0;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO MatchDouble VALUES (?,?,?)");
            pst.setInt(1, ms.getIdMatch());
            pst.setInt(2, ms.getLesEquipesJoueur().get(0).getIdEquipe());
            pst.setInt(3, ms.getLesEquipesJoueur().get(1).getIdEquipe());
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
    public ArrayList<MatchDouble> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<MatchDouble> lesMatchDouble = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("SELECT idMatchDouble from MatchDouble");
            while (rs.next()){
                MatchDouble ms = this.findById(rs.getInt(1));
                lesMatchDouble.add(ms);
            }  
        }catch (SQLException exc) {
            throw exc;
        }
        return lesMatchDouble;
        
    }


    @Override
    public int delete(MatchDouble ms) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from MatchDouble WHERE idMatchDouble=?; delete from `Match` where idMatch = ?");
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
    public int update (MatchDouble ms) throws SQLException {
        int rowCount = 0;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE MatchDouble SET idEquipes1=?, idEquipe2=? WHERE idMatchDouble=?");
            pst.setInt(1, ms.getLesEquipesJoueur().get(0).getIdEquipe());
            pst.setInt(2, ms.getLesEquipesJoueur().get(1).getIdEquipe());
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

}
