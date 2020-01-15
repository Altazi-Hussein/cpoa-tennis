package model.interfaces;

import java.sql.SQLException;
import classesJava.RamasseurDeBalle;
import java.util.ArrayList;


public interface InterfaceRamasseurDeBalleDAO {
    public ArrayList<RamasseurDeBalle> findAll() throws SQLException;
    public RamasseurDeBalle findbyId(int noArbitre) throws SQLException;
    public int create (RamasseurDeBalle r) throws SQLException;
    public int update (RamasseurDeBalle r) throws SQLException;
    public int delete(RamasseurDeBalle r) throws SQLException;
}