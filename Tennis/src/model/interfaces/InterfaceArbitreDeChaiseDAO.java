package model.interfaces;

import java.sql.SQLException;
import java.util.List;
import classesJava.ArbitreDeChaise;
import classesJava.EquipeJoueur;
import classesJava.Joueur;

public interface InterfaceArbitreDeChaiseDAO {
    public List<ArbitreDeChaise> findAll() throws SQLException;
    public ArbitreDeChaise findbyId(int idArbitreC) throws SQLException;
    public List<ArbitreDeChaise> findArbitresLibresNationaliteMS(Joueur j1, Joueur j2) throws SQLException;
    public List<ArbitreDeChaise> findArbitresLibresNationaliteMD(EquipeJoueur e1, EquipeJoueur e2) throws SQLException;
    public int create (ArbitreDeChaise a) throws SQLException;
    public int update (ArbitreDeChaise a) throws SQLException;
    public int delete(ArbitreDeChaise a) throws SQLException;
}