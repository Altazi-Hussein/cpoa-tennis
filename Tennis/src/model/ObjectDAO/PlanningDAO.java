package model.ObjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.interfaces.InterfacePlanningDAO;
import classesJava.Planning;
import java.util.Date;

public class PlanningDAO implements InterfacePlanningDAO {

    private final Connection connexionBD;

    public PlanningDAO(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public Planning findById(int idPlanning) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        Planning p = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * from Planning WHERE idPlanning=?");
            pst.setInt(1, idPlanning);
            rset = pst.executeQuery();
            if (rset.next()) {
                Date dateD = new Date(rset.getString(2));
                Date dateF = new Date(rset.getString(3));
                p = new Planning(idPlanning, dateD, dateF, rset.getString(4));
            }
            else 
            {
                throw new SQLException ("Planning " + idPlanning + " inconnu");
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
        return p;
    }

    @Override
    public int create (Planning p) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO Planning VALUES (?,?,?,?)");
            pst.setInt(1, p.getIdPlanning());

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateD = sdf.format(p.getDateDebut());
            String dateF = sdf.format(p.getDateFin());
            
            pst.setString(2, dateD);
            pst.setString(3, dateF);
            pst.setString(4, p.getNomPlanning());
            
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
    public ArrayList<Planning> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<Planning> lesPlanning = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("SELECT * from Planning");
            while (rs.next()){
                Date dateD = new Date(rs.getString(2));
                Date dateF = new Date(rs.getString(3));
                Planning p = new Planning(rs.getInt(1), dateD, dateF, rs.getString(4));
                lesPlanning.add(p);
            }  
        }catch (SQLException exc) {
            throw exc;
        }
        return lesPlanning;
        
    }


    @Override
    public int delete(Planning p) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from Planning WHERE idPlanning=?");
            pst.setInt(1, p.getIdPlanning());
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
    public int update (Planning p) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE Planning SET dateDebutP=?, dateFinP=?, nomPlanning=? WHERE idPlanning=?");
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateD = sdf.format(p.getDateDebut());
            String dateF = sdf.format(p.getDateFin());
            
            pst.setInt(4, p.getIdPlanning());
            pst.setString(1, dateD);
            pst.setString(2, dateF);
            pst.setString(3, p.getNomPlanning());
            
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
