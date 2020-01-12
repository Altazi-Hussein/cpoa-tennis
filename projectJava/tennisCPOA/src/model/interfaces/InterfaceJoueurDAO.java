package model.interfaces;

import java.sql.SQLException;
import java.util.List;
import classesJava.Joueur;

public interface InterfaceJoueurDAO {
    public List<Joueur> findAll() throws SQLException;
    public Joueur findById(int idJoueur) throws SQLException;
    public int create (Joueur j) throws SQLException;
    public int update (Joueur j) throws SQLException;
    public int delete(Joueur j) throws SQLException;
}