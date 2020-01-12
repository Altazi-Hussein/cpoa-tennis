/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.sql.SQLException;
import java.util.List;
import classesJava.Joueur;
/**
 *
 * @author 91806052
 */
public interface InterfaceJoueurDAO {
    public List<Joueur> findAll() throws SQLException;
    public Joueur findById(int noJoueur) throws SQLException;
    public int create (Joueur j) throws SQLException;
    public int update (Joueur j) throws SQLException;
    public int delete(Joueur j) throws SQLException;
}