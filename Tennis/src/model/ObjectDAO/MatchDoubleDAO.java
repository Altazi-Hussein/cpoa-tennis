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
    public int create (MatchDouble md) throws SQLException {
        int rowCount = 0;
PreparedStatement pst = null;
        ResultSet rset = null;
        boolean possible = false;
        String texte = "";
        try {
            
            if(md.getTour()==4){ //1/8 de finale
                pst = connexionBD.prepareStatement("select count(*) from `Match` where tour = 4 and idPlanning=?");
                rset = pst.executeQuery();
                if (rset.next()){
                    if(rset.getInt(1)<16) possible = true; 
                    else texte = "Il y a déjà 16 matchs pour les huitèmes de final";
                }else possible = true;
            }
            
            if(md.getTour()==3){ //1/4 de finale
                pst = connexionBD.prepareStatement("select count(*) from `Match` where tour = 3 and idPlanning=?");
                rset = pst.executeQuery();
                if (rset.next()){
                    if(rset.getInt(1)<8) possible = true; 
                    else texte = "Il y a déjà 8 matchs pour les quarts de final";
                }else possible = true;
            }
            
            if(md.getTour()==2){ //1/2 de final
                pst = connexionBD.prepareStatement("select count(*) from `Match` where tour = 2  and idPlanning=?");
                rset = pst.executeQuery();
                if (rset.next()){
                    if(rset.getInt(1)<4) possible = true; 
                    else texte = "Il y a déjà 4 matchs pour les demis-finals";
                }else possible = true;
            }
            
            if(md.getTour()==1){ // final
                pst = connexionBD.prepareStatement("select count(*) from `Match` where tour = 1  and idPlanning=?");
                rset = pst.executeQuery();
                if (rset.next()){
                    if(rset.getInt(1)<2) possible = true; 
                    else texte = "Il y a déjà 2 matchs pour la final";
                }else possible = true;
            }
            
            if (possible) possible = this.verifNoMatchNorReservation(md.getDateDebut(), md.getDateFin(), md.getIdPlanning());
            
            if(possible){
                
                pst = connexionBD.prepareStatement("INSERT INTO MatchSimple VALUES (?,?,?)");
                pst.setInt(1, md.getIdMatch());
                pst.setInt(2, md.getLesEquipesJoueur().get(0).getIdEquipe());
                pst.setInt(3, md.getLesEquipesJoueur().get(1).getIdEquipe());
                rowCount += pst.executeUpdate();
                pst = connexionBD.prepareStatement("INSERT INTO `Match` VALUES (?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1, md.getIdMatch());
                pst.setInt(2, md.getArbitreDeChaise().getIdArbitre());
                pst.setInt(3, md.getEquipeArbitresDeLigne().getIdEquipeAL());
                pst.setInt(4, md.getEquipeDeRamasseur().getIdEquipeR());

                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateD = sdf.format(md.getDateDebut());
                String dateF = sdf.format(md.getDateFin());

                pst.setString(5, dateD);
                pst.setString(6, dateF);
                pst.setInt(7, md.getCourt().getIdCourt());
                pst.setInt(8, md.getIdGagnant());
                pst.setInt(9, md.getTour());
                pst.setInt(10, md.getIdPlanning());
                rowCount += pst.executeUpdate();

                ScoreMatchDAO sDAO = new ScoreMatchDAO(connexionBD);
                rowCount += sDAO.create(md.getScore());
            }else {
                JOptionPane.showMessageDialog(null, texte);
            }
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
    public ArrayList<MatchDouble> findAll(int idPlanning) throws SQLException {
        PreparedStatement pst = null;
        ArrayList<MatchDouble> lesMatchDouble = new ArrayList<>();
        try{
            pst = connexionBD.prepareStatement("SELECT idMatchDouble from MatchDouble where idPlanning = ?");
            pst.setInt(1, idPlanning);
            ResultSet rset = pst.executeQuery();
            while (rset.next()){
                MatchDouble ms = this.findById(rset.getInt(1));
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

        //fonction qui vérifie si les dates d'un match que l'on souhaite insérer ne sont pas prises par une réservation ou un autre match dans un planning
    public boolean verifNoMatchNorReservation(Date dateDMD, Date dateFMD, int idPlanning) throws SQLException{
        boolean bool = true;
        PreparedStatement pst = null;
        ResultSet rset;
        try{
            pst = connexionBD.prepareStatement("select count(*) from `Match` where idPlanning = ? "
                    + "and ((dateDebutM<? and dateFinM>?) "  //si les dates du match à ajouter se trouve entre deux autres dates d'un match
                    + "or (dateDebutM>? and dateFinM>?) "  //si la date de fin du match à ajouter se trouve entre les deux autres dates d'un match
                    + "or (dateFinM<? and dateDebutM<?));");  //si la date de début du match à ajouter se trouve entre les deux autres dates d'un match
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateD = sdf.format(dateDMD);
            String dateF = sdf.format(dateFMD);
            pst.setInt(1, idPlanning);
            
            pst.setString(1, dateD);
            pst.setString(2, dateF);
            
            pst.setString(3, dateF);
            pst.setString(4, dateF);
            
            pst.setString(5, dateD);
            pst.setString(6, dateD);
            
            rset = pst.executeQuery();
            if (rset.next()){
                bool = false;  //s'il y a un résultat alors on renvoie qu'on ne peut ajouter le match
            }  
            else{ //sinon on fait les mêmes tests avec les réservations d'entrainement
                    
                    pst = connexionBD.prepareStatement("select count(*) from ReservationEntrainement where idPlanning = ? "
                    + "and ((dateDebutR<? and dateFinR>?) " 
                    + "or (dateDebutR>? and dateFinR>?) "  
                    + "or (dateFinR<? and dateDebutR<?));");
                            pst.setInt(1, idPlanning);
            
                    pst.setString(1, dateD);
                    pst.setString(2, dateF);

                    pst.setString(3, dateF);
                    pst.setString(4, dateF);

                    pst.setString(5, dateD);
                    pst.setString(6, dateD);

                    rset = pst.executeQuery();
                    if (rset.next()){
                        bool = false;  //s'il y a un résultat alors on renvoie qu'on ne peut ajouter le match
                    }else bool = true; 
                }
        }catch (SQLException exc) {
            throw exc;
        }
        return bool;
        
    }
    
}
