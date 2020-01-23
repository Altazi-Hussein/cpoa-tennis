package model.ObjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.interfaces.InterfaceReservationEntrainementDAO;
import classesJava.ReservationEntrainement;
import java.util.Date;

public class ReservationEntrainementDAO implements InterfaceReservationEntrainementDAO {

    private final Connection connexionBD;

    public ReservationEntrainementDAO(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public ReservationEntrainement findById(int idReservationEntrainement) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        ReservationEntrainement res = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * from ReservationEntrainement WHERE idReservation=?");
            pst.setInt(1, idReservationEntrainement);
            rset = pst.executeQuery();
            if (rset.next()) {
                Date dateD = new Date(rset.getString(2));
                Date dateF = new Date(rset.getString(3));
                res = new ReservationEntrainement(idReservationEntrainement, dateD, dateF ,rset.getInt(4), rset.getInt(5), rset.getInt(6));
            }
            else 
            {
                throw new SQLException ("Contact " + idReservationEntrainement + " inconnu");
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
        return res;
    }

    @Override
    public int create (ReservationEntrainement res) throws SQLException {
        int rowCount = 0;
        PreparedStatement pst = null;
        boolean possible = true;
        try {
            
            possible = this.verifNoMatchNorReservation(res.getDateDebutR(), res.getDateFinR(), res.getIdPlanning());
            if (possible) {
                pst = connexionBD.prepareStatement("INSERT INTO ReservationEntrainement VALUES (?,?,?,?,?)");
                pst.setInt(1, res.getIdReservation());
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateD = sdf.format(res.getDateDebutR());
                String dateF = sdf.format(res.getDateFinR());
                pst.setString(2, dateD);
                pst.setString(3, dateF);
                pst.setInt(4, res.getIdCourt());
                pst.setInt(5, res.getIdJoueur());
                pst.setInt(6, res.getIdPlanning());
                rowCount = pst.executeUpdate();
            }else JOptionPane.showMessageDialog(null, "Insértion impossible car il y a un match/une reservation à ces mêmes horaires");

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
    public ArrayList<ReservationEntrainement> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<ReservationEntrainement> lesReservationEntrainement = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("SELECT * from Reservation");
            int idRes;
            Date dateD;
            Date dateF;
            int idC;
            int idJ;
            int idP;
            while (rs.next()){
                idRes = rs.getInt(1);
                dateD = new Date(rs.getString(4));
                dateF = new Date(rs.getString(5));
                idC = rs.getInt(4);
                idJ = rs.getInt(5);
                idP = rs.getInt(6);

                ReservationEntrainement res = new ReservationEntrainement(idRes, dateD, dateF, idC, idJ, idP);
                lesReservationEntrainement.add(res);
            }  
        }catch (SQLException exc) {
            throw exc;
        }
        return lesReservationEntrainement;
        
    }


    @Override
    public int delete(ReservationEntrainement res) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from ReservationEntrainement WHERE idReservation=?");
            pst.setInt(1, res.getIdReservation());
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
    public int update (ReservationEntrainement res) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE ReservationEntrainement SET dateDebutR=?, dateFinR=?, idCourt=?, idJoueur=?, idPlanning=? WHERE idReservation=?");
            pst.setInt(6, res.getIdReservation());
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateD = sdf.format(res.getDateDebutR());
            String dateF = sdf.format(res.getDateFinR());
            pst.setString(1, dateD);
            pst.setString(2, dateF);
            pst.setInt(3, res.getIdCourt());
            pst.setInt(4, res.getIdJoueur());
            pst.setInt(5, res.getIdPlanning());
            rowCount = pst.executeUpdate();
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

    //fonction qui vérifie si les dates d'une réservation que l'on souhaite insérer ne sont pas prises par une réservation ou un autre match dans un planning
    public boolean verifNoMatchNorReservation(Date dateDR, Date dateFR, int idPlanning) throws SQLException{
        boolean bool = true;
        PreparedStatement pst = null;
        ResultSet rset;
        try{
            pst = connexionBD.prepareStatement("select count(*) from `Match` where idPlanning = ? "
                    + "and ((dateDebutM<? and dateFinM>?) "  //si les dates du match à ajouter se trouve entre deux autres dates d'un match
                    + "or (dateDebutM>? and dateFinM>?) "  //si la date de fin du match à ajouter se trouve entre les deux autres dates d'un match
                    + "or (dateFinM<? and dateDebutM<?));");  //si la date de début du match à ajouter se trouve entre les deux autres dates d'un match
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateD = sdf.format(dateDR);
            String dateF = sdf.format(dateFR);
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
