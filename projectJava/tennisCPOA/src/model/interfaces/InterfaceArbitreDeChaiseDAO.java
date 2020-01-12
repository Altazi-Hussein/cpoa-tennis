/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.sql.SQLException;
import java.util.List;
import classesJava.Arbitre;
import classesJava.ArbitreDeChaise;
import classesJava.Joueur;

/**
 *
 * @author 91806052
 */
public interface InterfaceArbitreDeChaiseDAO {
    public List<ArbitreDeChaise> findAll() throws SQLException;
    public ArbitreDeChaise findbyId(int noArbitre) throws SQLException;
    public int create (ArbitreDeChaise a) throws SQLException;
    public int update (ArbitreDeChaise a) throws SQLException;
    public int delete(ArbitreDeChaise a) throws SQLException;
}