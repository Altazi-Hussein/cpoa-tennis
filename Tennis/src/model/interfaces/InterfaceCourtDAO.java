/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import classesJava.Court;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author angel
 */
public interface InterfaceCourtDAO {
    public ArrayList<Court> findAll() throws SQLException;
    public Court findById(int idCourt) throws SQLException;
    public ArrayList<Court> findFreeCourts(Date dateDebut, Date dateFin) throws SQLException;
}
