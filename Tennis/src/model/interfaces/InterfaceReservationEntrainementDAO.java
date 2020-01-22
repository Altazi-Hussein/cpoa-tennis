/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import classesJava.ReservationEntrainement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author angel
 */
public interface InterfaceReservationEntrainementDAO {
    public ArrayList<ReservationEntrainement> findAll() throws SQLException;
    public ReservationEntrainement findById(int idReservationEntrainement) throws SQLException;
    public boolean verifNoMatchNorReservation(Date dateDMS, Date dateFMS, int idPlanning) throws SQLException;
    public int create (ReservationEntrainement res) throws SQLException;
    public int update (ReservationEntrainement res) throws SQLException;
    public int delete(ReservationEntrainement res) throws SQLException;
}
