package model.interfaces;

import java.sql.SQLException;
import java.util.List;
import classesJava.ArbitreDeChaise;

public interface InterfaceArbitreDeChaiseDAO {
    public List<ArbitreDeChaise> findAll() throws SQLException;
    public ArbitreDeChaise findbyId(int noArbitre) throws SQLException;
    public int create (ArbitreDeChaise a) throws SQLException;
    public int update (ArbitreDeChaise a) throws SQLException;
    public int delete(ArbitreDeChaise a) throws SQLException;
}