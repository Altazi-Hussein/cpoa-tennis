/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import classesJava.ScoreMatch;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public interface InterfaceScoreMatchDAO {
    public ArrayList<ScoreMatch> findAll() throws SQLException;
    public ScoreMatch findById(int idScoreMatch) throws SQLException;
    public int create (ScoreMatch sm) throws SQLException;
    public int update (ScoreMatch sm) throws SQLException;
    public int delete(ScoreMatch sm) throws SQLException;
}
