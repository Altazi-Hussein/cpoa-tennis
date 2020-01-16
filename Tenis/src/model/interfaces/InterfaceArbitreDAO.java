/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.sql.SQLException;
import java.util.List;
import planning.Arbitre;
/**
 *
 * @author 91806052
 */
public interface InterfaceArbitreDAO {
    public List<Arbitre> findAll() throws SQLException;
    public Arbitre findbyId(int noArbitre) throws SQLException;
    public int create(Arbitre j) throws SQLException;
}