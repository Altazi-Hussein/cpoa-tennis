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
        int rowCount;
        PreparedStatement pst = null;
        try {
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

}
