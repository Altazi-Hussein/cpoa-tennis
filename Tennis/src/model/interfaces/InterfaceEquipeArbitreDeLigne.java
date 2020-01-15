/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import classesJava.EquipeArbitreDeLigne;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
public interface InterfaceEquipeArbitreDeLigne {
    public ArrayList<EquipeArbitreDeLigne> findAll() throws SQLException;
    public EquipeArbitreDeLigne findById(int idEquipe) throws SQLException;
}
