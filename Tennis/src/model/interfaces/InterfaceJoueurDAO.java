package model.interfaces;

import java.sql.SQLException;
import classesJava.Joueur;
import java.util.ArrayList;

public interface InterfaceJoueurDAO {
    public ArrayList<Joueur> findAll() throws SQLException;
    public Joueur findById(int idJoueur) throws SQLException;
    public int create (Joueur j) throws SQLException;
    public int update (Joueur j) throws SQLException;
    public int delete(Joueur j) throws SQLException;
}