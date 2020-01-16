/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import classesJava.Planning;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public interface InterfacePlanningDAO {
    public ArrayList<Planning> findAll() throws SQLException;
    public Planning findById(int idPlanning) throws SQLException;
    public int create (Planning pl) throws SQLException;
    public int update (Planning pl) throws SQLException;
    public int delete(Planning pl) throws SQLException;
}
