package model.interfaces;

import java.sql.SQLException;
import java.util.List;
import classesJava.ArbitreDeLigne;


public interface InterfaceArbitreDeLigneDAO {
    public List<ArbitreDeLigne> findAll() throws SQLException;
    public ArbitreDeLigne findbyId(int noArbitre) throws SQLException;
    public int create (ArbitreDeLigne a) throws SQLException;
    public int update (ArbitreDeLigne a) throws SQLException;
    public int delete(ArbitreDeLigne a) throws SQLException;
}