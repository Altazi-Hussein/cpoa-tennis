/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import classesJava.MatchSimple;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public interface InterfaceMatchSimpleDAO {
    public ArrayList<MatchSimple> findAll() throws SQLException;
    public ArrayList<MatchSimple> findAllMatchsQualif() throws SQLException;
    public ArrayList<MatchSimple> findAllMatchsTTournoi() throws SQLException;
    public MatchSimple findById(int idMatchSimple) throws SQLException;
    public int create (MatchSimple ms) throws SQLException;
    public int update (MatchSimple ms) throws SQLException;
    public int delete(MatchSimple ms) throws SQLException;
}
