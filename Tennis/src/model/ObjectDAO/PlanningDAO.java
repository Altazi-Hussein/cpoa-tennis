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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                Date dateD = new SimpleDateFormat("yyyy-MM-dd").parse(rset.getString("dateDebutP"));
                Date dateF = new SimpleDateFormat("yyyy-MM-dd").parse(rset.getString("dateFinP"));
                p = new Planning(idPlanning, dateD, dateF, rset.getString(4));
            }
            else 
            {
                throw new SQLException ("Planning " + idPlanning + " inconnu");
            }

        } catch (SQLException exc) {
            throw exc;
        } catch (ParseException ex) {
            Logger.getLogger(PlanningDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            
            Planning pt = null;
            rowCount = 0;
            
            if(p.getIdPlanning()==0){
            
            pst = connexionBD.prepareStatement("INSERT INTO Planning VALUES (NULL,?,?,?)");

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateD = sdf.format(p.getDateDebut());
            String dateF = sdf.format(p.getDateFin());
            
            pst.setString(1, p.getNomPlanning());
            pst.setString(2, dateD);
            pst.setString(3, dateF);
            
            rowCount = pst.executeUpdate();
            }else{
                
                pt = this.findById(p.getIdPlanning());
                if (pt == null){
                    pst = connexionBD.prepareStatement("INSERT INTO Planning VALUES (?,?,?,?)");

                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dateD = sdf.format(p.getDateDebut());
                    String dateF = sdf.format(p.getDateFin());
                    pst.setInt(1, p.getIdPlanning());
                    pst.setString(2, p.getNomPlanning());
                    pst.setString(3, dateD);
                    pst.setString(4, dateF);
                    
                    rowCount = pst.executeUpdate();
                }else JOptionPane.showMessageDialog(null,"Le planning existe déjà");
                
            }
            
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null,"L'insertion du planning à echoué");
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
                Date dateD = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("dateDebutP"));
                Date dateF = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("dateFinP"));
                Planning p = new Planning(rs.getInt("idPlanning"), dateD, dateF, rs.getString("nomPlanning"));
                lesPlanning.add(p);
            }  
        }catch (SQLException exc) {
            throw exc;
        } catch (ParseException ex) {
            Logger.getLogger(PlanningDAO.class.getName()).log(Level.SEVERE, null, ex);
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
