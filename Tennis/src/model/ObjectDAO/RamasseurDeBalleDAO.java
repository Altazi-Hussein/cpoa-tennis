package model.ObjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import classesJava.RamasseurDeBalle;
import model.interfaces.InterfaceRamasseurDeBalleDAO;


public class RamasseurDeBalleDAO implements InterfaceRamasseurDeBalleDAO {

    private final Connection connexionBD;

    public RamasseurDeBalleDAO(Connection c) {
        this.connexionBD = c;
    }

    public RamasseurDeBalle findbyId(int noArbitre) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        RamasseurDeBalle a = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * FROM RamasseurDeBalle WHERE idArbitre=?");
            pst.setInt(1, noArbitre);
            rset = pst.executeQuery();
            if (rset.next()) {
                a = new RamasseurDeBalle (rset.getInt(1), rset.getString(2), rset.getString(3) ,rset.getString(4));
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
    public int create (RamasseurDeBalle a) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO Arbitre VALUES (?,?,?,?,?)");
            pst.setInt(1, a.getIdArbitre());
            pst.setString(2, a.getNomArbitre());
            pst.setString(3, a.getPrenomArbitre());
            pst.setString(4, a.getNationaliteArbitre());
            pst.setString(5, a.getCategorieArbitre());
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
    public ArrayList<RamasseurDeBalle> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<RamasseurDeBalle> lesArbitre = new ArrayList<RamasseurDeBalle>();
        try{
            ResultSet rs = st.executeQuery("SELECT * from RamasseurDeBalle");
            int no;
            String nom;
            String pre;
            String nat;
            String cat;
            while (rs.next()){
                no = rs.getInt(1);
                nom = rs.getString(2);
                pre = rs.getString(3);
                nat = rs.getString(4);
                cat = rs.getString(5);
                RamasseurDeBalle a = new RamasseurDeBalle(no, nom, pre, nat, cat);
                lesArbitre.add(a);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesArbitre;

    }

    public int delete(RamasseurDeBalle a) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from Joueur WHERE idArbitre=?");
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


    public int update (RamasseurDeBalle a) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE RamasseurDeBalle SET prenomArbitre=?, nomArbitre=?, nationaliteArbitre=?, categorieArbitre=? WHERE idArbitre=?");
            pst.setString(1, a.getPrenomArbitre());
            pst.setString(2, a.getNomArbitre());
            pst.setString(3, a.getNationaliteArbitre());
            pst.setString(4, a.getCategorieArbitre());
            pst.setInt(5, a.getIdArbitre());
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
