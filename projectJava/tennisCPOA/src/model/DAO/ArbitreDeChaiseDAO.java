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

import classesJava.ArbitreDeChaise;
import model.interfaces.InterfaceArbitreDeChaiseDAO;
import classesJava.Arbitre;

/**
 *
 * @author p1806052
 */
public class ArbitreDeChaiseDAO implements InterfaceArbitreDeChaiseDAO {

    private final Connection connexionBD;

    public ArbitreDeChaiseDAO(Connection c) {
        this.connexionBD = c;
    }

    public ArbitreDeChaise findbyId(int noArbitre) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        ArbitreDeChaise a = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * FROM ArbitreDeChaise WHERE idArbitre=?");
            pst.setInt(1, noArbitre);
            rset = pst.executeQuery();
            if (rset.next()) {
                a = new ArbitreDeChaise (rset.getInt(1), rset.getString(2), rset.getString(3) ,rset.getString(4), rset.getInt(5), rset.getInt(6),rset.getInt(7));
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
        return a;
    }

    @Override
    public int create (ArbitreDeChaise a) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO Arbitre VALUES (?,?,?,?)");
            pst.setInt(1, a.getIdArbitre());
            pst.setString(2, a.getNomArbitre());
            pst.setString(3, a.getPrenomArbitre());
            pst.setString(4, a.getNationaliteArbitre());
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
    public List<ArbitreDeChaise> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<ArbitreDeChaise> lesArbitre = new ArrayList<ArbitreDeChaise>();
        try{
            ResultSet rs = st.executeQuery("SELECT * from Arbitre");
            int no;
            String nom;
            String pre;
            String nat;
            int type;
            int maS, maD;
            while (rs.next()){
                no = rs.getInt(1);
                nom = rs.getString(2);
                pre = rs.getString(3);
                nat = rs.getString(4);
                type = rs.getInt(5);
                maS = rs.getInt(6);
                maD = rs.getInt(7);
                ArbitreDeChaise a = new ArbitreDeChaise(no, nom, pre, nat, type, maS, maD);
                lesArbitre.add(a);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesArbitre;

    }

}
