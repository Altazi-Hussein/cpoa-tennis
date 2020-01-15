package model.ObjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

import classesJava.ArbitreDeChaise;
import java.util.ArrayList;
import model.interfaces.InterfaceArbitreDeChaiseDAO;

public class ArbitreDeChaiseDAO implements InterfaceArbitreDeChaiseDAO {

    private final Connection connexionBD;

    public ArbitreDeChaiseDAO(Connection c) {
        this.connexionBD = c;
    }

    public ArbitreDeChaise findbyId(int idArbitre) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        ArbitreDeChaise a = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * FROM ArbitreDeChaise WHERE idArbitreC=?");
            pst.setInt(1, idArbitre);
            rset = pst.executeQuery();
            if (rset.next()) {
                a = new ArbitreDeChaise (rset.getInt(1), rset.getString(2), rset.getString(3) ,rset.getString(4), rset.getString(5), rset.getInt(6),rset.getInt(7));
            }
            else
            {
                throw new SQLException ("Contact " + idArbitre + " inconnu");
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
            pst = connexionBD.prepareStatement("INSERT INTO ArbitreDeChaise VALUES (?,?,?,?,?,?,?)");
            pst.setInt(1, a.getIdArbitre());
            pst.setString(2, a.getNom());
            pst.setString(3, a.getPrenom());
            pst.setString(4, a.getNationalite());
            pst.setString(5, a.getCategorie());
            pst.setInt(6, a.getNbMatchSimple());
            pst.setInt(7, a.getNbMatchDouble());
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
            ResultSet rs = st.executeQuery("SELECT * from ArbitreDeChaise");
            int no;
            String nom;
            String pre;
            String nat;
            String cat;
            int maS, maD;
            while (rs.next()){
                no = rs.getInt(1);
                nom = rs.getString(2);
                pre = rs.getString(3);
                nat = rs.getString(4);
                cat = rs.getString(5);
                maS = rs.getInt(6);
                maD = rs.getInt(7);
                ArbitreDeChaise a = new ArbitreDeChaise(no, nom, pre, nat, cat, maS, maD);
                lesArbitre.add(a);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesArbitre;

    }

    public int delete(ArbitreDeChaise a) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from ArbitreDeChaise WHERE idArbitreC=?");
            pst.setInt(1, a.getIdArbitre());
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


    public int update (ArbitreDeChaise a) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE ArbitreDeChaise SET prenomC=?, nomC=?, nationaliteC=?, categorieC=?, nbMatchSimple=?, nbMatchDouble=? WHERE idArbitreC=?");
            pst.setString(1, a.getPrenom());
            pst.setString(2, a.getNom());
            pst.setString(3, a.getNationalite());
            pst.setString(4, a.getCategorie());
            pst.setInt(5, a.getNbMatchSimple());
            pst.setInt(6, a.getNbMatchDouble());
            pst.setInt(7, a.getIdArbitre());
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

}
