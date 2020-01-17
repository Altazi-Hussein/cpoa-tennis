/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ObjectDAO;

import classesJava.Court;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.interfaces.InterfaceCourtDAO;

/**
 *
 * @author angel
 */
public class CourtDAO implements InterfaceCourtDAO{
    
    private Connection connexionBD;

    public CourtDAO(Connection connexionBD) {
        this.connexionBD = connexionBD;
    }

    @Override
    public ArrayList<Court> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<Court> lesCourt = new ArrayList<>();
        try{
            ResultSet rs = st.executeQuery("SELECT * from Court");
            int no;
            String d;
            while (rs.next()){
                no = rs.getInt(1);
                d = rs.getString(2);
                Court j = new Court(no, d);
                lesCourt.add(j);
            }  
        }catch (SQLException exc) {
            throw exc;
        }
        return lesCourt;
    }

    @Override
    public Court findById(int idCourt) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rset;
        Court c = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * from Court WHERE idCourt=?");
            pst.setInt(1, idCourt);
            rset = pst.executeQuery();
            if (rset.next()) {
                c = new Court(idCourt, rset.getString(2));
            }
            else 
            {
                throw new SQLException ("Contact " + idCourt + " inconnu");
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
        return c;
    }

    @Override
    public ArrayList<Court> findFreeCourts(Date dateDebut, Date dateFin) throws SQLException {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateD = sdf.format(dateDebut);
        String dateF = sdf.format(dateFin);
        PreparedStatement pst = null;
        ResultSet rset;
        ArrayList<Court> lesCourt = new ArrayList<>();
        try{
            pst = connexionBD.prepareStatement("Select * from Court where idCourt NOT IN "
                    + "(SELECT Court.idCourt from Court join `Match` on `Match`.idCourt = Court.idCourt and dateDebutM<=? and dateFinM>=?) " +
"and idCourt NOT IN "
                    + "(SELECT Court.idCourt from Court join ReservationEntrainement on ReservationEntrainement.idCourt = Court.idCourt and dateDebutR<=? and dateFinR>=?) " +
"and typeCourt != 'Principal';");
            pst.setString(1, dateD);
            pst.setString(2, dateF);
            pst.setString(3, dateD);
            pst.setString(4, dateF);
            rset = pst.executeQuery();
            int no;
            String d;
            while (rset.next()){
                no = rset.getInt(1);
                d = rset.getString(2);
                Court j = new Court(no, d);
                lesCourt.add(j);
            }  
        }catch (SQLException exc) {
            throw exc;
        }
        return lesCourt;
    }
    
}
