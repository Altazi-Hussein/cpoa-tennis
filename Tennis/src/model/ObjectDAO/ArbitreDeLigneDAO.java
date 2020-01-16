package model.ObjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import classesJava.ArbitreDeLigne;
import model.interfaces.InterfaceArbitreDeLigneDAO;


public class ArbitreDeLigneDAO implements InterfaceArbitreDeLigneDAO {

    private final Connection connexionBD;

    public ArbitreDeLigneDAO(Connection c) {
        this.connexionBD = c;
    }

    public ArbitreDeLigne findbyId(int idArbitre) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        ArbitreDeLigne a = null;
        try {
            pst = connexionBD.prepareStatement("SELECT idArbitreL, idEquipeL, nom, prenom, nationalite, categorie FROM ArbitreDeLigne join Arbitre on idArbitreL=idArbitre WHERE idArbitre = ?");
            pst.setInt(1, idArbitre);
            rset = pst.executeQuery();
            if (rset.next()) {
                a = new ArbitreDeLigne (rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4) ,rset.getString(5), rset.getString(6));
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
    public int create (ArbitreDeLigne a) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO ArbitreDeLigne VALUES (?,?,?,?,?,?)");
            pst.setInt(1, a.getIdArbitre());
            pst.setInt(2, a.getIdEquipeL());
            pst.setString(3, a.getNom());
            pst.setString(4, a.getPrenom());
            pst.setString(5, a.getNationalite());
            pst.setString(6, a.getCategorie());
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
    public ArrayList<ArbitreDeLigne> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<ArbitreDeLigne> lesArbitre = new ArrayList<ArbitreDeLigne>();
        try{
            ResultSet rs = st.executeQuery("SELECT * from ArbitreDeLigne");
            int no;
            int eq;
            String nom;
            String pre;
            String nat;
            String cat;
            while (rs.next()){
                no = rs.getInt(1);
                eq = rs.getInt(2);
                nom = rs.getString(3);
                pre = rs.getString(4);
                nat = rs.getString(5);
                cat = rs.getString(6);
                ArbitreDeLigne a = new ArbitreDeLigne(no, eq, nom, pre, nat, cat);
                lesArbitre.add(a);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesArbitre;

    }

    public int delete(ArbitreDeLigne a) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from ArbitreDeLigne WHERE idArbitreL=?");
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


    public int update (ArbitreDeLigne a) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE ArbitreDeLigne SET EquipeL=? WHERE idArbitreL=?");
            pst.setInt(1, a.getIdEquipeL());
            pst.setInt(2, a.getIdArbitre());
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
