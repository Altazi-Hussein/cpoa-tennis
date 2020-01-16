package model.interfaces;

import classesJava.EquipeJoueur;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceEquipeJoueurDAO {
    public ArrayList<EquipeJoueur> findAll() throws SQLException;
    public EquipeJoueur findById(int idEquipeJ) throws SQLException;
    public int create (EquipeJoueur e) throws SQLException;
    public int update (EquipeJoueur e) throws SQLException;
    public int delete(EquipeJoueur e) throws SQLException;
}
