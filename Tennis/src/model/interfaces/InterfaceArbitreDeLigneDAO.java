package model.interfaces;

import java.sql.SQLException;
import classesJava.ArbitreDeLigne;
import java.util.ArrayList;


public interface InterfaceArbitreDeLigneDAO {
    public ArrayList<ArbitreDeLigne> findAll() throws SQLException;
    public ArbitreDeLigne findbyId(int noArbitre) throws SQLException;
    public int create (ArbitreDeLigne a) throws SQLException;
    public int update (ArbitreDeLigne a) throws SQLException;
    public int delete(ArbitreDeLigne a) throws SQLException;
}