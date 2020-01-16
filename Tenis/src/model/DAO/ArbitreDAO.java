/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import model.interfaces.InterfaceArbitreDAO;
import planning.Arbitre;

/**
 *
 * @author p1806052
 */
public class ArbitreDAO implements InterfaceArbitreDAO {

    private final Connection connexionBD;

    public ArbitreDAO(Connection c) {
        this.connexionBD = c;
    }

    public Arbitre findbyId(int noArbitre) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        Arbitre j = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * FROM Arbitre WHERE idArbitre=?");
            pst.setInt(1, noArbitre);
            rset = pst.executeQuery();
            if (rset.next()) {
                j = new Arbitre(rset.getInt(1), rset.getString(2), rset.getString(3) ,rset.getString(4), rset.getInt(5));
            }
            else
            {
                throw new SQLException ("Contact " + noArbitre + " inconnu");
            }

        } catch (SQLException exc) {
            throw exc;
        } finally {
            try {
                // la clause finally est toujours executée, quoi qu'il arrive
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException exc) {
                throw exc;
            }
        }
        return j;
    }

    @Override
    public int create (Arbitre j) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO Arbitre VALUES (?,?,?,?)");
            pst.setInt(1, j.getIdArbitre());
            pst.setString(2, j.getNomArbitre());
            pst.setString(3, j.getPrenomArbitre());
            pst.setString(4, j.getNationaliteArbitre());
            rowCount = pst.executeUpdate();

        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Code d'erreur : "+ exc.getErrorCode() +"\nMessage d'erreur : "+ exc.getMessage());
            throw exc;
        } finally {
            try {
                // la clause finally est toujours executée, quoi qu'il arrive
                if (pst != null) {
                    pst.close();

                }
            } catch (SQLException exc) {
                throw exc;
            }
        }
        return rowCount;
    }

    @Override
    public List<Arbitre> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<Arbitre> lesArbitre = new ArrayList<Arbitre>();
        try{
            ResultSet rs = st.executeQuery("SELECT * from Arbitre");
            int no;
            String nom;
            String pre;
            String nat;
            int type;
            while (rs.next()){
                no = rs.getInt(1);
                nom = rs.getString(2);
                pre = rs.getString(3);
                nat = rs.getString(4);
                type = rs.getInt(5);
                Arbitre j = new Arbitre(no, nom, pre, nat, type);
                lesArbitre.add(j);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesArbitre;

    }

}
