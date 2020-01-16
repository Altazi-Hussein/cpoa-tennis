/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import classesJava.EquipeRamasseur;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author p1806052
 */
public interface InterfaceEquipeRamasseurDAO {
    public ArrayList<EquipeRamasseur> findAll() throws SQLException;
    public EquipeRamasseur findById(int idEquipe) throws SQLException;
}
