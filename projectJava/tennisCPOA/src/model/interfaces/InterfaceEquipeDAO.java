package model.interfaces;

import classesJava.Equipe;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceEquipeDAO {
    public List<Equipe> findAll() throws SQLException;
    public Equipe findById(int noEquipe) throws SQLException;
    public int create (Equipe e) throws SQLException;
    public int update (Equipe e) throws SQLException;
    public int delete(Equipe e) throws SQLException;
}
