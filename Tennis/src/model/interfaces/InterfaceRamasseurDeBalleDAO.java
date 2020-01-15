package model.interfaces;

import java.sql.SQLException;
import classesJava.RamasseurDeBalle;
import java.util.ArrayList;


public interface InterfaceRamasseurDeBalleDAO {
    public ArrayList<RamasseurDeBalle> findAll() throws SQLException;
    public RamasseurDeBalle findbyId(int noArbitre) throws SQLException;
    public int create (RamasseurDeBalle a) throws SQLException;
    public int update (RamasseurDeBalle a) throws SQLException;
    public int delete(RamasseurDeBalle a) throws SQLException;
}