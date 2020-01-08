/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.List;
import planning.Arbitre;
/**
 *
 * @author 91806052
 */
public interface InterfaceJoueurDAO {
    public List<Arbitre> findAllArbitre() throws SQLException;
    public Arbitre findArbitreById(int noArbitre) throws SQLException;
    public int deleteArbitre (Arbitre j) throws SQLException;
    public int updateArbitre (Arbitre j) throws SQLException;
    public int createArbitre (Arbitre j) throws SQLException;
}