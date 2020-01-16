/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import classesJava.MatchDouble;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public interface InterfaceMatchDoubleDAO {
    public ArrayList<MatchDouble> findAll() throws SQLException;
    public MatchDouble findById(int idMatchDouble) throws SQLException;
    public int create (MatchDouble md) throws SQLException;
    public int update (MatchDouble md) throws SQLException;
    public int delete(MatchDouble md) throws SQLException;
}
